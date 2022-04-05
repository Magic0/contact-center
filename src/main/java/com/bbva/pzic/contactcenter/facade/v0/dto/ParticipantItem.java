package com.bbva.pzic.contactcenter.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "participantItem", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "participantItem", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
