package com.traceme.api.model.finalise.response;

import lombok.Data;

@Data
public class FinaliseResponse {
    private String result;
    private String error;
    private long policyId;
    private String premium;
}
