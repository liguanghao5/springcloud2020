package com.hao.springcloud.cloudrabbitmq8004.controller;

import com.hao.cloudapicommons.bean.User;
import com.hao.cloudapicommons.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@RequestMapping("/user")
@RestController
public class DirectExchangesController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 点对点发送消息
     * @return
     */
    @GetMapping("/sendUser")
    public R sendUser(){
        User user = new User();
        user.setCreateTime(new Date());
        user.setId(12);
        user.setGuid("liguanghao");
        log.info("点对点添加消息："+user);
        /**
         * "user"：队列
         * user:消息内容
         */
        rabbitTemplate.convertAndSend("user",user);

        return R.ok();
    }

    /**
     * 点对点接受消息
     * @return
     */
    @GetMapping("/getUser")
    public R getUser(){
        User user = (User) rabbitTemplate.receiveAndConvert("user");
        log.info("点对点接受消息："+user);
        return R.ok(user);
    }


}
