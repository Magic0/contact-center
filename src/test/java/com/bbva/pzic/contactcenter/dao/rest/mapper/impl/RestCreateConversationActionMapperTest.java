package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationAction;
import com.bbva.pzic.contactcenter.dao.model.actions.ConversationActionModelRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationActionMapper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class RestCreateConversationActionMapperTest {

    private IRestCreateConversationActionMapper mapper;

    @Before
    public void setUp() {
        mapper = new RestCreateConversationActionMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreateConversationAction input = EntityStubs.getInstance().getInputCreateConversationAction();
        ConversationActionModelRequest result =mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getStep());
        assertNotNull(result.getConversation_id());
        assertNotNull(result.getData_request());
        assertNotNull(result.getData_request());

        assertEquals(result.getStep(),input.getAction().getStep().getId());
        assertEquals(result.getConversation_id(),input.getConversationId());
        assertEquals(result.getData_response().get(0).getId(),input.getAction().getOutputs().get(0).getId());
        assertEquals(result.getData_response().get(0).getValue(),input.getAction().getOutputs().get(0).getValue());
        assertEquals(result.getData_request().get(0).getId(),input.getAction().getInputs().get(0).getId());
        assertEquals(result.getData_request().get(0).getValue(),input.getAction().getInputs().get(0).getValue());
    }

    @Test
    public void mapInEmptyTest(){
        ConversationActionModelRequest result =mapper.mapIn(new InputCreateConversationAction());
        assertNotNull(result);
        assertNull(result.getData_request());
        assertNull(result.getConversation_id());
        assertNull(result.getStep());
        assertNull(result.getData_response());
    }
}
