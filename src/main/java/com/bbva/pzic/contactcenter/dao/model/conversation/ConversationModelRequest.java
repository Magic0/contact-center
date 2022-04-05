package com.bbva.pzic.contactcenter.dao.model.conversation;

public class ConversationModelRequest {

    private String idLlamada;

    private String flujoIvr;

    private String version;

    private String codigo;

    private String telefonoLlamada;

    private String codigoContrato;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
