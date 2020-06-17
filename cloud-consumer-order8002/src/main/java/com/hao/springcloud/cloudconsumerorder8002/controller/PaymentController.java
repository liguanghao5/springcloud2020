package com.hao.springcloud.cloudconsumerorder8002.controller;


import com.hao.cloudapicommons.bean.Payment;
import com.hao.springcloud.cloudconsumerorder8002.service.PaymentService;
import com.hao.springcloud.cloudconsumerorder8002.service.impl.PaymentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentServiceImpl paymentServiceImpl;


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){

        String s = paymentService.paymentInfo_TimeOut(id);

        return "8002返回值："+s;
    }


    @GetMapping("/order/getPayment/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id){

        log.info("/order/getPayment--参数:"+id);

        Payment payment = paymentService.getPayMent001(id);

        log.info("/order/getPayment--返回:"+payment);

        return payment;

    }

    @GetMapping("/order/sayHello/{name}")
    public String orderSayHello(@PathVariable("name") String name){

        String s = paymentServiceImpl.sayHello(name);

        return s;

    }


    @GetMapping("/run3s")
    public String run3s(){

        String s = paymentService.run3s();

        return s;

    }




}
