package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

public class DTOIntParticipant {

    @NotNull(groups = ValidationGroup.CreateConversation.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
