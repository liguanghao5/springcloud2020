package com.hao.springcloud.cloudrabbitmq8004.controller;


import com.hao.cloudapicommons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/topic")
public class TopicExchangeController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送topic消息
     * @return
     */
    @GetMapping("/sendTopic")
    public R sendTopic(String s){


        String message = "topic-Message";

        String routingKey = "topic."+s;

        log.info("发送topic消息，消息内容为："+message+"路由key为："+routingKey);

        rabbitTemplate.convertAndSend("topicExchange",routingKey,message);


        return R.ok();

    }

    //两个队列自动取消息

    @RabbitListener(queues = "topicQ1")
    public void getTopic1(String message){
        log.info("topicQ1:"+message);
    }

    @RabbitListener(queues = "topicQ2")
    public void getTopic2(String message){
        log.info("topicQ2:"+message);
    }




}
