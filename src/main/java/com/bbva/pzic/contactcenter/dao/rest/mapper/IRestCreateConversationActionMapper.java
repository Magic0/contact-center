package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationAction;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelRequest;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public interface IRestCreateConversationActionMapper {

    ConversationActionModelRequest mapIn(InputCreateConversationAction input);
}
