package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.business.dto.DTOIntPhone;
import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchInput;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;
import com.bbva.pzic.contactcenter.facade.v0.dto.Phone;
import com.bbva.pzic.contactcenter.facade.v0.mapper.ISearchConversationParticipantsMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@Component
public class SearchConversationParticipantsMapper implements ISearchConversationParticipantsMapper {

    private static final Log LOG = LogFactory.getLog(SearchConversationParticipantsMapper.class);

    @Override
    public InputSearchConversationParticipants mapIn(final ParticipantSearchInput input) {
        LOG.info("... called method RestSearchConversationParticipantsMapper.mapIn ...");
        InputSearchConversationParticipants dtoIn = new InputSearchConversationParticipants();
        dtoIn.setId(input.getId());
        dtoIn.setPhone(mapInPhone(input.getPhone()));
        return dtoIn;
    }

    private DTOIntPhone mapInPhone(final Phone phone) {
        if (phone == null){
            return null;
        }
        DTOIntPhone dtoIn = new DTOIntPhone();
        dtoIn.setNumber(phone.getNumber());
        return dtoIn;
    }

    @Override
    public ServiceResponse<List<ParticipantSearchOutput>> mapOut(final List<ParticipantSearchOutput> outputList) {
        LOG.info("... called method RestSearchConversationParticipantsMapper.mapOut ...");
        if (CollectionUtils.isEmpty(outputList)){
            return null;
        }
        return ServiceResponse.data(outputList).build();
    }
}
