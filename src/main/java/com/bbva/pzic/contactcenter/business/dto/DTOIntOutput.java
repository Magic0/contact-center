package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class DTOIntOutput {
    @NotNull(groups = ValidationGroup.CreateConversationAction.class)
    private String id;
    @NotNull(groups = ValidationGroup.CreateConversationAction.class)
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
