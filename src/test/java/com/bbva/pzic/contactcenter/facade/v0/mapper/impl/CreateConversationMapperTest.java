package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.facade.v0.dto.Conversation;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class CreateConversationMapperTest {

    private CreateConversationMapper createConversationMapper;

    @Before
    public void setUp() {
        createConversationMapper = new CreateConversationMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        Conversation input = EntityStubs.getInstance().getConversation();
        InputCreateConversation result = createConversationMapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getExternalId());
        assertNotNull(result.getApplication());
        assertNotNull(result.getApplication().getId());
        assertNotNull(result.getApplication().getVersion());
        assertNotNull(result.getParticipant());
        assertNotNull(result.getParticipant().getId());
        assertNotNull(result.getPhone());
        assertNotNull(result.getPhone().getNumber());
        assertNotNull(result.getContractId());

        assertEquals(input.getExternalId(),result.getExternalId());
        assertEquals(input.getApplication().getId(),result.getApplication().getId());
        assertEquals(input.getApplication().getVersion(),result.getApplication().getVersion());
        assertEquals(input.getParticipant().getId(),result.getParticipant().getId());
        assertEquals(input.getPhone().getNumber(),result.getPhone().getNumber());
        assertEquals(input.getContractId(),result.getContractId());
    }

    @Test
    public void mapInWithoutNonObligatoryFieldsTest() throws IOException {
        Conversation input = EntityStubs.getInstance().getConversation();
        input.setParticipant(null);
        input.setPhone(null);
        InputCreateConversation result = createConversationMapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getExternalId());
        assertNotNull(result.getApplication());
        assertNotNull(result.getApplication().getId());
        assertNotNull(result.getApplication().getVersion());
        assertNull(result.getParticipant());
        assertNull(result.getPhone());
        assertNotNull(result.getContractId());

        assertEquals(input.getExternalId(),result.getExternalId());
        assertEquals(input.getApplication().getId(),result.getApplication().getId());
        assertEquals(input.getApplication().getVersion(),result.getApplication().getVersion());
        assertEquals(input.getContractId(),result.getContractId());
    }

    @Test
    public void mapInEmptyTest(){
        InputCreateConversation result = createConversationMapper.mapIn(new Conversation());

        assertNotNull(result);
        assertNull(result.getExternalId());
        assertNull(result.getApplication());
        assertNull(result.getParticipant());
        assertNull(result.getPhone());
        assertNull(result.getContractId());
    }

}
