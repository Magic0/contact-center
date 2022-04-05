package com.bbva.pzic.contactcenter.dao.model.searchparticipants;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class ModelSearchConversationParticipantsResponse {

    private String numero;

    private String codCliente;

    private String segmento;

    private String anexo;

    private String oferta;

    private List<ModelOpcion> opcion;

    private List<ModelCaracteristica> caracteristicas;

    private List<Message> messages;

    public String getCodCliente() { return codCliente; }

    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getSegmento() { return segmento; }

    public void setSegmento(String segmento) { this.segmento = segmento; }

    public String getAnexo() { return anexo; }

    public void setAnexo(String anexo) { this.anexo = anexo; }

    public String getOferta() { return oferta; }

    public void setOferta(String oferta) { this.oferta = oferta; }

    public List<ModelOpcion> getOpcion() { return opcion; }

    public void setOpcion(List<ModelOpcion> opcion) { this.opcion = opcion; }

    public List<ModelCaracteristica> getCaracteristicas() { return caracteristicas; }

    public void setCaracteristicas(List<ModelCaracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Message> getMessages() { return messages; }

    public void setMessages(List<Message> messages) { this.messages = messages; }

}
