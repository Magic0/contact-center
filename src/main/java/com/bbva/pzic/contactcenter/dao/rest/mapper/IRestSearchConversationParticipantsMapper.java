package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsRequest;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsResponse;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;

import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public interface IRestSearchConversationParticipantsMapper {

    ModelSearchConversationParticipantsRequest mapIn(InputSearchConversationParticipants input);

    List<ParticipantSearchOutput> mapOut(ModelSearchConversationParticipantsResponse model);
}
