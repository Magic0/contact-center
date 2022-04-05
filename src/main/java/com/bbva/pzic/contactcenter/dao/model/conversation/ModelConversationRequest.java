package com.bbva.pzic.contactcenter.dao.model.conversation;

public class ModelConversationRequest {

    private String codCliente;

    private String fromDate;

    private String toDate;

    private Boolean hasContract;

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

    public String getCodCliente() { return codCliente; }

    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }
}
