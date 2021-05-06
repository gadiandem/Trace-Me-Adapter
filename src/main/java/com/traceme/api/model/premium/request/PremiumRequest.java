package com.traceme.api.model.premium.request;

import lombok.Data;

@Data
public class PremiumRequest {
    private String agencyId;
    private String agencyCode;
    private String productId;
    private String journeyId;
    private String startDate;
    private String endDate;
    private int luggageCount;
}
