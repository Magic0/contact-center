package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.facade.v0.dto.ConversationItem;

public interface IModifyPartialContactCenterConversationMapper {

    InputModifyPartialContactCenterConversation mapIn(String conversationId, ConversationItem conversationItem);
}
