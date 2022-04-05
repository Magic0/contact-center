package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.facade.v0.dto.ConversationItem;
import com.bbva.pzic.contactcenter.facade.v0.mapper.IModifyPartialContactCenterConversationMapper;
import org.springframework.stereotype.Component;

@Component
public class ModifyPartialContactCenterConversationMapper implements IModifyPartialContactCenterConversationMapper {

    @Override
    public InputModifyPartialContactCenterConversation mapIn(String conversationId, ConversationItem conversationItem) {
        InputModifyPartialContactCenterConversation inputModifyPartialContactCenterConversation = new InputModifyPartialContactCenterConversation();
        inputModifyPartialContactCenterConversation.setIdLlamada(conversationId);
        if (conversationItem != null) {
            if (conversationItem.getApplication() != null) {
                inputModifyPartialContactCenterConversation.setFlujoIvr(conversationItem.getApplication().getId());
                inputModifyPartialContactCenterConversation.setVersion(conversationItem.getApplication().getVersion());
            }
            if (conversationItem.getPhone() != null) {
                inputModifyPartialContactCenterConversation.setTelefonoLlamada(conversationItem.getPhone().getNumber());
            }
            inputModifyPartialContactCenterConversation.setCodigoContrato(conversationItem.getContractId());
            if (conversationItem.getParticipant() != null) {
                inputModifyPartialContactCenterConversation.setCodigoCliente(conversationItem.getParticipant().getId());
            }
        }
        return inputModifyPartialContactCenterConversation;
    }
}
