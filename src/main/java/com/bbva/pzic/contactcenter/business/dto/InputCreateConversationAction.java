package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy
 */
public class InputCreateConversationAction {

    @NotNull(groups = ValidationGroup.CreateConversationAction.class)
    private String conversationId;
    @Valid
    private DTOIntAction action;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public DTOIntAction getAction() {
        return action;
    }

    public void setAction(DTOIntAction action) {
        this.action = action;
    }
}
