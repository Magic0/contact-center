package com.bbva.pzic.contactcenter.business.dto;

import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;

import java.util.List;

public class DTOIntContactCenterConversations {
    private List<ContactCenterConversationsOutput> data;

    public List<ContactCenterConversationsOutput> getData() {
        return data;
    }

    public void setData(List<ContactCenterConversationsOutput> data) {
        this.data = data;
    }
}
