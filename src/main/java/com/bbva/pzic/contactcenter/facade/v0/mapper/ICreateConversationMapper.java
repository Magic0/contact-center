package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.facade.v0.dto.Conversation;

public interface ICreateConversationMapper {

    InputCreateConversation mapIn(Conversation conversation);
}
