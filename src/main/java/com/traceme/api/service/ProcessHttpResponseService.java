package com.traceme.api.service;

import com.traceme.api.model.finalise.response.FinaliseResponse;
import com.traceme.api.model.premium.response.PremiumResponse;
import com.traceme.api.model.purchase.response.PurchaseResponse;
import org.apache.http.client.methods.CloseableHttpResponse;

public interface ProcessHttpResponseService {
    PremiumResponse premiumResProcess(CloseableHttpResponse response);
    FinaliseResponse finaliseResProcess(CloseableHttpResponse response);
    PurchaseResponse purchaseResProcess(CloseableHttpResponse response);
}
