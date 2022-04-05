package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InputCreateConversation {

    @NotNull(groups = ValidationGroup.CreateConversation.class)
    private String externalId;

    @Valid
    @NotNull(groups = ValidationGroup.CreateConversation.class)
    private DTOIntApplication application;

    @Valid
    private DTOIntParticipant participant;

    @Valid
    private DTOIntPhone phone;

    private String contractId;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public DTOIntApplication getApplication() {
        return application;
    }

    public void setApplication(DTOIntApplication application) {
        this.application = application;
    }

    public DTOIntParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(DTOIntParticipant participant) {
        this.participant = participant;
    }

    public DTOIntPhone getPhone() {
        return phone;
    }

    public void setPhone(DTOIntPhone phone) {
        this.phone = phone;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
