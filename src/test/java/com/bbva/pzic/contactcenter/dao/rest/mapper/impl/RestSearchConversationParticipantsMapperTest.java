package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsRequest;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsResponse;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.mock.SearchConvesationParticipantsMock;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestSearchConversationParticipantsMapper;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class RestSearchConversationParticipantsMapperTest {

    private IRestSearchConversationParticipantsMapper mapper;

    @Before
    public void setUp() {
        mapper = new RestSearchConversationParticipantsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputSearchConversationParticipants input = EntityStubs.getInstance().getInputSearchConversationParticipants();

        ModelSearchConversationParticipantsRequest result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getCodCliente());
        assertNotNull(result.getNumero());

        assertEquals(input.getId(), result.getCodCliente());
        assertEquals(input.getPhone().getNumber(), result.getNumero());
    }

    @Test
    public void mapInEmptyTest() {
        ModelSearchConversationParticipantsRequest result = mapper.mapIn(new InputSearchConversationParticipants());

        assertNotNull(result);
        assertNull(result.getCodCliente());
        assertNull(result.getNumero());
    }

    @Test
    public void mapOutFullTest() throws IOException {
        ModelSearchConversationParticipantsResponse output = SearchConvesationParticipantsMock.getInstance().buildModelSearchConversationParticipantsResponse();
        List<ParticipantSearchOutput> result = mapper.mapOut(output);

        assertNotNull(result);
        assertNotNull(result.get(0));
        assertNotNull(result.get(0).getId());
        assertNotNull(result.get(0).getPhone());
        assertNotNull(result.get(0).getPhone().getNumber());
        assertNotNull(result.get(0).getIndicators());
        assertNotNull(result.get(0).getIndicators().get(0));
        assertNotNull(result.get(0).getIndicators().get(0).getId());
        assertNotNull(result.get(0).getIndicators().get(0).getInternalCode());
        assertNotNull(result.get(0).getIndicators().get(0).getActive());
        assertNotNull(result.get(0).getIndicators().get(1));
        assertNotNull(result.get(0).getIndicators().get(1).getId());
        assertNotNull(result.get(0).getIndicators().get(1).getInternalCode());
        assertNotNull(result.get(0).getIndicators().get(1).getActive());
        assertNotNull(result.get(0).getSegment());
        assertNotNull(result.get(0).getCampaing());
        assertNotNull(result.get(0).getCampaing().getAdditionalInformation());
        assertNotNull(result.get(0).getCampaing().getConditions());
        assertNotNull(result.get(0).getCampaing().getConditions().get(0));
        assertNotNull(result.get(0).getCampaing().getConditions().get(0).getId());
        assertNotNull(result.get(0).getCampaing().getConditions().get(0).getValue());
        assertNotNull(result.get(0).getCampaing().getConditions().get(1));
        assertNotNull(result.get(0).getCampaing().getConditions().get(1).getId());
        assertNotNull(result.get(0).getCampaing().getConditions().get(1).getValue());
        assertNotNull(result.get(0).getBusinessAgent());
        assertNotNull(result.get(0).getBusinessAgent().getPhoneNumber());

        assertEquals(output.getCodCliente(), result.get(0).getId());
        assertEquals(output.getNumero(), result.get(0).getPhone().getNumber());
        assertEquals(output.getCaracteristicas().get(0).getId(), result.get(0).getIndicators().get(0).getId());
        assertEquals(output.getCaracteristicas().get(0).getTipo(), result.get(0).getIndicators().get(0).getInternalCode());
        assertEquals(output.getCaracteristicas().get(0).getEstado(), result.get(0).getIndicators().get(0).getActive());
        assertEquals(output.getCaracteristicas().get(1).getId(),
                result.get(0).getIndicators().get(1).getId());
        assertEquals(output.getCaracteristicas().get(1).getTipo(),
                result.get(0).getIndicators().get(1).getInternalCode());
        assertEquals(output.getCaracteristicas().get(1).getEstado(),
                result.get(0).getIndicators().get(1).getActive());
        assertEquals(output.getSegmento(), result.get(0).getSegment());
        assertEquals(output.getOferta(), result.get(0).getCampaing().getAdditionalInformation());
        assertEquals(output.getOpcion().get(0).getId(),
                result.get(0).getCampaing().getConditions().get(0).getId());
        assertEquals(output.getOpcion().get(0).getValue(),
                result.get(0).getCampaing().getConditions().get(0).getValue());
        assertEquals(output.getOpcion().get(1).getId(),
                result.get(0).getCampaing().getConditions().get(1).getId());
        assertEquals(output.getOpcion().get(1).getValue(),
                result.get(0).getCampaing().getConditions().get(1).getValue());
        assertEquals(output.getAnexo(), result.get(0).getBusinessAgent().getPhoneNumber());
    }

    @Test
    public void mapOutEmptyTest() {

        List<ParticipantSearchOutput> result = mapper.mapOut(new ModelSearchConversationParticipantsResponse());

        assertNotNull(result);
        assertNotNull(result.get(0));
        assertNull(result.get(0).getId());
        assertNull(result.get(0).getPhone());
        assertNull(result.get(0).getSegment());
        assertNull(result.get(0).getBusinessAgent());
        assertNull(result.get(0).getCampaing());
        assertNull(result.get(0).getIndicators());
    }
}
