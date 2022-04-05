package com.bbva.pzic.contactcenter.dao.model.questionnaires;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

/**
 * Created on 21/10/2020.
 *
 * @author Entelgy.
 */
public class ConversationQuestionnaireModelResponse {

    private List<ConversationQuestionnaireModelMessage> messages;

    public List<ConversationQuestionnaireModelMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ConversationQuestionnaireModelMessage> messages) {
        this.messages = messages;
    }
}
