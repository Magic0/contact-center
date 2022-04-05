package com.bbva.pzic.contactcenter.dao.model.conversation;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

public class ModelConversationResponse {

    private List<ModelConversation> data;

    private List<Message> messages;

    public List<ModelConversation> getData() {
        return data;
    }

    public void setData(List<ModelConversation> data) {
        this.data = data;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}

