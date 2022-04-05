package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ConversationModelRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class RestCreateConversationMapper implements IRestCreateConversationMapper {

    private static final Log LOG = LogFactory.getLog(RestCreateConversationMapper.class);

    @Override
    public ConversationModelRequest mapIn(final InputCreateConversation input) {
        LOG.info("... called method RestCreateConversationMapper.mapIn ...");
        ConversationModelRequest request = new ConversationModelRequest();
        request.setIdLlamada(input.getExternalId());
        if (input.getApplication() != null) {
            request.setFlujoIvr(input.getApplication().getId());
            request.setVersion(input.getApplication().getVersion());
        }
        if (input.getParticipant() != null) {
            request.setCodigo(input.getParticipant().getId());
        }
        if (input.getPhone() != null) {
            request.setTelefonoLlamada(input.getPhone().getNumber());
        }
        request.setCodigoContrato(input.getContractId());
        return request;
    }
}
