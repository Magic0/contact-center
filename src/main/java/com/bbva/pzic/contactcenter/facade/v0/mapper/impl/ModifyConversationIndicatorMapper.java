package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.DTOIntIndicator;
import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.facade.v0.dto.Indicator;
import com.bbva.pzic.contactcenter.facade.v0.mapper.IModifyConversationIndicatorMapper;
import org.springframework.stereotype.Component;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy
 */
@Component
public class ModifyConversationIndicatorMapper implements IModifyConversationIndicatorMapper {

    @Override
    public InputModifyConversationIndicator mapIn(final String conversationId, final String indicatorId, final Indicator indicator) {
        InputModifyConversationIndicator input = new InputModifyConversationIndicator();
        input.setConversationId(conversationId);
        input.setIndicatorId(indicatorId);
        input.setIndicator(mapInIndicator(indicator));
        return input;
    }

    private DTOIntIndicator mapInIndicator(final Indicator indicator) {
        if(indicator == null) {
            return null;
        }
        DTOIntIndicator result = new DTOIntIndicator();
        result.setIsActive(indicator.getActive());
        return result;
    }
}
