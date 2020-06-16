package com.hao.springcloud.cloudconsumerorder8002.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {



    @Bean
    public Logger.Level feignLoggerLevel(){

        return Logger.Level.BASIC;
    }



    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();

    }




}
