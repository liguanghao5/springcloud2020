package com.hao.springcloud.cloudconsumerorder8002.service;

import com.hao.cloudapicommons.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient("cloud-payment-service")
public interface PaymentService {


    @GetMapping("/getPayMent/{id}")
    public Payment getPayMent001(@PathVariable("id") long id);


    @GetMapping("/run3s")
    public String run3s();


}
