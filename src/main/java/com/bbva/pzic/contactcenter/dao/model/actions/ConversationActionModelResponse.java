package com.bbva.pzic.contactcenter.dao.model.actions;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

public class ConversationActionModelResponse {

    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
