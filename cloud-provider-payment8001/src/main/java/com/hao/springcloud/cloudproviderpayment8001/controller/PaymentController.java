package com.hao.springcloud.cloudproviderpayment8001.controller;

import com.hao.cloudapicommons.bean.Payment;
import com.hao.springcloud.cloudproviderpayment8001.mappers.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;


    @Autowired
    PaymentMapper paymentMapper;


    @GetMapping("/getPayMent/{id}")
    public Payment getPayMent(@PathVariable("id") long id){

        Payment payment = paymentMapper.selectByPrimaryKey(id);

        payment.setPort(port);//获取当前服务器的端口号，用于区别

        log.info("payment:"+payment);
        return payment;

    }

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){

        String massger = "hello  "+name;

        System.out.println("hello  "+name);

        return massger;

    }

    @GetMapping("/run3s")
    public String run3s(){

        try {

            TimeUnit.SECONDS.sleep(3);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return "成功";
    }






}
