package com.hao.springcloud.cloudconsumerorder8002.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceImpl {


    @Autowired
    RestTemplate restTemplate;


    public String sayHello(String name) {

        String url = "http://cloud-payment-service/sayHello/{name}";

        String massger = restTemplate.getForObject(url, String.class, name);

        return massger;


    }




}
