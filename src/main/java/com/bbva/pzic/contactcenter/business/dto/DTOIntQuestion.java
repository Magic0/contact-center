package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created on 28/10/2020.
 *
 * @author Entelgy.
 */
public class DTOIntQuestion {

    @NotNull(groups = ValidationGroup.CreateConversationQuestionnaireAnsweredQuestion.class)
    private String id;
    @NotNull(groups = ValidationGroup.CreateConversationQuestionnaireAnsweredQuestion.class)
    @Valid
    private DTOIntAnswer answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(DTOIntAnswer answer) {
        this.answer = answer;
    }

}
