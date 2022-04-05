package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class DTOIntPhone {

    @NotNull(groups = {ValidationGroup.SearchConversationParticipants.class,
            ValidationGroup.CreateConversation.class})
    @Size(max = 30,groups = ValidationGroup.SearchConversationParticipants.class)
    private String number;

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

}
