package com.bbva.pzic.contactcenter.dao.model.conversation;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

public class ConversationModelResponse {

    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
