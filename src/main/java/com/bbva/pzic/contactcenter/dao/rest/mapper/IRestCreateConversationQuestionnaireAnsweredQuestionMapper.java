package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnaireModelRequest;

/**
 * Created on 28/10/2020.
 *
 * @author Entelgy.
 */
public interface IRestCreateConversationQuestionnaireAnsweredQuestionMapper {

    ConversationQuestionnaireModelRequest mapIn(InputCreateConversationQuestionnaireAnsweredQuestion input);

}
