package com.hao.springcloud.cloudconsumerorder8002.service;

import com.hao.cloudapicommons.bean.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient(value = "cloud-payment-service",fallback = PaymentServiceFallback.class)
public interface PaymentService {



    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);




    @GetMapping("/getPayMent/{id}")
    public Payment getPayMent001(@PathVariable("id") long id);


    @GetMapping("/run3s")
    public String run3s();


}

@Service
class PaymentServiceFallback implements PaymentService{

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "兜底方法----paymentInfo_TimeOut";
    }

    @Override
    public Payment getPayMent001(long id) {
        return null;
    }

    @Override
    public String run3s() {
        return "兜底方法----run3s";
    }
}