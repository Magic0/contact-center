package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;
import com.bbva.pzic.contactcenter.business.dto.InputModifyConversationIndicator;
import com.bbva.pzic.contactcenter.dao.model.indicators.ConversationIndicatorModelRequest;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestModifyConversationIndicatorMapper;
import org.springframework.stereotype.Component;

@Component
public class RestModifyConversationIndicatorMapper implements IRestModifyConversationIndicatorMapper {

    @Override
    public ConversationIndicatorModelRequest mapIn(final InputModifyConversationIndicator input) {
        ConversationIndicatorModelRequest model = new ConversationIndicatorModelRequest();
        model.setIdllamada(input.getConversationId());
        model.setTipo(input.getIndicatorId());
        if(input.getIndicator() != null && input.getIndicator().getIsActive() != null){
            model.setEstado(input.getIndicator().getIsActive());
        }
        return model;
    }
}
