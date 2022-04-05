package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ConversationModelRequest;

public interface IRestModifyPartialContactCenterConversationMapper {

    ConversationModelRequest mapIn(InputModifyPartialContactCenterConversation input);
}
