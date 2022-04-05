package com.bbva.pzic.contactcenter.dao.model.searchparticipants.mock;

import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsResponse;
import com.bbva.pzic.contactcenter.util.mappers.ObjectMapperHelper;

import java.io.IOException;

public class SearchConvesationParticipantsMock {

    private static final SearchConvesationParticipantsMock INSTANCE = new SearchConvesationParticipantsMock();

    private ObjectMapperHelper objectMapper = ObjectMapperHelper.getInstance();

    private SearchConvesationParticipantsMock() {
    }

    public static SearchConvesationParticipantsMock getInstance() {
        return INSTANCE;
    }

    public ModelSearchConversationParticipantsResponse buildModelSearchConversationParticipantsResponse() throws IOException {
        return objectMapper.readValue(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/bbva/pzic/contactcenter/dao/rest/mock/modelSearchConversationParticipantsResponse.json"),
                ModelSearchConversationParticipantsResponse.class);
    }
}
