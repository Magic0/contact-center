package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationAction;
import com.bbva.pzic.contactcenter.facade.v0.dto.Action;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class CreateConversationActionMapperTest{

    private CreateConversationActionMapper mapper;
    public static final String CONVERSATION_ID = "123123-5345345-gredg-456-g-df";

    @Before
    public void setUp() {
        mapper = new CreateConversationActionMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        Action input = EntityStubs.getInstance().getAction();

        InputCreateConversationAction result = mapper.mapIn(CONVERSATION_ID,input);
        assertNotNull(result);
        assertNotNull(result.getConversationId());
        assertNotNull(result.getAction());
        assertNotNull(result.getAction().getStep());
        assertNotNull(result.getAction().getStep().getId());
        assertNotNull(result.getAction().getInputs());
        assertNotNull(result.getAction().getOutputs());
        assertNotNull(result.getAction().getInputs().get(0).getId());
        assertNotNull(result.getAction().getInputs().get(0).getValue());
        assertNotNull(result.getAction().getOutputs().get(0).getId());
        assertNotNull(result.getAction().getOutputs().get(0).getValue());

        assertEquals(result.getConversationId(),CONVERSATION_ID);
        assertEquals(result.getAction().getStep().getId(),input.getStep().getId());
        assertEquals(result.getAction().getInputs().get(0).getValue(),input.getInputs().get(0).getValue());
        assertEquals(result.getAction().getInputs().get(0).getId(),input.getInputs().get(0).getId());
        assertEquals(result.getAction().getOutputs().get(0).getValue(),input.getOutputs().get(0).getValue());
        assertEquals(result.getAction().getOutputs().get(0).getId(),input.getOutputs().get(0).getId());
    }

    @Test
    public void mapInEmptyTest(){
        InputCreateConversationAction result = mapper.mapIn(CONVERSATION_ID, new Action());
        assertNotNull(result);
        assertNotNull(result.getAction());
        assertNotNull(result.getConversationId());
    }

}