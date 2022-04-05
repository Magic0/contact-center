package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ConversationModelRequest;

public interface IRestCreateConversationMapper {

    ConversationModelRequest mapIn(InputCreateConversation input);
}
