package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.facade.v0.dto.AnsweredQuestion;

/**
 * Created on 28/10/2020.
 *
 * @author Entelgy
 */
public interface ICreateConversationQuestionnaireAnsweredQuestionMapper {

    InputCreateConversationQuestionnaireAnsweredQuestion mapIn(String conversationId, String questionnaireId, AnsweredQuestion answeredQuestion);

}
