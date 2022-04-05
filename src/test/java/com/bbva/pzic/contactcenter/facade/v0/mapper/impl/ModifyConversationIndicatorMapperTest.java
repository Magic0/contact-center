package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.facade.v0.dto.Indicator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class ModifyConversationIndicatorMapperTest {

    private ModifyConversationIndicatorMapper mapper;

    @Before
    public void setUp() {
        mapper = new ModifyConversationIndicatorMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        Indicator input = EntityStubs.getInstance().getIndicator();
        InputModifyConversationIndicator result = mapper.mapIn(EntityStubs.CONVERSATION_ID, EntityStubs.INDICATOR_ID, input);

        assertNotNull(result);
        assertNotNull(result.getConversationId());
        assertNotNull(result.getIndicatorId());
        assertNotNull(result.getIndicator().getIsActive());
    }

    @Test
    public void mapInIndicatorNullTest() throws IOException {
        Indicator input = EntityStubs.getInstance().getIndicator();
        input.setActive(null);

        InputModifyConversationIndicator result = mapper.mapIn(EntityStubs.CONVERSATION_ID, EntityStubs.INDICATOR_ID, input);

        assertNotNull(result);
        assertNull(result.getIndicator().getIsActive());
    }

    @Test
    public void mapInEmptyTest() {
        InputModifyConversationIndicator result = mapper.mapIn(EntityStubs.CONVERSATION_ID, EntityStubs.INDICATOR_ID, new Indicator());

        assertNotNull(result);
        assertNotNull(result.getConversationId());
        assertNotNull(result.getIndicatorId());
        assertNull(result.getIndicator().getIsActive());
    }
}
