package com.bbva.pzic.contactcenter.dao.impl;

import com.bbva.pzic.contactcenter.business.dto.*;
import com.bbva.pzic.contactcenter.dao.IContactCenterDAO;
import com.bbva.pzic.contactcenter.dao.rest.*;
import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Created on 22/10/2020.
 *
 * @author Entelgy
 */
@Component
public class ContactCenterDAO implements IContactCenterDAO {

    private static final Log LOG = LogFactory.getLog(ContactCenterDAO.class);

    @Autowired
    private RestCreateConversationQuestionnaireAnsweredQuestion restCreateConversationQuestionnaireAnsweredQuestion;
    @Autowired
    private RestCreateConversation restCreateConversation;
    @Autowired
    private RestModifyConversationIndicator restModifyConversationIndicator;

    @Autowired
    private RestSearchConversationParticipants restSearchConversationParticipant;

    @Autowired
    private RestCreateConversationAction restCreateConversationAction;

    @Autowired
    private RestModifyPartialContactCenterConversation restModifyPartialContactCenterConversation;

    @Override
    public void createConversationQuestionnaireAnsweredQuestion(InputCreateConversationQuestionnaireAnsweredQuestion input) {
        LOG.info("... Invoking method ContactCenterDAO.createConversationQuestionnaireAnsweredQuestion ...");
        restCreateConversationQuestionnaireAnsweredQuestion.perform(input);
    }

    @Override
    public List<ParticipantSearchOutput> searchConversationParticipant(final InputSearchConversationParticipants input) {
        LOG.info("... Invoking method ContactCenterDAO.searchConversationParticipant ...");
        return restSearchConversationParticipant.perform(input);
    }

    @Override
    public void createConversation(final InputCreateConversation input) {
        LOG.info("... Invoking method ContactCenterDAO.createConversation ...");
        restCreateConversation.perform(input);

    }

    @Override
    public void createConversationAction(final InputCreateConversationAction input) {
        LOG.info("... Invoking method ContactCenterDAO.createConversationQuestionnaireAnsweredQuestion ...");
        restCreateConversationAction.perform(input);
    }

    @Override
    public void modifyConversationIndicator(final InputModifyConversationIndicator input) {
        LOG.info("... Invoking method ContactCenterDAO.modifyConversationIndicator ...");
        restModifyConversationIndicator.perform(input);
    }

    @Override
    public void modifyPartialContactCenterConversation(InputModifyPartialContactCenterConversation input) {
        LOG.info("... Invoking method ContactCenterDAO.modifyPartialContactCenterConversation ...");
        restModifyPartialContactCenterConversation.perform(input);
    }
}
