package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.DTOIntQuestion;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversationQuestionnaireAnsweredQuestion;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnaireModelRequest;
import com.bbva.pzic.contactcenter.dao.model.questionnaires.ConversationQuestionnairesModel;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationQuestionnaireAnsweredQuestionMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created on 28/10/2020.
 *
 * @author Entelgy.
 */
@Component
public class RestCreateConversationQuestionnaireAnsweredQuestionMapper implements IRestCreateConversationQuestionnaireAnsweredQuestionMapper {

    @Override
    public ConversationQuestionnaireModelRequest mapIn(final InputCreateConversationQuestionnaireAnsweredQuestion input) {
        ConversationQuestionnaireModelRequest model = new ConversationQuestionnaireModelRequest();
        model.setIdAtencion(input.getConversationId());
        model.setIdEncuesta(input.getQuestionnaireId());
        model.setPreguntas(mapInPreguntas(input.getQuestions()));
        return model;
    }

    private List<ConversationQuestionnairesModel> mapInPreguntas(final List<DTOIntQuestion> questions) {
        if (CollectionUtils.isEmpty(questions)) {
            return null;
        }

        return questions.stream().filter(Objects::nonNull).map(this::mapInPregunta).collect(Collectors.toList());
    }

    private ConversationQuestionnairesModel mapInPregunta(final DTOIntQuestion dtoIntQuestion) {
        ConversationQuestionnairesModel result = new ConversationQuestionnairesModel();
        result.setId(dtoIntQuestion.getId());
        result.setValue(dtoIntQuestion.getAnswer() == null ? null : dtoIntQuestion.getAnswer().getValue());
        return result;
    }
}
