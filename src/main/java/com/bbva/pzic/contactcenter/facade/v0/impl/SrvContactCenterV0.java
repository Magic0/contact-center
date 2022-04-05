package com.bbva.pzic.contactcenter.facade.v0.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseCreatedWithNoContent;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseNoContent;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.pzic.contactcenter.business.ISrvIntContactCenter;
import com.bbva.pzic.contactcenter.facade.RegistryIds;
import com.bbva.pzic.contactcenter.facade.v0.ISrvContactCenterV0;
import com.bbva.pzic.contactcenter.facade.v0.dto.*;
import com.bbva.pzic.contactcenter.facade.v0.mapper.*;
import com.bbva.pzic.routine.processing.data.DataProcessingExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

import static com.bbva.pzic.contactcenter.facade.RegistryIds.SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_QUESTIONNAIRE_ANSWERED_QUESTION;
import static com.bbva.pzic.contactcenter.facade.RegistryIds.SMC_REGISTRY_ID_OF_SEARCH_CONVERSATION_PARTICIPANTS;

/**
 * Created on 22/10/2020.
 *
 * @author Entelgy
 */
@Path("/v0")
@Produces(MediaType.APPLICATION_JSON)
@SN(registryID = "SNPE20200046", logicalID = "contact-center")
@VN(vnn = "v0")
@Service
public class SrvContactCenterV0 implements ISrvContactCenterV0 {

    private static final Log LOG = LogFactory.getLog(SrvContactCenterV0.class);

    private static final String CONVERSATION_ID = "conversation-id";
    private static final String QUESTIONNAIRE_ID = "questionnaire-id";
    private static final String INDICATOR_ID = "indicator-id";

    @Autowired
    private ISrvIntContactCenter srvIntContactCenter;
    @Autowired
    private ICreateConversationQuestionnaireAnsweredQuestionMapper createConversationQuestionnaireAnsweredQuestionMapper;
    @Autowired
    private ICreateConversationMapper createConversationMapper;
    @Autowired
    private IModifyConversationIndicatorMapper modifyConversationIndicatorMapper;

    @Autowired
    private IModifyPartialContactCenterConversationMapper modifyPartialContactCenterConversationMapper;

    @Autowired
    private ISearchConversationParticipantsMapper searchConversationParticipantsMapper;

    @Autowired
    private ICreateConversationActionMapper createConversationActionMapper;

    @Autowired
    private DataProcessingExecutor inputDataProcessingExecutor;

    @Autowired
    private DataProcessingExecutor outputDataProcessingExecutor;

