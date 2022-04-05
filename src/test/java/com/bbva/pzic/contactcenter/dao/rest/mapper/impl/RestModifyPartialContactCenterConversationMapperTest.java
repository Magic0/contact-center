package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.dao.model.conversation.ConversationModelRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestModifyPartialContactCenterConversationMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RestModifyPartialContactCenterConversationMapperTest {

    IRestModifyPartialContactCenterConversationMapper mapper = new RestModifyPartialContactCenterConversationMapper();

    @Test
    public void mapInFullTest() throws IOException {
        InputModifyPartialContactCenterConversation input = EntityStubs.getInstance().getInputModifyPartialContactCenterConversation();
        ConversationModelRequest result = mapper.mapIn( input);

        assertNotNull(result);
        assertNotNull(result.getIdLlamada());
        assertNotNull(result.getFlujoIvr());
        assertNotNull(result.getVersion());
        assertNotNull(result.getTelefonoLlamada());
        assertNotNull(result.getCodigoContrato());
        assertNotNull(result.getCodigoCliente());

        assertEquals("12345",result.getIdLlamada());
        assertEquals(input.getIdLlamada(),result.getIdLlamada());
        assertEquals(input.getFlujoIvr(),result.getFlujoIvr());
        assertEquals(input.getVersion(),result.getVersion());
        assertEquals(input.getTelefonoLlamada(),result.getTelefonoLlamada());
        assertEquals(input.getCodigoContrato(),result.getCodigoContrato());
        assertEquals(input.getCodigoCliente(),result.getCodigoCliente());
    }

    @Test
    public void mapInEmptyTest() {
        ConversationModelRequest result = mapper.mapIn(new InputModifyPartialContactCenterConversation());

        assertNotNull(result);
        assertNull(result.getIdLlamada());
        assertNull(result.getFlujoIvr());
        assertNull(result.getVersion());
        assertNull(result.getTelefonoLlamada());
        assertNull(result.getCodigoContrato());
        assertNull(result.getCodigoCliente());
    }
}