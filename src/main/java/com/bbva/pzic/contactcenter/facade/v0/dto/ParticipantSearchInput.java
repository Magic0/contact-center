package com.bbva.pzic.contactcenter.facade.v0.dto;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@XmlRootElement(name = "participantSearchInput", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "participantSearchInput", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantSearchInput implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Participant identifier. It's used only if the participant is a customer.
     * DISCLAIMER: In the request this field is required in case phoneNumber is not informed.
     */
    @DatoAuditable(omitir = true)
    private String id;
    /**
     * Phone that is used by the person to make the call.
     * DISCLAIMER: In the request this field is required in case participant is not informed.
     */
    private Phone phone;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Phone getPhone() { return phone; }

    public void setPhone(Phone phone) { this.phone = phone; }
}
