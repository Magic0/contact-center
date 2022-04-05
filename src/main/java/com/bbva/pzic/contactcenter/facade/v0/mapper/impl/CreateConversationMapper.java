package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.DTOIntApplication;
import com.bbva.pzic.contactcenter.business.dto.DTOIntParticipant;
import com.bbva.pzic.contactcenter.business.dto.DTOIntPhone;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.dao.rest.mapper.impl.RestCreateConversationMapper;
import com.bbva.pzic.contactcenter.facade.v0.dto.Application;
import com.bbva.pzic.contactcenter.facade.v0.dto.Conversation;
import com.bbva.pzic.contactcenter.facade.v0.dto.Participant;
import com.bbva.pzic.contactcenter.facade.v0.dto.Phone;
import com.bbva.pzic.contactcenter.facade.v0.mapper.ICreateConversationMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateConversationMapper implements ICreateConversationMapper {

    private static final Log LOG = LogFactory.getLog(RestCreateConversationMapper.class);

    @Override
    public InputCreateConversation mapIn(final Conversation conversation) {
        LOG.info("... called method CreateConversationMapper.mapIn ...");
        InputCreateConversation input = new InputCreateConversation();
        input.setExternalId(conversation.getExternalId());
        input.setApplication(mapInApplication(conversation.getApplication()));
        input.setParticipant(mapInParticipant(conversation.getParticipant()));
        input.setPhone(mapInPhone(conversation.getPhone()));
        input.setContractId(conversation.getContractId());
        return input;
    }

    private DTOIntPhone mapInPhone(final Phone phone) {
        if (phone == null) {
            return null;
        }
        DTOIntPhone input = new DTOIntPhone();
        input.setNumber(phone.getNumber());
        return input;
    }

    private DTOIntParticipant mapInParticipant(final Participant participant) {
        if (participant == null) {
            return null;
        }
        DTOIntParticipant input = new DTOIntParticipant();
        input.setId(participant.getId());
        return input;
    }

    private DTOIntApplication mapInApplication(final Application application) {
        if (application == null) {
            return null;
        }
        DTOIntApplication input = new DTOIntApplication();
        input.setId(application.getId());
        input.setVersion(application.getVersion());
        return input;
    }
}
