package com.bbva.pzic.contactcenter.dao.rest.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.dao.model.indicators.ConversationIndicatorModelRequest;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public interface IRestModifyConversationIndicatorMapper {

    ConversationIndicatorModelRequest mapIn(InputModifyConversationIndicator input);
}
