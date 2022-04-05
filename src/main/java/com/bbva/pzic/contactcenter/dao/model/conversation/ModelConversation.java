package com.bbva.pzic.contactcenter.dao.model.conversation;

public class ModelConversation {
    private String idLlamada;

    private String flujoIvr;

    private String version;

    private String telefonoLlamada;

    private String codigoContrato;

    private String fechaCreacion;

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

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
}
