package com.hao.springcloud.cloudrabbitmq8004.controller;


import com.hao.cloudapicommons.bean.User;
import com.hao.cloudapicommons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloQueuesController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 直接把消息发送到hello队列中
     */
    @GetMapping("/sendHello")
    public R sendHello(){


        for (int i = 0; i < 20 ; i++) {
            String message = "hello:helloQueue"+i;
            log.info("发送消息到hellod队列："+message);
            rabbitTemplate.convertAndSend("hello",message);
        }

        return R.ok();
    }

    /**
     * 从hello队列中取出发送的消息
     */
    @GetMapping("/getHello")
    public R getHello(){
        Object helloMessage = rabbitTemplate.receiveAndConvert("hello");
        log.info("从hello队列中取出发送的消息："+helloMessage);
        return R.ok(helloMessage);
    }


    @RabbitListener(queues = "hello")
    public void getHelloLer1(String helloMessage) throws InterruptedException {
        Thread.sleep(5000);
        log.info("监听hello队列获取消息1:"+helloMessage);
    }
//
//    @RabbitListener(queues = "hello")
//    public void getHelloLer2(String helloMessage) throws InterruptedException {
//        Thread.sleep(3000);
//        log.info("监听hello队列获取消息2:"+helloMessage);
//    }



}
