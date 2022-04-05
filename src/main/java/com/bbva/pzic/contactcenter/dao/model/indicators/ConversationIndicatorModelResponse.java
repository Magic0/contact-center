package com.bbva.pzic.contactcenter.dao.model.indicators;

import com.bbva.jee.arq.spring.core.servicing.gce.xml.instance.Message;

import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class ConversationIndicatorModelResponse {

    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
