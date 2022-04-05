package com.bbva.pzic.contactcenter.dao.rest;

import com.bbva.jee.arq.spring.core.rest.IRestConnector;
import com.bbva.jee.arq.spring.core.rest.RestConnectorFactory;
import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.RestConnectorType;
import com.bbva.jee.arq.spring.core.rest.requests.RestRequest;
import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.pzic.contactcenter.business.dto.InputCreateConversation;
import com.bbva.pzic.contactcenter.dao.rest.mapper.IRestCreateConversationMapper;
import com.bbva.pzic.routine.utils.RestErrorMappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RestCreateConversation {

    private static final String URL_PROPERTY = "servicing.smc.configuration.SMGG20210023.backend.url";

    @Autowired
    private IRestCreateConversationMapper mapper;

    @Autowired
    protected RestConnectorFactory restConnectorFactory;

    @Autowired
    protected ConfigurationManager configurationManager;

    @Autowired
    private RestErrorMappingHelper restErrorMappingHelper;

    public void perform(InputCreateConversation input) {

        String url = configurationManager.getProperty(URL_PROPERTY);

        IRestConnector restConnector = restConnectorFactory.getRestConnector(RestConnectorType.BASIC, "cc_ivr_call");

        RestRequest request = new RestRequest.Builder("POST", url)
                .payload(mapper.mapIn(input))
                .useProxy(false)
                .obfuscationMask(
                        Arrays.asList("codigo", "telefonoLlamada"))
                .build();

        RestConnectorResponse restConnectorResponse = restConnector.doRequest(request);

        restErrorMappingHelper.throwErrorIfExists(
                restConnectorResponse, "SMGG20210023", () -> {
                    return "";
                });

    }
}
