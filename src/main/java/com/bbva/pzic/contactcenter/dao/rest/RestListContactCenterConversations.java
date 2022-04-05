package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.pzic.contactcenter.business.dto.InputContactCenterConversations;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationRequest;
import com.bbva.pzic.contactcenter.dao.model.conversation.ModelConversationResponse;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestListContactCenterConversations;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;
import com.bbva.pzic.contactcenter.util.connection.rest.RestPostConnection;
import com.bbva.pzic.routine.translator.facade.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static com.bbva.pzic.contactcenter.facade.RegistryIds.SMC_REGISTRY_ID_OF_LIST_CONTACT_CENTER_CONVERSATIONS;

@Component
public class RestListContactCenterConversations extends RestPostConnection<ModelConversationRequest, ModelConversationResponse> {

    private static final String URL_PROPERTY = "servicing.smc.configuration.SMGG20220332.backend.url";
    private static final String URL_PROPERTY_PROXY = "servicing.smc.configuration.SMGG20220332.backend.proxy";

    private final List<String> obfuscationMask = Arrays.asList("codCliente", "numero");

    @Autowired
    private IRestListContactCenterConversations mapper;

    private Translator translator;

    @Autowired
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    @PostConstruct
    public void init() {
        useProxy = Boolean.parseBoolean(translator.translate(URL_PROPERTY_PROXY, "false"));
    }

    public List<ContactCenterConversationsOutput> perform(final InputContactCenterConversations input) {
        return mapper.mapOut(connect(URL_PROPERTY, mapper.mapIn(input), obfuscationMask));
    }

    @Override
    protected void evaluateResponse(ModelConversationResponse response, int statusCode) {
        evaluateMessagesResponses(response.getMessages(), SMC_REGISTRY_ID_OF_LIST_CONTACT_CENTER_CONVERSATIONS, statusCode);
    }
}
