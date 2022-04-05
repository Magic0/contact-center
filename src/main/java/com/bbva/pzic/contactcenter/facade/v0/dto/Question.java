package com.bbva.pzic.contactcenter.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 28/10/2020.
 *
 * @author Entelgy.
 */
@XmlRootElement(name = "question", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "question", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identifier of the question.
     */
    private String id;
    /**
     * Answer selected by the customer.
     */
    private Answer answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

}
