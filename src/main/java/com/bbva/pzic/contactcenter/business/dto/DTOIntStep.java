package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class DTOIntStep {

    @NotNull(groups = ValidationGroup.CreateConversationAction.class)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
