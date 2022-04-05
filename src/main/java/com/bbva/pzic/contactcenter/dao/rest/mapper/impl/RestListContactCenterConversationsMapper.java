package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationRequest;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationResponse;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelCaracteristica;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestListContactCenterConversations;
import com.bbva.pzic.contactcenter.facade.v0.dto.Application;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;
import com.bbva.pzic.contactcenter.facade.v0.dto.Indicator;
import com.bbva.pzic.contactcenter.facade.v0.dto.Phone;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RestListContactCenterConversationsMapper implements IRestListContactCenterConversations {

    private static final Log LOG = LogFactory.getLog(RestSearchConversationParticipantsMapper.class);

    @Override
    public ModelConversationRequest mapIn(InputContactCenterConversations input) {
        LOG.info("... called method RestListContactCenterConversationsMapper.mapIn ...");
        ModelConversationRequest model = new ModelConversationRequest();
        model.setCodCliente(input.getParticipantId());
        model.setFromDate(input.getFromDate());
        model.setToDate(input.getToDate());
        model.setHasContract(input.getHasContract());
        return model;
    }

    @Override
    public List<ContactCenterConversationsOutput> mapOut(ModelConversationResponse model) {
        LOG.info("... called method RestListContactCenterConversationsMapper.mapOut ...");
        if(model == null) {
            return null;
        }
        List<ContactCenterConversationsOutput> list = new ArrayList<ContactCenterConversationsOutput>();
        ContactCenterConversationsOutput dtoOut = new ContactCenterConversationsOutput();
        for (ModelConversation m: model.getData()) {
            dtoOut.setId(m.getIdLlamada());
            dtoOut.setApplication(mapOutApplication(m.getVersion()));
            dtoOut.setPhone(mapOutPhone(m.getTelefonoLlamada()));
            dtoOut.setFlujoIvr(m.getFlujoIvr());
            dtoOut.setContractId(m.getCodigoContrato());
            //dtoOut.setCreationDate(m.getFechaCreacion());
            list.add(dtoOut);
        }
        return list;
    }

    private Phone mapOutPhone(final String numero) {
        if (numero == null){
            return null;
        }
        Phone dtoOut = new Phone();
        dtoOut.setNumber(numero);
        return dtoOut;
    }

    private Application mapOutApplication(final String version) {
        if (version == null){
            return null;
        }
        Application dtoOut = new Application();
        dtoOut.setVersion(version);
        return dtoOut;
    }
}
