package com.bbva.pzic.contactcenter.business.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created on 28/12/2018.
 *
 * @author Entelgy
 */
public class InputCreateConversationQuestionnaireAnsweredQuestion {

    private String conversationId;
    private String questionnaireId;
    @NotNull(groups = ValidationGroup.CreateConversationQuestionnaireAnsweredQuestion.class)
    @Valid
    private List<DTOIntQuestion> questions;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public List<DTOIntQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<DTOIntQuestion> questions) {
        this.questions = questions;
    }
}
