package com.hao.cloudrabbitmq8007.controller;


import com.hao.cloudrabbitmq8007.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/send")
    public void send(@RequestParam("user") String user) {
        log.info("消息已经发送，时间为：{}",
                new Timestamp(System.currentTimeMillis()));



        this.rabbitTemplate.convertAndSend(
                RabbitConfig.DELAY_EXCHANGE,
                // routingKey
                RabbitConfig.DELAY_QUEUE,
                user);
    }



    @PostMapping("/send2")
    public void send2(@RequestParam("user") String user,@RequestParam("time") Long time) {
        log.info("消息已经发送，时间为：{}",new Timestamp(System.currentTimeMillis()));

        this.rabbitTemplate.convertAndSend(
                RabbitConfig.DELAY_EXCHANGE,
                // routingKey
                RabbitConfig.DELAY_QUEUE,
                user,
                message -> {
                    // 设置延迟毫秒值
                    message.getMessageProperties().setExpiration(String.valueOf(time));
                    return message;
                });
    }




    /**
     * queues是指要监听的队列的名字
     * @param user
     */
    @RabbitListener(queues = "process.queue")
    public void receiveDirect1(String user) {
        log.info("消息已经接收，时间为：{}",new Timestamp(System.currentTimeMillis()));
        System.out.println("【converter-receiveDirect1监听到消息】" + user);
    }

}
