package com.bbva.pzic.contactcenter.facade.v0.dto;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "conversationItem", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "conversationItem", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConversationItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Application application;
    private Phone phone;
    @DatoAuditable(omitir = true)
    private String contractId;
    private ParticipantItem participant;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public ParticipantItem getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantItem participant) {
        this.participant = participant;
    }
}
