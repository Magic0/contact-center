package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;
import com.bbva.pzic.contactcenter.facade.v0.mapper.IListContactCenterConversationsMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ListContactCenterConversationsMapperTest {

    private static final String FROM_DATE = "2022-03-02 11:00:00";
    private static final String PARTICIPANT_ID = "12345678";
    private static final String TO_DATE = "2022-03-02 11:00:00";
    private static final Boolean HAS_CONTRACT = false;
    private IListContactCenterConversationsMapper mapper;

    @Before
    public void setUp() { mapper = new ListContactCenterConversationsMapper(); }

    @Test
    public void mapInFullTest() throws IOException {
        InputContactCenterConversations result = mapper.mapIn(PARTICIPANT_ID,FROM_DATE,TO_DATE,HAS_CONTRACT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getParticipantId());
        Assert.assertNotNull(result.getFromDate());
        Assert.assertNotNull(result.getToDate());
        Assert.assertNotNull(result.getHasContract());

        Assert.assertEquals(result.getParticipantId(), PARTICIPANT_ID);
        Assert.assertEquals(result.getFromDate(), FROM_DATE);
        Assert.assertEquals(result.getToDate(), TO_DATE);
        Assert.assertEquals(result.getHasContract(), HAS_CONTRACT);
    }

    @Test
    public void mapInEmptyTest() {
        InputContactCenterConversations result = mapper.mapIn(null, null,null,null);
        Assert.assertNotNull(result);
        Assert.assertNull(result.getParticipantId());
        Assert.assertNull(result.getFromDate());
        Assert.assertNull(result.getToDate());
        Assert.assertNull(result.getHasContract());
    }

    @Test
    public void mapOutFullTest(){
        ServiceResponse<List<ContactCenterConversationsOutput>> results = mapper.mapOut(Collections.singletonList(new ContactCenterConversationsOutput()));
        Assert.assertNotNull(results);
        Assert.assertNotNull(results.getData());
    }

    @Test
    public void mapOutEmptyTest(){
        ServiceResponse<List<ContactCenterConversationsOutput>> results = mapper.mapOut(null);
        Assert.assertNull(results);
    }
}
