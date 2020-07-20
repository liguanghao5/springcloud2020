package com.hao.springcloud.cloudrabbitmqproducer8005.controller;

import com.hao.cloudapicommons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/sendHello")
    public R sendHello(@RequestParam("exchange") String exchange, @RequestParam("key")String key){

        String message = "hello-message";
        log.info("发送hello消息："+message);

        rabbitTemplate.convertAndSend(exchange,key,message);
        log.info("发送了一条hello消息");

        return R.ok();
    }






}
