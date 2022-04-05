package com.bbva.pzic.contactcenter.business.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
public class DTOIntAction {

    @Valid
    private List<DTOIntInput> inputs;
    @Valid
    private List<DTOIntOutput> outputs;
    @Valid
    private DTOIntStep step;

    public List<DTOIntInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<DTOIntInput> inputs) {
        this.inputs = inputs;
    }

    public List<DTOIntOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<DTOIntOutput> outputs) {
        this.outputs = outputs;
    }

    public DTOIntStep getStep() {
        return step;
    }

    public void setStep(DTOIntStep step) {
        this.step = step;
    }
}
