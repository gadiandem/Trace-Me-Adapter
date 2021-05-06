package com.traceme.api.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.traceme.api.model.finalise.request.FinaliseRequest;
import com.traceme.api.model.finalise.response.FinaliseResponse;
import com.traceme.api.model.premium.request.PremiumRequest;
import com.traceme.api.model.premium.response.PremiumResponse;
import com.traceme.api.model.purchase.request.PurchaseRequest;
import com.traceme.api.model.purchase.response.PurchaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.traceme.api.constant.Constants.*;

//@Slf4j
//@Service
public class TraceMeServiceImp implements TraceMeService {
    @Value("${traceme.enviroment}")
    private String env;

    private HttpRequestService httpRequestService;
    private ProcessHttpResponseService processHttpResponseService;

    @Autowired
    public void setHttpRequestService(HttpRequestService httpRequestService) {
        this.httpRequestService = httpRequestService;
    }
    @Autowired
    public void setProcessHttpResponseService(ProcessHttpResponseService processHttpResponseService) {
        this.processHttpResponseService = processHttpResponseService;
    }

    @Override
    public PremiumResponse premium(PremiumRequest request) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        String data = gson.toJson(request);
        CloseableHttpResponse response = httpRequestService.postRequestUnAuthorization(getEndpoint(PREMIUM_ENDPOINT), data);
        PremiumResponse premiumResponse = processHttpResponseService.premiumResProcess(response);
        return premiumResponse;
    }

    @Override
    public FinaliseResponse finalise(FinaliseRequest request) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        String data = gson.toJson(request);
        CloseableHttpResponse response = httpRequestService.postRequestUnAuthorization(getEndpoint(FINALISE_ENDPOINT), data);
        FinaliseResponse finaliseResponse = processHttpResponseService.finaliseResProcess(response);
        return finaliseResponse;
    }

    @Override
    public PurchaseResponse purchase(PurchaseRequest request) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        String data = gson.toJson(request);
        CloseableHttpResponse response = httpRequestService.postRequestUnAuthorization(getEndpoint(PURCHASE_ENDPOINT), data);
        PurchaseResponse purchaseResponse = processHttpResponseService.purchaseResProcess(response);
        return purchaseResponse;
    }

    private String getEndpoint(String serviceUrl) {
        if (env != null && env.equalsIgnoreCase("testing")) {
            return TESTING_ENDPOINT + serviceUrl;
        } else {
            return PRODUCTION_ENDPOINT+ serviceUrl;
        }
    }
}
