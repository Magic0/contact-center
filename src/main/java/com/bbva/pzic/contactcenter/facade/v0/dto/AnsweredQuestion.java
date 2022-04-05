package com.bbva.pzic.contactcenter.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 16/10/2020.
 *
 * @author Entelgy.
 */
@XmlRootElement(name = "answeredQuestion", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "answeredQuestion", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnsweredQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * List of the questions that were responded by the customer.
     */
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
