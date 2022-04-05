package com.bbva.pzic.contactcenter.dao.model.questionnaires;

import java.util.List;

/**
 * Created on 21/10/2020.
 *
 * @author Entelgy.
 */
public class ConversationQuestionnaireModelRequest {

    private String idAtencion;
    private String idEncuesta;
    private List<ConversationQuestionnairesModel> preguntas;

    public String getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    public String getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(String idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public List<ConversationQuestionnairesModel> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<ConversationQuestionnairesModel> preguntas) {
        this.preguntas = preguntas;
    }
}
