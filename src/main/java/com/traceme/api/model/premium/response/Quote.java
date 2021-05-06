package com.traceme.api.model.premium.response;

import lombok.Data;

import java.util.List;

@Data
public class Quote {
    private String name;
    private String premium;
    private String currency;
    private List<Benefit> benefits;
}
