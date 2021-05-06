package com.traceme.api.model.purchase.response;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseResponse {
    private String result;
    private String error;
    private String policyNumber;
    private List<Object> documents;
}
