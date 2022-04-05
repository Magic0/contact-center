package com.bbva.pzic.contactcenter.facade.v0.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@XmlRootElement(name = "campaing", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "campaing", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Campaing implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Additional information related to the campaign.
     */
    private String additionalInformation;
    /**
     * List of conditions related to the campaign.
     */
    private List<Condition> conditions;

    public String getAdditionalInformation() { return additionalInformation; }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public List<Condition> getConditions() { return conditions; }

    public void setConditions(List<Condition> conditions) { this.conditions = conditions; }
}
