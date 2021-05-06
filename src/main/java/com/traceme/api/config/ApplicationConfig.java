package com.traceme.api.config;

import com.traceme.api.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan()
public class ApplicationConfig {

    @Bean
    public TraceMeService getTraceMeService() {
        return new TraceMeServiceImp();
    }

    @Bean
    public HttpRequestService getHttpRequestService() {
        return new HttpRequestServiceImp();
    }

    @Bean
    public ProcessHttpResponseService getProcessHttpResponseService() {
        return new ProcessHttpResponseServiceImp();
    }
}
