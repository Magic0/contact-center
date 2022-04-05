package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.dao.model.indicators.ConversationIndicatorModelRequest;
import com.bbva.pzic.contactcenter.dao.model.indicators.ConversationIndicatorModelResponse;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestModifyConversationIndicatorMapper;
import com.bbva.pzic.contactcenter.util.connection.rest.RestPutConnection;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.bbva.pzic.contactcenter.facade.RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_CONVERSATION_INDICATOR;

@Component
public class RestModifyConversationIndicator extends RestPutConnection<ConversationIndicatorModelRequest, ConversationIndicatorModelResponse> {

    private static final String URL_PROPERTY = "servicing.smc.configuration.SMGG20210025.backend.url";
    private static final String URL_PROPERTY_PROXY = "servicing.smc.configuration.SMGG20210025.backend.proxy";

    private Translator translator;

    @Autowired
    private IRestModifyConversationIndicatorMapper mapper;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @PostConstruct
    public void init() {
        useProxy = Boolean.parseBoolean(translator.translate(URL_PROPERTY_PROXY, "false"));
    }

    public void perform(final InputModifyConversationIndicator input) {
        connect(URL_PROPERTY, mapper.mapIn(input));
    }

    @Override
    protected void evaluateResponse(final ConversationIndicatorModelResponse response,final int statusCode) {
        evaluateMessagesResponses(response.getMessages(), SMC_REGISTRY_ID_OF_MODIFY_CONVERSATION_INDICATOR, statusCode);
    }

}
