package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.jee.arq.spring.core.rest.IRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.rest.requests.RestRequest;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestModifyPartialContactCenterConversationMapper;
import com.bbva.pzic.routine.utils.RestErrorMappingHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RestModifyPartialContactCenterConversation {

    public final String BACKEND_URL = "servicing.smc.configuration.SMGG20220324.backend.url";

    private static final Log LOG = LogFactory.getLog(RestModifyPartialContactCenterConversation.class);

    @Autowired
    private RestConnectorFactory restConnectorFactory;

    @Autowired
    protected ConfigurationManager configurationManager;

    @Autowired
    private IRestModifyPartialContactCenterConversationMapper mapper;

    @Autowired
    private RestErrorMappingHelper restErrorMappingHelper;

    public void perform(InputModifyPartialContactCenterConversation input) {

        LOG.info("------- RestModifyPartialContactCenterConversation.perform ----------");

        String url = configurationManager.getProperty(BACKEND_URL);

        IRestConnector restConnector = restConnectorFactory.getRestConnector(RestConnectorType.BASIC, "cc_ivr_call");

        RestRequest request = new RestRequest.Builder("PATCH", url)
                .payload(mapper.mapIn(input))
                .useProxy(false)
                .obfuscationMask(Arrays.asList("codigoCliente", "telefonoLlamada"))
                .build();

        RestConnectorResponse restConnectorResponse = restConnector.doRequest(request);

        restErrorMappingHelper.throwErrorIfExists(
                restConnectorResponse, "SMGG20220324", () -> "");

    }

}
