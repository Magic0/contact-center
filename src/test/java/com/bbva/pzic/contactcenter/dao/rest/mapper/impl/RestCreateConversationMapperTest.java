package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ConversationModelRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RestCreateConversationMapperTest {

    private RestCreateConversationMapper mapper;

    @Before
    public void setUp() {
        mapper = new RestCreateConversationMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreateConversation input = EntityStubs.getInstance().getInputCreateConversation();

        ConversationModelRequest result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getIdLlamada());
        assertNotNull(result.getFlujoIvr());
        assertNotNull(result.getVersion());
        assertNotNull(result.getCodigo());
        assertNotNull(result.getTelefonoLlamada());
        assertNotNull(result.getCodigoContrato());

        assertEquals(input.getExternalId(),result.getIdLlamada());
        assertEquals(input.getApplication().getId(),result.getFlujoIvr());
        assertEquals(input.getApplication().getVersion(),result.getVersion());
        assertEquals(input.getParticipant().getId(),result.getCodigo());
        assertEquals(input.getPhone().getNumber(),result.getTelefonoLlamada());
        assertEquals(input.getContractId(),result.getCodigoContrato());
    }

    @Test
    public void mapInEmptyTest(){
        ConversationModelRequest result = mapper.mapIn(new InputCreateConversation());

        assertNotNull(result);
        assertNull(result.getIdLlamada());
        assertNull(result.getFlujoIvr());
        assertNull(result.getVersion());
        assertNull(result.getCodigo());
        assertNull(result.getTelefonoLlamada());
        assertNull(result.getCodigoContrato());
    }
}
