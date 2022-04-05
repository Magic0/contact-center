package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsRequest;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.ModelSearchConversationParticipantsResponse;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestSearchConversationParticipantsMapper;
import com.bbva.pzic.contactcenter.facade.RegistryIds;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;
import com.bbva.pzic.contactcenter.util.connection.rest.RestPostConnection;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static com.bbva.pzic.contactcenter.facade.RegistryIds.SMC_REGISTRY_ID_OF_SEARCH_CONVERSATION_PARTICIPANTS;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@Component
public class RestSearchConversationParticipants extends RestPostConnection<ModelSearchConversationParticipantsRequest, ModelSearchConversationParticipantsResponse> {

    private static final String URL_PROPERTY = "servicing.smc.configuration.SMGG20210026.backend.url";
    private static final String URL_PROPERTY_PROXY = "servicing.smc.configuration.SMGG20210026.backend.proxy";

    private final List<String> obfuscationMask = Arrays.asList("codCliente", "numero");

    @Autowired
    private IRestSearchConversationParticipantsMapper mapper;

    private Translator translator;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @PostConstruct
    public void init() {
        useProxy = Boolean.parseBoolean(translator.translate(URL_PROPERTY_PROXY, "false"));
    }

    public List<ParticipantSearchOutput> perform(final InputSearchConversationParticipants input) {
        return mapper.mapOut(connect(URL_PROPERTY, mapper.mapIn(input), obfuscationMask));
    }

    @Override
    protected void evaluateResponse(ModelSearchConversationParticipantsResponse response, int statusCode) {
        evaluateMessagesResponses(response.getMessages(), SMC_REGISTRY_ID_OF_SEARCH_CONVERSATION_PARTICIPANTS, statusCode);
    }
}
