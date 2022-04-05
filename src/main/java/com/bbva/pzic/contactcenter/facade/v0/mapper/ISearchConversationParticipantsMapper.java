package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchInput;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;

import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public interface ISearchConversationParticipantsMapper {

    InputSearchConversationParticipants mapIn(ParticipantSearchInput input);

    ServiceResponse<List<ParticipantSearchOutput>> mapOut(List<ParticipantSearchOutput> outputList);
}
