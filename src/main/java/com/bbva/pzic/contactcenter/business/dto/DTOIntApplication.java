package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

public class DTOIntApplication {

    @NotNull(groups = ValidationGroup.CreateConversation.class)
    private String id;

    @NotNull(groups = ValidationGroup.CreateConversation.class)
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
