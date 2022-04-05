package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.DTOIntAnswer;
import com.bbva.pzic.contactcenter.business.dto.DTOIntQuestion;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.facade.v0.dto.Answer;
import com.bbva.pzic.contactcenter.facade.v0.dto.AnsweredQuestion;
import com.bbva.pzic.contactcenter.facade.v0.dto.Question;
import com.bbva.pzic.contactcenter.facade.v0.mapper.ICreateConversationQuestionnaireAnsweredQuestionMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created on 28/10/2020.
 *
 * @author Entelgy
 */
@Component
public class CreateConversationQuestionnaireAnsweredQuestionMapper implements ICreateConversationQuestionnaireAnsweredQuestionMapper {

    @Override
    public InputCreateConversationQuestionnaireAnsweredQuestion mapIn(final String conversationId, final String questionnaireId, final AnsweredQuestion answeredQuestion) {
        InputCreateConversationQuestionnaireAnsweredQuestion input = new InputCreateConversationQuestionnaireAnsweredQuestion();
        input.setConversationId(conversationId);
        input.setQuestionnaireId(questionnaireId);
        input.setQuestions(mapInQuestions(answeredQuestion.getQuestions()));
        return input;
    }

    private List<DTOIntQuestion> mapInQuestions(final List<Question> questions) {
        if (CollectionUtils.isEmpty(questions)) {
            return null;
        }

        return questions.stream().filter(Objects::nonNull).map(this::mapInQuestion).collect(Collectors.toList());
    }

    private DTOIntQuestion mapInQuestion(final Question question) {
        DTOIntQuestion result = new DTOIntQuestion();
        result.setId(question.getId());
        result.setAnswer(mapInAnswer(question.getAnswer()));
        return result;
    }

    private DTOIntAnswer mapInAnswer(final Answer answer) {
        if (answer == null) {
            return null;
        }

        DTOIntAnswer result = new DTOIntAnswer();
        result.setValue(answer.getValue());
        return result;
    }
}
