package com.bbva.pzic.contactcenter.facade.v0.dto;

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
@XmlRootElement(name = "answer", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "answer", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Value of the selected answer.
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
