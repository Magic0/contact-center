package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnaireModelRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 22/10/2020.
 *
 * @author Entelgy.
 */
public class RestCreateConversationQuestionnaireAnsweredQuestionMapperTest {

    private RestCreateConversationQuestionnaireAnsweredQuestionMapper mapper;

    @Before
    public void setUp() {
        mapper = new RestCreateConversationQuestionnaireAnsweredQuestionMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputCreateConversationQuestionnaireAnsweredQuestion input = EntityStubs.getInstance().getInputCreateConversationQuestionnaireAnsweredQuestion();

        ConversationQuestionnaireModelRequest result = mapper.mapIn(input);

        assertNotNull(result);
        assertNotNull(result.getIdAtencion());
        assertNotNull(result.getIdEncuesta());
        assertNotNull(result.getPreguntas());
        assertEquals(2, result.getPreguntas().size());
        assertNotNull(result.getPreguntas().get(0).getId());
        assertNotNull(result.getPreguntas().get(0).getValue());
        assertNotNull(result.getPreguntas().get(1).getId());
        assertNotNull(result.getPreguntas().get(1).getValue());

        assertEquals(input.getConversationId(), result.getIdAtencion());
        assertEquals(input.getQuestionnaireId(), result.getIdEncuesta());
        assertEquals(input.getQuestions().get(0).getId(), result.getPreguntas().get(0).getId());
        assertEquals(input.getQuestions().get(0).getAnswer().getValue(), result.getPreguntas().get(0).getValue());
        assertEquals(input.getQuestions().get(1).getId(), result.getPreguntas().get(1).getId());
        assertEquals(input.getQuestions().get(1).getAnswer().getValue(), result.getPreguntas().get(1).getValue());

    }

    @Test
    public void mapInEmptyTest() throws IOException {
        ConversationQuestionnaireModelRequest result = mapper.mapIn(new InputCreateConversationQuestionnaireAnsweredQuestion());

        assertNotNull(result);
        assertNull(result.getIdAtencion());
        assertNull(result.getIdEncuesta());
        assertNull(result.getPreguntas());
    }
}