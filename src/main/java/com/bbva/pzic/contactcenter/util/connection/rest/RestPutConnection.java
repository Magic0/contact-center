package com.bbva.pzic.contactcenter.util.connection.rest;

import com.bbva.jee.arq.spring.core.rest.RestConnectorResponse;
import com.bbva.jee.arq.spring.core.rest.requests.RestRequest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.contactcenter.util.connection.RestConnectionProcessor;
import com.bbva.pzic.routine.commons.utils.RESTUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class RestPutConnection<P, S> extends RestConnectionProcessor {

    private static final Log LOG = LogFactory.getLog(RestPutConnection.class);

    protected S connect(final String urlPropertyValue, final P entityPayload) {
        return connect(urlPropertyValue, null, null, null, entityPayload);
    }

    protected S connect(final String urlPropertyValue, final Map<String, String> pathParams, final P entityPayload) {
        return connect(urlPropertyValue, pathParams, null, null, entityPayload);
    }

    protected S connect(final String urlPropertyValue, final Map<String, String> pathParams, final HashMap<String, String> queryParams, final P entityPayload) {
        return connect(urlPropertyValue, pathParams, queryParams, null, entityPayload);
    }

    protected S connect(final String urlPropertyValue, final Map<String, String> pathParams, final HashMap<String, String> queryParams, final Map<String, String> headers, final P entityPayload) {
        String url = getProperty(urlPropertyValue);
        String payload = buildPayload(entityPayload);

        if (pathParams != null) {
            url = replacePathParamToUrl(url, pathParams);
        }

        if (queryParams != null) {
            LOG.info("Request query params: " + Arrays.toString(queryParams.entrySet().toArray()));
        }

        try {
            RestRequest request = new RestRequest.Builder("PUT", url)
                    .queryParams(queryParams)
                    .headers(buildOptionalHeaders(headers))
                    .payload(payload)
                    .useProxy(useProxy)
                    .build();

            RestConnectorResponse rcr = proxyRestConnector.doRequest(request);
            final S response = buildResponse(rcr, 1);
            evaluateResponse(response, rcr.getStatusCode());
            return response;
        }catch (BusinessServiceException e) {
            if (RESTUtils.isTimeoutException(e)) {
                LOG.error(String.format("com.bbva.pzic.contactcenter.util.connection.rest.RestPutConnection is true for RESTUtils.isTimeoutException: " +
                        "%s", e.getMessage()));
                return null;
            } else {
                throw e;
            }
        }
    }

    protected abstract void evaluateResponse(S response, int statusCode);
}
