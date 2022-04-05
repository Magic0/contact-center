package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationRequest;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationResponse;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;


import java.util.List;

public interface IRestListContactCenterConversations {
    ModelConversationRequest mapIn(InputContactCenterConversations input);

    List<ContactCenterConversationsOutput> mapOut(ModelConversationResponse model);
}
