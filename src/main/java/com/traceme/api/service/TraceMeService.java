package com.traceme.api.service;

import com.traceme.api.model.finalise.request.FinaliseRequest;
import com.traceme.api.model.finalise.response.FinaliseResponse;
import com.traceme.api.model.premium.request.PremiumRequest;
import com.traceme.api.model.premium.response.PremiumResponse;
import com.traceme.api.model.purchase.request.PurchaseRequest;
import com.traceme.api.model.purchase.response.PurchaseResponse;

public interface TraceMeService {
    PremiumResponse premium(PremiumRequest request);
    FinaliseResponse finalise(FinaliseRequest request);
    PurchaseResponse purchase(PurchaseRequest request);
}
