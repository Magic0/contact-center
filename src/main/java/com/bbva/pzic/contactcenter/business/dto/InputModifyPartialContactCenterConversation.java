package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;

public class InputModifyPartialContactCenterConversation {

    @NotNull(groups = ValidationGroup.ModifyPartialContactCenterConversation.class)
    private String idLlamada;

    @NotNull(groups = ValidationGroup.ModifyPartialContactCenterConversation.class)
    private String flujoIvr;

    @NotNull(groups = ValidationGroup.ModifyPartialContactCenterConversation.class)
    private String version;

    private String telefonoLlamada;
    private String codigoContrato;

    @NotNull(groups = ValidationGroup.ModifyPartialContactCenterConversation.class)
    private String codigoCliente;

    public String getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(String idLlamada) {
        this.idLlamada = idLlamada;
    }

    public String getFlujoIvr() {
        return flujoIvr;
    }

    public void setFlujoIvr(String flujoIvr) {
        this.flujoIvr = flujoIvr;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTelefonoLlamada() {
        return telefonoLlamada;
    }

    public void setTelefonoLlamada(String telefonoLlamada) {
        this.telefonoLlamada = telefonoLlamada;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}
