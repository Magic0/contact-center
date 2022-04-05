package com.bbva.pzic.contactcenter.facade.v0.dto;

import com.bbva.jee.arq.spring.core.auditoria.DatoAuditable;

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

@XmlRootElement(name = "phone", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "phone", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Phone number.
     */
    @DatoAuditable(omitir = true)
    private String number;

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

}
