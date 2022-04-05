package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputModifyPartialContactCenterConversation;
import com.bbva.pzic.contactcenter.facade.v0.dto.ConversationItem;
import com.bbva.pzic.contactcenter.facade.v0.mapper.IModifyPartialContactCenterConversationMapper;
import org.junit.Test;

import java.io.IOException;

import static com.bbva.pzic.contactcenter.EntityStubs.CONVERSATION_ID;
import static org.junit.Assert.*;

public class ModifyPartialContactCenterConversationMapperTest {

    IModifyPartialContactCenterConversationMapper mapper = new ModifyPartialContactCenterConversationMapper();

    @Test
    public void mapIn() throws IOException {
        ConversationItem input = EntityStubs.getInstance().getConversationItem();
        InputModifyPartialContactCenterConversation result= mapper.mapIn(CONVERSATION_ID, input);

        assertNotNull(result);
        assertNotNull(result.getIdLlamada());
        assertNotNull(result.getFlujoIvr());
        assertNotNull(result.getVersion());
        assertNotNull(result.getTelefonoLlamada());
        assertNotNull(result.getCodigoContrato());
        assertNotNull(result.getCodigoCliente());

        assertEquals(CONVERSATION_ID,result.getIdLlamada());
        assertEquals(input.getApplication().getId(),result.getFlujoIvr());
        assertEquals(input.getApplication().getVersion(),result.getVersion());
        assertEquals(input.getPhone().getNumber(),result.getTelefonoLlamada());
        assertEquals(input.getContractId(),result.getCodigoContrato());
        assertEquals(input.getParticipant().getId(),result.getCodigoCliente());
    }

    @Test
    public void mapInEmpty() {
        InputModifyPartialContactCenterConversation result= mapper.mapIn(CONVERSATION_ID, new ConversationItem());

        assertNotNull(result);
        assertNotNull(result.getIdLlamada());
        assertNull(result.getFlujoIvr());
        assertNull(result.getVersion());
        assertNull(result.getTelefonoLlamada());
        assertNull(result.getCodigoContrato());
        assertNull(result.getCodigoCliente());
    }

}