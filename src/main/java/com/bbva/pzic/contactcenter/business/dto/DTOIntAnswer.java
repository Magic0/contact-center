package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 21/10/2020.
 *
 * @author Entelgy.
 */
public class DTOIntAnswer {

    @NotNull(groups = ValidationGroup.CreateConversationQuestionnaireAnsweredQuestion.class)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
