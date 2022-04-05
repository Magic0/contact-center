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
@XmlRootElement(name = "indicator", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "indicator", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Indicator implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Indicator identifier.
     */
    private String id;
    /**
     * Indicator internal code. It's a configurable code in Contact Center.
     */
    private String internalCode;
    /**
     * Indicates whether the indicator is enabled.
     */
    private Boolean isActive;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getInternalCode() { return internalCode; }

    public void setInternalCode(String internalCode) { this.internalCode = internalCode; }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }
}
