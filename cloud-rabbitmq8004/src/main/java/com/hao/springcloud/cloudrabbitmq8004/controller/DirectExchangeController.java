package com.hao.springcloud.cloudrabbitmq8004.controller;

import com.hao.cloudapicommons.bean.User;
import com.hao.cloudapicommons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RequestMapping("/user")
@RestController
public class DirectExchangeController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息到 directExchange 交换器中 通过 routingKey = user 分配给 队列
     * @return
     */
    @GetMapping("/sendUser")
    public R sendUser(){

        User user = new User();
        user.setCreateTime(new Date());
        user.setId(12);
        user.setGuid("liguanghao");
        log.info("发送user消息到交换器："+user);

        rabbitTemplate.convertAndSend("directExchange","user_routingKey",user);

        return R.ok();
    }

    /**
     * 发送消息到user队列
     * @return
     */
    @GetMapping("/sendUserq")
    public R sendUserq(){
        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setCreateTime(new Date());
            user.setId(i);
            user.setGuid("wangtainyu");
            log.info("发送user消息到队列："+user);

            rabbitTemplate.convertAndSend("user",user);

        }

        return R.ok();
    }

    /**
     * 从user队列中手动取出消息
     */
    @GetMapping("/getUser")
    public R getUser(){
        User user = (User) rabbitTemplate.receiveAndConvert("user");
        log.info("从user队列中手动取出消息："+user);
        return R.ok(user);
    }

    /**
     * 从user2队列中手动取出消息
     * @return
     */
    @GetMapping("/getUser2")
    public R getUser2(){
        User user = (User) rabbitTemplate.receiveAndConvert("user2");
        log.info("从user2队列中手动取出消息："+user);
        return R.ok(user);
    }


    @RabbitListener(queues = "user")
    public void getUserLer(User user){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("getUserLer:"+user);
        int i = 10/0;

    }

    @RabbitListener(queues = "user")
    public void getUserLer2(User user){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            log.info("getUserLer2222:"+user);
    }






}
