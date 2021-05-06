package com.traceme.api.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Base64;

//@Slf4j
//@Service
public class HttpRequestServiceImp implements HttpRequestService {

    public CloseableHttpResponse postFormUrlencoded(String endpoint, String auth, String data) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endpoint);
//        int statusCode = 500;
        CloseableHttpResponse response;
        try {
            StringEntity postingString = new StringEntity(data);
            String BasicBase64format = Base64.getEncoder().encodeToString(auth.getBytes());
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/x-www-form-urlencoded");
            post.setHeader("Authorization", "Basic " + BasicBase64format);
            response = httpClient.execute(post);
//            statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
//            log.error("import-merchants", e);
            return null;
        }
        return response;
    }

    public CloseableHttpResponse postRequestAuthorization(String endpoint, String auth, String data) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endpoint);
//        int statusCode = 500;
        CloseableHttpResponse response;
        try {
            StringEntity postingString = new StringEntity(data);
            //gson.tojson() converts your pojo to json
            String BasicBase64format = Base64.getEncoder().encodeToString(auth.getBytes());
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            post.setHeader("Authorization", "Basic " + BasicBase64format);
            response = httpClient.execute(post);
//            statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
//            throw new ApplicationException(APP_ERROR_CODE, e.getMessage(), statusCode);
            return null;
        }
        return response;
    }

    @Override
    public CloseableHttpResponse postRequestUnAuthorization(String endpoint, String data) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(endpoint);
//        int statusCode = 500;
        CloseableHttpResponse response;
        try {
            StringEntity postingString = new StringEntity(data);
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            response = httpClient.execute(post);
//            statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
//            throw new ApplicationException(APP_ERROR_CODE, e.getMessage(), statusCode);
            return null;
        }
        return response;
    }
}
