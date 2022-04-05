package com.bbva.pzic.contactcenter.facade.v0.mapper;

import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.facade.v0.dto.Indicator;

public interface IModifyConversationIndicatorMapper {

    InputModifyConversationIndicator mapIn(String conversationId, String indicatorId, Indicator indicator);
}
