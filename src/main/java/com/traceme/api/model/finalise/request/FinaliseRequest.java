package com.traceme.api.model.finalise.request;

import lombok.Data;

@Data
public class FinaliseRequest {
    private String agencyId;
    private String agencyCode;
    private String quoteId;
    private String schemeId;
    private String titleCustomer;
    private String firstNameCustomer;
    private String lastNameCustomer;
    private String email;
    private String mobile;
}
