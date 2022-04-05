package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.dao.model.indicators.ConversationIndicatorModelRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class RestModifyIndicatorMapperTest {

    private RestModifyConversationIndicatorMapper mapper;

    @Before
    public void setUp() {
        mapper = new RestModifyConversationIndicatorMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputModifyConversationIndicator input = EntityStubs.getInstance().getInputModifyConversationIndicator();

        ConversationIndicatorModelRequest result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getIdllamada());
        assertNotNull(result.getTipo());
        assertNotNull(result.getEstado());

        assertEquals(input.getConversationId(), result.getIdllamada());
        assertEquals(input.getIndicatorId(), result.getTipo());
        assertEquals(input.getIndicator().getIsActive(), result.getEstado());
    }

    @Test
    public void mapInEmptyTest() throws IOException {
        ConversationIndicatorModelRequest result = mapper.mapIn(new InputModifyConversationIndicator());

        assertNotNull(result);
        assertNull(result.getIdllamada());
        assertNull(result.getTipo());
        assertNull(result.getEstado());
    }
}
