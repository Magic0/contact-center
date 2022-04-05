package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;

import java.util.List;

public interface IListContactCenterConversationsMapper {
    InputContactCenterConversations mapIn(String participantId, String fromDate, String toDate, Boolean hasContract);

    ServiceResponse<List<ContactCenterConversationsOutput>> mapOut(List<ContactCenterConversationsOutput> outputList);
}
