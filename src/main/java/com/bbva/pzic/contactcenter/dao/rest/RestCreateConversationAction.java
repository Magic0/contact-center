package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationAction;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelRequest;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelResponse;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationActionMapper;
import com.bbva.pzic.contactcenter.util.connection.rest.RestPostConnection;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.bbva.pzic.contactcenter.facade.RegistryIds.SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_ACTION;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@Component
public class RestCreateConversationAction  extends RestPostConnection<ConversationActionModelRequest, ConversationActionModelResponse>{

    private static final String URL_PROPERTY = "servicing.smc.configuration.SMGG20210024.backend.url";
    private static final String URL_PROPERTY_PROXY = "servicing.smc.configuration.SMGG20210024.backend.proxy";

    private Translator translator;

    @Autowired
    private IRestCreateConversationActionMapper mapper;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @PostConstruct
    public void init(){
        useProxy = Boolean.parseBoolean(translator.translate(URL_PROPERTY_PROXY, "false"));
    }
    public void perform(final InputCreateConversationAction input) {
        connect(URL_PROPERTY, mapper.mapIn(input));
    }

    @Override
    protected void evaluateResponse(ConversationActionModelResponse response, int statusCode) {
        evaluateMessagesResponses(response.getMessages(), SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_ACTION, statusCode);
    }
}
