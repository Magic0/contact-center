package com.bbva.pzic.contactcenter.dao.model.searchparticipants;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class ModelSearchConversationParticipantsRequest {

    private String numero;

    private String codCliente;

    public String getCodCliente() { return codCliente; }

    public void setCodCliente(String codCliente) { this.codCliente = codCliente; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }
}
