package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class DTOIntIndicator {
    @NotNull(groups = ValidationGroup.ModifyConversationIndicator.class)
    private Boolean isActive;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
