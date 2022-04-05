package com.bbva.pzic.contactcenter.dao.model.indicators;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class ConversationIndicatorModelRequest {
    private String idllamada;
    private String tipo;
    private Boolean estado;

    public String getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(String idllamada) {
        this.idllamada = idllamada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
