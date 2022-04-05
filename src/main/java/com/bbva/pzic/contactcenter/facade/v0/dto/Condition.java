package com.bbva.pzic.contactcenter.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@XmlRootElement(name = "condition", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "condition", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Condition implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Condition identifier.
     */
    private String id;
    /**
     * Condition value.
     */
    private String value;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }
}
