package com.bbva.pzic.contactcenter.business.impl;

import com.bbva.pzic.contactcenter.business.ISrvIntContactCenter;
import com.bbva.pzic.contactcenter.business.dto.*;
import com.bbva.pzic.contactcenter.dao.IContactCenterDAO;

import com.bbva.pzic.contactcenter.facade.v0.dto.ParticipantSearchOutput;

import com.bbva.pzic.routine.validator.Validator;
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
public class SrvIntContactCenter implements ISrvIntContactCenter {

    private static final Log LOG = LogFactory.getLog(SrvIntContactCenter.class);

    @Autowired
    private IContactCenterDAO contactCenterDAO;

    @Autowired
    private Validator validator;


    @Override
    public void createConversationQuestionnaireAnsweredQuestion(final InputCreateConversationQuestionnaireAnsweredQuestion input) {
        LOG.info("... Invoking method SrvIntContactCenter.createConversationQuestionnaireAnsweredQuestion ...");
        LOG.info("... Validating createConversationQuestionnaireAnsweredQuestion input parameter ...");
        validator.validate(input, ValidationGroup.CreateConversationQuestionnaireAnsweredQuestion.class);
        contactCenterDAO.createConversationQuestionnaireAnsweredQuestion(input);
    }

    @Override
    public List<ParticipantSearchOutput> searchConversationParticipant(final InputSearchConversationParticipants input) {
        LOG.info("... Invoking method SrvIntContactCenter.searchConversationParticipant ...");
        LOG.info("... Validating searchConversationParticipant input parameter ...");
        validator.validate(input, ValidationGroup.SearchConversationParticipants.class);
        return contactCenterDAO.searchConversationParticipant(input);
    }

    @Override
    public void createConversation(final InputCreateConversation input) {
        LOG.info("... Invoking method SrvIntContactCenter.createConversation ...");
        LOG.info("... Validating createConversation input parameter ...");
        validator.validate(input, ValidationGroup.CreateConversation.class);
        contactCenterDAO.createConversation(input);
    }

    @Override
    public void createConversationAction(final InputCreateConversationAction input) {
        LOG.info("... Invoking method SrvIntContactCenter.createConversationAction ...");
        LOG.info("... Validating createConversationAction input parameter ...");
        validator.validate(input, ValidationGroup.CreateConversationAction.class);
        contactCenterDAO.createConversationAction(input);
    }

    @Override
    public void modifyConversationIndicator(final InputModifyConversationIndicator input) {
        LOG.info("... Invoking method SrvIntContactCenter.modifyConversationIndicator ...");
        LOG.info("... Validating modifyConversationIndicator input parameter ...");
        validator.validate(input, ValidationGroup.ModifyConversationIndicator.class);
        contactCenterDAO.modifyConversationIndicator(input);
    }

    @Override
    public void modifyPartialContactCenterConversation(final InputModifyPartialContactCenterConversation input) {
        LOG.info("... Invoking method SrvIntContactCenter.modifyPartialContactCenterConversation ...");
        LOG.info("... Validating modifyPartialContactCenterConversation input parameter ...");
        validator.validate(input, ValidationGroup.ModifyPartialContactCenterConversation.class);
        contactCenterDAO.modifyPartialContactCenterConversation(input);
    }
}
