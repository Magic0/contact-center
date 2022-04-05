package com.bbva.pzic.contactcenter;

import com.bbva.pzic.contactcenter.business.dto.*;
import com.bbva.pzic.contactcenter.facade.v0.dto.*;
import com.bbva.pzic.contactcenter.util.mappers.ObjectMapperHelper;

import java.io.IOException;

/**
 * @author Entelgy
 */
public final class EntityStubs {

    public static final String QUESTIONNAIRE_ID = "4324";
    public static final String CONVERSATION_ID = "6456";
    public static final String INDICATOR_ID = "1234";

    private static final EntityStubs INSTANCE = new EntityStubs();

    private final ObjectMapperHelper objectMapper;

    private EntityStubs() {
        objectMapper = ObjectMapperHelper.getInstance();
    }

    public static EntityStubs getInstance() {
        return INSTANCE;
    }

    public AnsweredQuestion getAnsweredQuestion() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/answeredQuestion.json"), AnsweredQuestion.class);
    }

    public InputCreateConversationQuestionnaireAnsweredQuestion getInputCreateConversationQuestionnaireAnsweredQuestion() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/inputCreateConversationQuestionnaireAnsweredQuestion.json"), InputCreateConversationQuestionnaireAnsweredQuestion.class);
    }

    public ParticipantSearchInput getParticipantSearchInput() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/participantSearchInput.json"), ParticipantSearchInput.class);
    }

    public InputSearchConversationParticipants getInputSearchConversationParticipants() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/inputSearchConversationParticipants.json"), InputSearchConversationParticipants.class);
    }

    public Conversation getConversation() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/createConversation.json"),Conversation.class);
    }

    public InputCreateConversation getInputCreateConversation() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/inputCreateConversation.json"), InputCreateConversation.class);
    }

    public Action getAction() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("mock/action.json"),Action.class);
    }

    public InputCreateConversationAction getInputCreateConversationAction() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/inputCreateConversationAction.json"),InputCreateConversationAction.class);
    }

    public Indicator getIndicator() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/indicator.json"), Indicator.class);
    }

    public InputModifyConversationIndicator getInputModifyConversationIndicator() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/inputModifyConversationIndicator.json"), InputModifyConversationIndicator.class);
    }

    public ConversationItem getConversationItem() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/getConversationItem.json"), ConversationItem.class);
    }
    public InputModifyPartialContactCenterConversation getInputModifyPartialContactCenterConversation() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("mock/getInputModifyPartialContactCenterConversation.json"), InputModifyPartialContactCenterConversation.class);
    }

}
