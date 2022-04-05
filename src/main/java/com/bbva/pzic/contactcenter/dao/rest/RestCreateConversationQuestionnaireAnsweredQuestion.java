package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnaireModelRequest;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnaireModelResponse;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationQuestionnaireAnsweredQuestionMapper;
import com.bbva.pzic.contactcenter.facade.RegistryIds;
import com.bbva.pzic.contactcenter.util.connection.rest.RestPostConnection;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 21/10/2020.
 *
 * @author Entelgy.
 */
@Component
public class RestCreateConversationQuestionnaireAnsweredQuestion extends RestPostConnection<ConversationQuestionnaireModelRequest, ConversationQuestionnaireModelResponse> {

    private static final String URL_PROPERTY = "servicing.smc.configuration.SMGG20203822.backend.url";
    private static final String URL_PROPERTY_PROXY = "servicing.smc.configuration.SMGG20203822.backend.proxy";

    private Translator translator;

    @Autowired
    private IRestCreateConversationQuestionnaireAnsweredQuestionMapper mapper;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @PostConstruct
    public void init() {
        useProxy = Boolean.parseBoolean(translator.translate(URL_PROPERTY_PROXY, "false"));
    }

    public void perform(final InputCreateConversationQuestionnaireAnsweredQuestion input) {
        connect(URL_PROPERTY, mapper.mapIn(input));
    }

    @Override
    protected void evaluateResponse(ConversationQuestionnaireModelResponse response, int statusCode) {
        evaluateMessagesResponse(response.getMessages(), RegistryIds.SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_QUESTIONNAIRE_ANSWERED_QUESTION, statusCode);
    }
}
