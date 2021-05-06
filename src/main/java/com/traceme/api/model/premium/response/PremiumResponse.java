package com.traceme.api.model.premium.response;

import lombok.Data;

import java.util.Map;

@Data
public class PremiumResponse {
    private String result;
    private String error;
    private long quoteId;
    private Map<String, Quote> quotes;
}
