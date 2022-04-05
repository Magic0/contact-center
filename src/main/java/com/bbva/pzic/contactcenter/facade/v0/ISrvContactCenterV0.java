package com.bbva.pzic.contactcenter.facade.v0;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseCreatedWithNoContent;
import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponseNoContent;
import com.bbva.pzic.contactcenter.facade.v0.dto.*;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import java.util.List;


/**
 * Created on 28/10/2020.
 *
 * @author Entelgy
 */
public interface ISrvContactCenterV0 {

    ServiceResponseCreatedWithNoContent createConversationQuestionnaireAnsweredQuestion(String conversationId, String questionnaireId, AnsweredQuestion answeredQuestion);

    ServiceResponse<List<ParticipantSearchOutput>> searchConversationParticipants(ParticipantSearchInput participantSearchInput);

    ServiceResponseNoContent createConversation(Conversation conversation);

    ServiceResponseNoContent createConversationAction(String conversationId, Action action);

    ServiceResponseNoContent modifyConversationIndicator(String conversationId, String indicatorId, Indicator indicator);

    ServiceResponseNoContent modifyPartialContactCenterConversation(String conversationId, ConversationItem conversationItem);

    ServiceResponse<List<ContactCenterConversationsOutput>> listContactCenterConversations(String codigoCliente, String fechaInicio, String fechaFin, Boolean sinCodigoContrato);
}
