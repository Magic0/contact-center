package com.bbva.pzic.contactcenter.business;

import com.bbva.pzic.contactcenter.business.dto.*;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;

import java.util.List;

/**
 * Created on 22/10/2020.
 *
 * @author Entelgy
 */
public interface ISrvIntContactCenter {

    void createConversationQuestionnaireAnsweredQuestion(InputCreateConversationQuestionnaireAnsweredQuestion mapIn);

    List<ParticipantSearchOutput> searchConversationParticipant(InputSearchConversationParticipants input);

    void createConversation(InputCreateConversation input);

    void createConversationAction(InputCreateConversationAction mapIn);

    void modifyConversationIndicator(InputModifyConversationIndicator mapIn);

    void modifyPartialContactCenterConversation(InputModifyPartialContactCenterConversation input);

    List<ContactCenterConversationsOutput> listContactCenterConversations(InputContactCenterConversations input);
}
