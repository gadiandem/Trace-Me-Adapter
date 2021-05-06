package com.traceme.api.service;

import org.apache.http.client.methods.CloseableHttpResponse;

public interface HttpRequestService {
    CloseableHttpResponse postFormUrlencoded(String endpoint, String auth, String data);

    CloseableHttpResponse postRequestAuthorization(String endpoint, String auth, String data);
    CloseableHttpResponse postRequestUnAuthorization(String endpoint, String data);
}