    @Override
    @POST
    @Path("/conversations/{conversation-id}/questionnaires/{questionnaire-id}/questions")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_QUESTIONNAIRE_ANSWERED_QUESTION, logicalID = "createConversationQuestionnaireAnsweredQuestion", forcedCatalog = "gabiCatalog")
    public ServiceResponseCreatedWithNoContent createConversationQuestionnaireAnsweredQuestion(@PathParam(CONVERSATION_ID) final String conversationId,
                                                                                               @PathParam(QUESTIONNAIRE_ID) final String questionnaireId,
                                                                                               final AnsweredQuestion answeredQuestion) {
        LOG.info("----- Invoking service createConversationQuestionnaireAnsweredQuestion -----");

        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(CONVERSATION_ID, conversationId);
        pathParams.put(QUESTIONNAIRE_ID, questionnaireId);

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_QUESTIONNAIRE_ANSWERED_QUESTION, answeredQuestion, pathParams, null);

        srvIntContactCenter.createConversationQuestionnaireAnsweredQuestion(
                createConversationQuestionnaireAnsweredQuestionMapper.mapIn((String) pathParams.get(CONVERSATION_ID), (String) pathParams.get(QUESTIONNAIRE_ID), answeredQuestion));

        return ServiceResponseCreatedWithNoContent.ServiceResponseCreatedWithNoContentBuilder.build();
    }

    @Override
    @POST
    @Path("/conversations/participants/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = SMC_REGISTRY_ID_OF_SEARCH_CONVERSATION_PARTICIPANTS, logicalID = "searchConversationParticipants", forcedCatalog = "gabiCatalog")
    public ServiceResponse<List<ParticipantSearchOutput>> searchConversationParticipants(final ParticipantSearchInput participantSearchInput) {
        LOG.info("----- Invoking service searchConversationParticipants -----");

        inputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_SEARCH_CONVERSATION_PARTICIPANTS, participantSearchInput, null, null);

        ServiceResponse<List<ParticipantSearchOutput>> serviceResponse = searchConversationParticipantsMapper.mapOut(
                srvIntContactCenter.searchConversationParticipant(
                        searchConversationParticipantsMapper.mapIn(participantSearchInput)
                )
        );

        outputDataProcessingExecutor.perform(SMC_REGISTRY_ID_OF_SEARCH_CONVERSATION_PARTICIPANTS, serviceResponse, null, null);

        return serviceResponse;
    }

    @Override
    @POST
    @Path("/conversations")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMGG20210023",logicalID = "createConversation",forcedCatalog = "gabiCatalog")
    public ServiceResponseNoContent createConversation(final Conversation conversation) {

        LOG.info("----- Invoking service createConversationQuestionnaireAnsweredQuestion -----");

        srvIntContactCenter.createConversation(createConversationMapper.mapIn(conversation));

        return ServiceResponseNoContent.ServiceResponseNoContentBuilder.build();
    }

    @Override
    @POST
    @Path("/conversations/{conversation-id}/actions")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = RegistryIds.SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_ACTION, logicalID = "createConversationAction", forcedCatalog = "gabiCatalog")
    public ServiceResponseNoContent createConversationAction(@PathParam(CONVERSATION_ID) final String conversationId, final Action action) {
        LOG.info("----- Invoking service createConversationAction -----");
        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(CONVERSATION_ID, conversationId);

        inputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_CREATE_CONVERSATION_ACTION,action,pathParams,null);
        srvIntContactCenter.createConversationAction(
                createConversationActionMapper.mapIn((String) pathParams.get(CONVERSATION_ID),action)
        );
        return ServiceResponseNoContent.ServiceResponseNoContentBuilder.build();
    }

    @Override
    @PUT
    @Path("/conversations/{conversation-id}/indicators/{indicator-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_CONVERSATION_INDICATOR, logicalID = "modifyConversationIndicator", forcedCatalog = "gabiCatalog")
    public ServiceResponseNoContent modifyConversationIndicator(@PathParam(CONVERSATION_ID) final String conversationId,
                                                                @PathParam(INDICATOR_ID) final String indicatorId,
                                                                final Indicator indicator) {
        LOG.info("----- Invoking service modifyConversationIndicator -----");

        HashMap<String, Object> pathParams = new HashMap<>();
        pathParams.put(CONVERSATION_ID, conversationId);
        pathParams.put(INDICATOR_ID, indicatorId);

        inputDataProcessingExecutor.perform(RegistryIds.SMC_REGISTRY_ID_OF_MODIFY_CONVERSATION_INDICATOR, indicator, pathParams, null);

        srvIntContactCenter.modifyConversationIndicator(
                modifyConversationIndicatorMapper.mapIn((String) pathParams.get(CONVERSATION_ID), (String) pathParams.get(INDICATOR_ID), indicator));

        return ServiceResponseNoContent.ServiceResponseNoContentBuilder.build();
    }

    @Override
    @PATCH
    @Path("/conversations/{conversation-id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @SMC(registryID = "SMGG20220324", logicalID = "modifyPartialContactCenterConversation", forcedCatalog = "gabiCatalog")
    public ServiceResponseNoContent modifyPartialContactCenterConversation(@PathParam(CONVERSATION_ID) String conversationId, ConversationItem conversationItem) {

        srvIntContactCenter.modifyPartialContactCenterConversation(
                modifyPartialContactCenterConversationMapper.mapIn(conversationId, conversationItem));

        return ServiceResponseNoContent.ServiceResponseNoContentBuilder.build();
    }
}
