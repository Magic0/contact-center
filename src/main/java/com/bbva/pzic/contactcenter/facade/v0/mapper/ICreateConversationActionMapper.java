package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationAction;
import com.bbva.pzic.contactcenter.facade.v0.dto.Action;

public interface ICreateConversationActionMapper {
    InputCreateConversationAction mapIn(String conversationId, Action action);

}
