package com.traceme.api.service;

import com.google.gson.Gson;
import com.traceme.api.model.finalise.response.FinaliseResponse;
import com.traceme.api.model.premium.response.PremiumResponse;
import com.traceme.api.model.purchase.response.PurchaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Slf4j
//@Service
public class ProcessHttpResponseServiceImp implements ProcessHttpResponseService {

    @Override
    public PremiumResponse premiumResProcess(CloseableHttpResponse response) {
        String result = null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode <= 299) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    result = EntityUtils.toString(entity);
                } catch (IOException ex) {
//                    log.error("refund-payment", ex);
//                    throw new ApplicationException(APP_ERROR_CODE, ex.getMessage());
                }
                Gson gson = new Gson();
                PremiumResponse resultResponse = gson.fromJson(result, PremiumResponse.class);
                return resultResponse;
            }
        }
        return null;
    }

    @Override
    public FinaliseResponse finaliseResProcess(CloseableHttpResponse response) {
        String result = null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode <= 299) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    result = EntityUtils.toString(entity);
                } catch (IOException ex) {
//                    log.error("refund-payment", ex);
//                    throw new ApplicationException(APP_ERROR_CODE, ex.getMessage());
                }
                Gson gson = new Gson();
                FinaliseResponse resultResponse = gson.fromJson(result, FinaliseResponse.class);
                return resultResponse;
            }
        }
        return null;
    }

    @Override
    public PurchaseResponse purchaseResProcess(CloseableHttpResponse response) {
        String result = null;
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode <= 299) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try {
                    result = EntityUtils.toString(entity);
                } catch (IOException ex) {
//                    log.error("refund-payment", ex);
//                    throw new ApplicationException(APP_ERROR_CODE, ex.getMessage());
                }
                Gson gson = new Gson();
                PurchaseResponse resultResponse = gson.fromJson(result, PurchaseResponse.class);
                return resultResponse;
            }
        }
        return null;
    }
}
