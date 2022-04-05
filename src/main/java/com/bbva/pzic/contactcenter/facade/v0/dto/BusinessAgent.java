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
@XmlRootElement(name = "businessAgent", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "businessAgent", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusinessAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Phone number of the Business agent.
     */
    private String phoneNumber;

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
