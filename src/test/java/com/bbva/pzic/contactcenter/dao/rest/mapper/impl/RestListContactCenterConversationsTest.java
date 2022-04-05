package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestListContactCenterConversations;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class RestListContactCenterConversationsTest {

    private IRestListContactCenterConversations mapper;

    @Before
    public void setUp(){mapper = new RestListContactCenterConversationsMapper();}

    @Test
    public void mapInFullTest() throws IOException {
        InputContactCenterConversations input = EntityStubs.getInstance().getInputContactCenterConversations();

        ModelConversationRequest result = mapper.mapIn(input);
        assertNotNull(result);
        assertNull(result.getCodCliente());
        assertNotNull(result.getFromDate());
        assertNotNull(result.getToDate());
        assertNotNull(result.getHasContract());

        assertEquals(result.getCodCliente(), input.getParticipantId());
        assertEquals(result.getFromDate(), input.getFromDate());
        assertEquals(result.getToDate(), input.getToDate());
        assertEquals(result.getHasContract(), input.getHasContract());
    }
}
