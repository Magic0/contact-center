package com.bbva.pzic.contactcenter.facade.v0.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.*;
import com.bbva.pzic.contactcenter.facade.v0.dto.Action;
import com.bbva.pzic.contactcenter.facade.v0.dto.Input;
import com.bbva.pzic.contactcenter.facade.v0.dto.Output;
import com.bbva.pzic.contactcenter.facade.v0.dto.Step;
import com.bbva.pzic.contactcenter.facade.v0.mapper.ICreateConversationActionMapper;
import com.bbva.pzic.contactcenter.facade.v0.mapper.ICreateConversationQuestionnaireAnsweredQuestionMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy
 */
@Component
public class CreateConversationActionMapper implements ICreateConversationActionMapper {
    @Override
    public InputCreateConversationAction mapIn(final String conversationId, final Action action) {
        InputCreateConversationAction inputCreateConversationAction = new InputCreateConversationAction();
        inputCreateConversationAction.setConversationId(conversationId);
        inputCreateConversationAction.setAction(mapInAction(action));
        return inputCreateConversationAction;
    }

    private DTOIntAction mapInAction(final Action action) {
        DTOIntAction dtoIntAction = new DTOIntAction();
        dtoIntAction.setStep(mapInStep(action.getStep()));
        dtoIntAction.setInputs(mapInInputs(action.getInputs()));
        dtoIntAction.setOutputs(mapInOnputs(action.getOutputs()));
        return dtoIntAction;
    }

    private List<DTOIntOutput> mapInOnputs(final List<Output> outputs) {
        if(CollectionUtils.isEmpty(outputs)){
            return null;
        }
        return outputs.stream().filter(Objects::nonNull).map(this::mapInOutput).collect(Collectors.toList());
    }

    private DTOIntOutput mapInOutput(final Output output) {
        DTOIntOutput dtoIntOutput = new DTOIntOutput();
        dtoIntOutput.setValue(output.getValue());
        dtoIntOutput.setId(output.getId());
        return dtoIntOutput;
    }

    private List<DTOIntInput> mapInInputs(final List<Input> inputs) {
        if(CollectionUtils.isEmpty(inputs)){
           return null;
        }
        return inputs.stream().filter(Objects::nonNull).map(this::mapInInput).collect(Collectors.toList());
    }

    private DTOIntInput mapInInput(final Input input) {
        DTOIntInput dtoIntInput = new DTOIntInput();
        dtoIntInput.setId(input.getId());
        dtoIntInput.setValue(input.getValue());
        return  dtoIntInput;
    }

    private DTOIntStep mapInStep(final Step step) {
        if(step == null){
            return null;
        }
        DTOIntStep dtoIn = new DTOIntStep();
        dtoIn.setId(step.getId());
        return dtoIn;
    }
}
