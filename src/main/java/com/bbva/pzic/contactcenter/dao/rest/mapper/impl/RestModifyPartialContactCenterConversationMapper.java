package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ConversationModelRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestModifyPartialContactCenterConversationMapper;
import org.springframework.stereotype.Component;

@Component
public class RestModifyPartialContactCenterConversationMapper implements IRestModifyPartialContactCenterConversationMapper {

    @Override
    public ConversationModelRequest mapIn(InputModifyPartialContactCenterConversation input) {
        ConversationModelRequest inConversationModelRequest = new ConversationModelRequest();
        inConversationModelRequest.setIdLlamada(input.getIdLlamada());
        inConversationModelRequest.setFlujoIvr(input.getFlujoIvr());
        inConversationModelRequest.setVersion(input.getVersion());
        inConversationModelRequest.setTelefonoLlamada(input.getTelefonoLlamada());
        inConversationModelRequest.setCodigoContrato(input.getCodigoContrato());
        inConversationModelRequest.setCodigoCliente(input.getCodigoCliente());
        return inConversationModelRequest;
    }
}
