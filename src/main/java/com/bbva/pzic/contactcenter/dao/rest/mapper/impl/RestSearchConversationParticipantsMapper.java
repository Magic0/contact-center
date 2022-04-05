package com.bbva.pzic.contactcenter.dao.rest.mapper.impl;

import com.bbva.pzic.contactcenter.business.dto.DTOIntPhone;
import com.bbva.pzic.contactcenter.business.dto.InputSearchConversationParticipants;
import com.bbva.pzic.contactcenter.dao.model.searchparticipants.*;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestSearchConversationParticipantsMapper;
import com.bbva.pzic.contactcenter.facade.v0.dto.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created on 28/01/2021.
 *
 * @author Entelgy.
 */
@Component
public class RestSearchConversationParticipantsMapper implements IRestSearchConversationParticipantsMapper {

    private static final Log LOG = LogFactory.getLog(RestSearchConversationParticipantsMapper.class);

    @Override
    public ModelSearchConversationParticipantsRequest mapIn(final InputSearchConversationParticipants input) {
        LOG.info("... called method RestSearchConversationParticipantsMapper.mapIn ...");
        ModelSearchConversationParticipantsRequest model = new ModelSearchConversationParticipantsRequest();
        model.setCodCliente(input.getId());
        model.setNumero(mapInNumero(input.getPhone()));
        return model;
    }

    private String mapInNumero(final DTOIntPhone phone) {
        if (phone == null){
            return null;
        }
        return phone.getNumber();
    }

    @Override
    public List<ParticipantSearchOutput> mapOut(final ModelSearchConversationParticipantsResponse model) {
        LOG.info("... called method RestSearchConversationParticipantsMapper.mapOut ...");
        if (model == null) {
            return null;
        }
        ParticipantSearchOutput dtoOut = new ParticipantSearchOutput();
        dtoOut.setId(model.getCodCliente());
        dtoOut.setPhone(mapOutPhone(model.getNumero()));
        dtoOut.setIndicators(mapOutIndicators(model.getCaracteristicas()));
        dtoOut.setSegment(model.getSegmento());
        dtoOut.setCampaing(mapOutCampaing(model.getOferta(), model.getOpcion()));
        dtoOut.setBusinessAgent(mapOutBusinessAgent(model.getAnexo()));
        return Collections.singletonList(dtoOut);
    }

    private BusinessAgent mapOutBusinessAgent(final String anexo) {
        if (anexo == null){
            return null;
        }
        BusinessAgent dtoOut = new BusinessAgent();
        dtoOut.setPhoneNumber(anexo);
        return dtoOut;
    }

    private Campaing mapOutCampaing(final String oferta, final List<ModelOpcion> opciones) {
        if (oferta == null && CollectionUtils.isEmpty(opciones)){
            return null;
        }
        Campaing dtoOut = new Campaing();
        dtoOut.setAdditionalInformation(oferta);
        dtoOut.setConditions(mapOutConditions(opciones));
        return dtoOut;
    }

    private List<Condition> mapOutConditions(final List<ModelOpcion> opciones) {
        if (CollectionUtils.isEmpty(opciones)){
            return null;
        }
        return opciones.stream().filter(Objects::nonNull).map(this::mapOutCondition).collect(Collectors.toList());
    }

    private Condition mapOutCondition(final ModelOpcion modelOpcion) {
        if (modelOpcion == null){
            return null;
        }
        Condition dtoOut = new Condition();
        dtoOut.setId(modelOpcion.getId());
        dtoOut.setValue(modelOpcion.getValue());
        return dtoOut;
    }

    private List<Indicator> mapOutIndicators(final List<ModelCaracteristica> caracteristicas) {
        if (CollectionUtils.isEmpty(caracteristicas)){
            return null;
        }
        return caracteristicas.stream().filter(Objects::nonNull).map(this::mapOutIndicator).collect(Collectors.toList());
    }

    private Indicator mapOutIndicator(final ModelCaracteristica modelCaracteristica) {
        if (modelCaracteristica == null){
            return null;
        }
        Indicator dtoOut = new Indicator();
        dtoOut.setId(modelCaracteristica.getId());
        dtoOut.setInternalCode(modelCaracteristica.getTipo());
        dtoOut.setActive(modelCaracteristica.getEstado());
        return dtoOut;
    }

    private Phone mapOutPhone(final String numero) {
        if (numero == null){
            return null;
        }
        Phone dtoOut = new Phone();
        dtoOut.setNumber(numero);
        return dtoOut;
    }
}
