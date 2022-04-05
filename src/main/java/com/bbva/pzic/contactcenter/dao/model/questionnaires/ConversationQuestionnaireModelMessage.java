package com.bbva.pzic.contactcenter.dao.model.questionnaires;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.ErrorSeverity;
import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Parameter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created on 02/11/2020.
 *
 * @author Entelgy.
 */
public class ConversationQuestionnaireModelMessage {

    protected Integer code;
    protected String message;
    protected List<String> parameters;
    protected String type;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
