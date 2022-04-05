package com.bbva.pzic.contactcenter.util.connection;

import com.bbva.jee.arq.spring.core.rest.IProxyRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.ErrorSeverity;
import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnaireModelMessage;
import com.bbva.pzic.contactcenter.util.Errors;
import com.bbva.pzic.contactcenter.util.mappers.ObjectMapperHelper;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bbva.jee.arq.spring.core.servicing.context.ServiceInvocationContext.CALLING_CHANNEL;
import static com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.ErrorSeverity.WARNING;

/**
 * Created on 14/06/2016.
 *
 * @author Entelgy
 */
public class RestConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestConnectionProcessor.class);
    private static final String BACKEND_ID_PROPERTY = "servicing.connector.rest.backend.id";

    @Autowired
    private RestConnectorFactory restConnectorFactory;
    protected IProxyRestConnector proxyRestConnector;
    protected Boolean useProxy;
    @Autowired
    protected ConfigurationManager configurationManager;
    @Autowired
    private ServiceInvocationContext serviceInvocationContext;
    @Autowired
    private Translator translator;
    private ObjectMapperHelper mapper = ObjectMapperHelper.getInstance();

    @PostConstruct
    private void init() {
        String backend = getProperty(BACKEND_ID_PROPERTY);
        proxyRestConnector = (IProxyRestConnector) restConnectorFactory.getRestConnector(RestConnectorType.BASIC, backend);
    }

    protected String getProperty(final String property) {
        String value = configurationManager.getProperty(property);
        LOG.debug(String.format("[Rest Connector] Loaded property '%s = %s'", property, value));
        return value;
    }

    protected String buildPayload(final Object entityPayload) {
        try {
            String payload = mapper.writeValueAsString(entityPayload);
            LOG.debug("[Rest Connector] Payload=" + payload);
            return payload;
        } catch (IOException e) {
            LOG.error(String.format("Error converting JSON: %s", e.getMessage()), e);
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    protected HashMap<String, String> buildOptionalHeaders(final Map<String, String> optionalHeaders) {
        HashMap<String, String> headers = new HashMap<>();
        if (optionalHeaders != null) {
            headers.putAll(optionalHeaders);
        }

        String callingChannel = serviceInvocationContext.getProperty(CALLING_CHANNEL);

        if (callingChannel == null) {
            LOG.debug("No se han podido capturar el valor CALLING_CHANNEL");
        } else {
            LOG.debug(String.format("Se ha capturado el CALLING_CHANNEL '%s'", callingChannel));
            headers.put("callingChannel", callingChannel);
        }

        return headers;
    }

    protected <S> S buildResponse(final RestConnectorResponse rcr, final int actualTypeArgumentIndex) {
        if (rcr == null) {
            LOG.error("com.bbva.jee.arq.spring.core.rest.RestConnectorResponse is null for SocketTimeoutException");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        final Class<S> valueType = (Class<S>) actualTypeArguments[actualTypeArgumentIndex];

        if (rcr.getResponseBody() == null) {
            try {
                return valueType.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
            }
        }
        try {
            return mapper.readValue(rcr.getResponseBody(), valueType);
        } catch (IOException e) {
            LOG.error(String.format("Error converting JSON: %s", e.getMessage()));
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR, e);
        }
    }

    protected void evaluateMessagesResponse(final List<ConversationQuestionnaireModelMessage> messages, final String smcRegistryId, final int statusCode) {
        ConversationQuestionnaireModelMessage firstMessage = null;
        if (CollectionUtils.isNotEmpty(messages)) {
            firstMessage = messages.get(0);
        }
        if (firstMessage != null)
            generateMessage(firstMessage.getCode() == null ? null : String.valueOf(firstMessage.getCode()),
                    firstMessage.getMessage(),
                    firstMessage.getType() == null ? null : ErrorSeverity.valueOf(firstMessage.getType()),
                    smcRegistryId,
                    statusCode
            );
    }

    protected void evaluateMessagesResponses(final List<Message> messages, final String smcRegistryId, final int statusCode) {
        Message firstMessage = null;
        if (CollectionUtils.isNotEmpty(messages)) {
            firstMessage = messages.get(0);
        }
        if (firstMessage != null)
            generateMessage(firstMessage.getCode(), firstMessage.getMessage(), firstMessage.getType(),
                    smcRegistryId, statusCode);
    }

    private void generateMessage(final String code, final String message, final ErrorSeverity type, final String smcRegistryId, final int statusCode) {
        if (statusCode / 100 == 4 || statusCode / 100 == 5)
            generateServiceException(code, message, smcRegistryId);
        else if (statusCode / 100 == 2 && WARNING.equals(type))
            serviceInvocationContext.setWarning(code, message);
    }

    private void generateServiceException(final String code, final String message, final String smcRegistryId) {
        if (StringUtils.isEmpty(smcRegistryId)) {
            LOG.error("smcRegistryId is not defined");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        if (code == null) {
            LOG.error("backendErrorCode is not defined");
            throw new BusinessServiceException(Errors.TECHNICAL_ERROR);
        }

        String errorAlias = translator.translateErrorCode(smcRegistryId, code);
        if (errorAlias == null) {
            BusinessServiceException businessServiceException = new BusinessServiceException(Errors.FUNCTIONAL_ERROR);
            businessServiceException.setErrorCode(code);
            if (message != null) {
                businessServiceException.setErrorMessage(message);
            }
            throw businessServiceException;
        } else {
            throw new BusinessServiceException(errorAlias);
        }
    }

    protected String replacePathParamToUrl(final String url, final Map<String, String> pathParams) {
        String helpUrl = url;
        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            helpUrl = helpUrl.replace("{".concat(key).concat("}"), value);
        }
        return helpUrl;
    }
}
