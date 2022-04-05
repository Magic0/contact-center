package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.DTOIntInput;
import com.bbva.pzic.contactcenter.business.dto.DTOIntOutput;
import com.bbva.pzic.contactcenter.business.dto.DTOIntStep;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationAction;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelDataRequest;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelDataResponse;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationActionMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RestCreateConversationActionMapper implements IRestCreateConversationActionMapper {

    @Override
    public ConversationActionModelRequest mapIn(final InputCreateConversationAction input) {
       ConversationActionModelRequest conversationActionModelRequest = new ConversationActionModelRequest();
       conversationActionModelRequest.setConversation_id(input.getConversationId());
       if(input.getAction() != null) {
           conversationActionModelRequest.setStep(mapInStep(input.getAction().getStep()));
           conversationActionModelRequest.setData_request(mapInData_Request(input.getAction().getInputs()));
           conversationActionModelRequest.setData_response(mapInData_Response(input.getAction().getOutputs()));
       }
       return conversationActionModelRequest;
    }

    private List<ConversationActionModelDataResponse> mapInData_Response(final List<DTOIntOutput> outputs) {
        if(CollectionUtils.isEmpty(outputs)) {
            return null;
        }
        return outputs.stream().filter(Objects::nonNull).map(this::mapInData_Response).collect(Collectors.toList());
    }

    private ConversationActionModelDataResponse mapInData_Response(final DTOIntOutput output) {
        ConversationActionModelDataResponse conversationActionModelDataResponse = new ConversationActionModelDataResponse();
        conversationActionModelDataResponse.setId(output.getId());
        conversationActionModelDataResponse.setValue(output.getValue());
        return  conversationActionModelDataResponse;
    }

    private List<ConversationActionModelDataRequest> mapInData_Request(final List<DTOIntInput> inputs) {
        if(CollectionUtils.isEmpty(inputs)){
            return null;
        }
        return inputs.stream().filter(Objects::nonNull).map(this::mapInData_Request).collect(Collectors.toList());
    }

    private ConversationActionModelDataRequest mapInData_Request(final DTOIntInput input){
        ConversationActionModelDataRequest conversationActionModelDataRequest = new ConversationActionModelDataRequest();
        conversationActionModelDataRequest.setId(input.getId());
        conversationActionModelDataRequest.setValue(input.getValue());
        return conversationActionModelDataRequest;
    }

    private String mapInStep(final DTOIntStep step) {
        if(step == null){
            return null;
        }
        return step.getId();
    }
}
