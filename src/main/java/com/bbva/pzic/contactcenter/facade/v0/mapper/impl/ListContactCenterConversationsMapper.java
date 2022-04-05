package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;
import com.bbva.pzic.contactcenter.facade.v0.mapper.IListContactCenterConversationsMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListContactCenterConversationsMapper implements IListContactCenterConversationsMapper {
    private static final Log LOG = LogFactory
            .getLog(ListContactCenterConversationsMapper.class);

    @Override
    public InputContactCenterConversations mapIn(final String participantId, final String fromDate, final String toDate, final Boolean hasContract) {
        InputContactCenterConversations dtoIn = new InputContactCenterConversations();
        dtoIn.setParticipantId(participantId);
        dtoIn.setFromDate(fromDate);
        dtoIn.setToDate(toDate);
        dtoIn.setHasContract(hasContract);
        return dtoIn;
    }

    @Override
    public ServiceResponse<List<ContactCenterConversationsOutput>> mapOut(List<ContactCenterConversationsOutput> outputList) {
        LOG.info("... called method RestContactCenterConversationsMapper.mapOut ...");
        if (CollectionUtils.isEmpty(outputList)){
            return null;
        }
        return ServiceResponse.data(outputList).build();
    }
}
