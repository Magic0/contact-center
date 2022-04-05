package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class InputSearchConversationParticipants {

    @Size(max = 30,groups = ValidationGroup.SearchConversationParticipants.class)
    private String id;

    @Valid
    private DTOIntPhone phone;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public DTOIntPhone getPhone() { return phone; }

    public void setPhone(DTOIntPhone phone) { this.phone = phone; }
}
