package com.bbva.pzic.contactcenter.dao;

import com.bbva.pzic.contactcenter.business.dto.*;
import com.bbva.pzic.contactcenter.facade.v0.dto.ContactCenterConversationsOutput;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;

import java.util.List;

/**
 * Created on 22/10/2020.
 *
 * @author Entelgy
 */
public interface IContactCenterDAO {

    void createConversationQuestionnaireAnsweredQuestion(InputCreateConversationQuestionnaireAnsweredQuestion input);

    List<ParticipantSearchOutput> searchConversationParticipant(InputSearchConversationParticipants input);

    void createConversation(InputCreateConversation input);

    void createConversationAction(InputCreateConversationAction input);

    void modifyConversationIndicator(InputModifyConversationIndicator input);

    void modifyPartialContactCenterConversation(InputModifyPartialContactCenterConversation input);

    List<ContactCenterConversationsOutput> listContactCenterConversation(InputContactCenterConversations input);
}
