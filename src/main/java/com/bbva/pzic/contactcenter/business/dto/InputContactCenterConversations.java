package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.Size;

public class InputContactCenterConversations {

    @Size(max = 8, groups = ValidationGroup.ContactCenterConversations.class)
    private String participantId;

    @Size(max = 19, groups = ValidationGroup.ContactCenterConversations.class)
    private String fromDate;

    @Size(max = 19, groups = ValidationGroup.ContactCenterConversations.class)
    private String toDate;

    private Boolean hasContract;

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Boolean getHasContract() {
        return hasContract;
    }

    public void setHasContract(Boolean hasContract) {
        this.hasContract = hasContract;
    }
}
