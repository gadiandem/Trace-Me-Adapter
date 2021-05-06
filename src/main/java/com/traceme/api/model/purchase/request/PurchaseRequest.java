package com.traceme.api.model.purchase.request;

import lombok.Data;

@Data
public class PurchaseRequest {
    private String agencyId;
    private String agencyCode;
    private String policyId;
}
