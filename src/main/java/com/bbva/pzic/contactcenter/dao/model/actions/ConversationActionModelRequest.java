package com.bbva.pzic.contactcenter.dao.model.actions;

import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class ConversationActionModelRequest {

    private String conversation_id;
    private String step;
    private List<ConversationActionModelDataRequest> data_request;
    private List<ConversationActionModelDataResponse> data_response;

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public List<ConversationActionModelDataRequest> getData_request() {
        return data_request;
    }

    public void setData_request(List<ConversationActionModelDataRequest> data_request) {
        this.data_request = data_request;
    }

    public List<ConversationActionModelDataResponse> getData_response() {
        return data_response;
    }

    public void setData_response(List<ConversationActionModelDataResponse> data_response) {
        this.data_response = data_response;
    }
}
