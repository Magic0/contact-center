package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy
 */
public class InputModifyConversationIndicator {

    private String conversationId;
    private String indicatorId;
    @NotNull(groups = ValidationGroup.ModifyConversationIndicator.class)
    @Valid
    private DTOIntIndicator indicator;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(String indicatorId) {
        this.indicatorId = indicatorId;
    }

    public DTOIntIndicator getIndicator() {
        return indicator;
    }

    public void setIndicator(DTOIntIndicator indicator) {
        this.indicator = indicator;
    }
}
