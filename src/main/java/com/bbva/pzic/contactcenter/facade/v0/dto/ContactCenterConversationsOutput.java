package com.bbva.pzic.contactcenter.facade.v0.dto;
import com.bbva.pzic.routine.commons.utils.CustomCalendarAdapter;

import java.io.Serializable;
import java.util.Calendar;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "contactCenterConversationsOutput", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlType(name = "contactCenterConversationsOutput", namespace = "urn:com:bbva:pzic:contactcenter:facade:v0:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactCenterConversationsOutput implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private Application application;

    private String flujoIvr;

    private Phone phone;

    private String contractId;

    @XmlJavaTypeAdapter(CustomCalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    private Calendar creationDate;

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getFlujoIvr() { return flujoIvr; }

    public void setFlujoIvr(String flujoIvr) { this.flujoIvr = flujoIvr; }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

}
