package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.EntityStubs;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.facade.v0.dto.AnsweredQuestion;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 22/10/2020.
 *
 * @author Entelgy.
 */
public class CreateConversationQuestionnaireAnsweredQuestionMapperTest {

    private CreateConversationQuestionnaireAnsweredQuestionMapper mapper;

    @Before
    public void setUp() {
        mapper = new CreateConversationQuestionnaireAnsweredQuestionMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        AnsweredQuestion input = EntityStubs.getInstance().getAnsweredQuestion();

        InputCreateConversationQuestionnaireAnsweredQuestion result = mapper.mapIn(EntityStubs.CONVERSATION_ID, EntityStubs.QUESTIONNAIRE_ID, input);

        assertNotNull(result);
        assertNotNull(result.getConversationId());
        assertNotNull(result.getQuestionnaireId());
        assertNotNull(result.getQuestions());
        assertEquals(2, result.getQuestions().size());
        assertNotNull(result.getQuestions().get(0).getId());
        assertNotNull(result.getQuestions().get(0).getAnswer());
        assertNotNull(result.getQuestions().get(0).getAnswer().getValue());
        assertNotNull(result.getQuestions().get(1).getId());
        assertNotNull(result.getQuestions().get(1).getAnswer());
        assertNotNull(result.getQuestions().get(1).getAnswer().getValue());
    }

    @Test
    public void mapInQuestionnairesAnswerNullTest() throws IOException {
        AnsweredQuestion input = EntityStubs.getInstance().getAnsweredQuestion();
        input.getQuestions().get(0).setAnswer(null);

        InputCreateConversationQuestionnaireAnsweredQuestion result = mapper.mapIn(EntityStubs.CONVERSATION_ID, EntityStubs.QUESTIONNAIRE_ID, input);

        assertNotNull(result);
        assertNull(result.getQuestions().get(0).getAnswer());
    }

    @Test
    public void mapInEmptyTest() {
        InputCreateConversationQuestionnaireAnsweredQuestion result = mapper.mapIn(EntityStubs.CONVERSATION_ID, EntityStubs.QUESTIONNAIRE_ID, new AnsweredQuestion());

        assertNotNull(result);
        assertNotNull(result.getConversationId());
        assertNotNull(result.getQuestionnaireId());
        assertNull(result.getQuestions());
    }
}