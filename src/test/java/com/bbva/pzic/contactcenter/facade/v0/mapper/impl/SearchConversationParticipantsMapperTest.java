package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchInput;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;
import com.bbva.pzic.contactcenter.facade.v0.mapper.ISearchConversationParticipantsMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class SearchConversationParticipantsMapperTest {

    private ISearchConversationParticipantsMapper mapper;

    @Before
    public void setUp() {
        mapper = new SearchConversationParticipantsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        ParticipantSearchInput input = EntityStubs.getInstance().getParticipantSearchInput();

        InputSearchConversationParticipants result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getPhone());
        assertNotNull(result.getPhone().getNumber());

        assertEquals(input.getId(), result.getId());
        assertEquals(input.getPhone().getNumber(), result.getPhone().getNumber());
    }

    @Test
    public void mapInEmptyTest() {
        InputSearchConversationParticipants result = mapper.mapIn(new ParticipantSearchInput());

        assertNotNull(result);
        assertNull(result.getId());
        assertNull(result.getPhone());
    }

    @Test
    public void mapOutFullTest() {
        ServiceResponse<List<ParticipantSearchOutput>> result = mapper.mapOut(Collections.singletonList(new ParticipantSearchOutput()));

        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    public void mapOutEmptyTest() {
        ServiceResponse<List<ParticipantSearchOutput>> result = mapper.mapOut(new ArrayList<>());

        assertNull(result);
    }
}
