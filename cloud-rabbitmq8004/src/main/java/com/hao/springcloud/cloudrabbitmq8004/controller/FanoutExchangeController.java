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
@RequestMapping("/fanout")
public class FanoutExchangeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送广播消息
     */
    @GetMapping("/sendFanout")
    public R sendFanout(){

        String message = "fanout-Message";//发送到队列的消息内容

        /**
         * 因为时广播，所以路由key：routingKey 设置为空就可以了，也可以随意写。但是不能没有这个入参！
         */
        rabbitTemplate.convertAndSend("fanoutExchange","",message);

        return R.ok();
    }

    //从三个队列中自动取出消息

    @RabbitListener(queues = "fanoutQA")
    public void getFanoutA(String message){
        log.info("fanoutQA："+message);
    }

    @RabbitListener(queues = "fanoutQB")
    public void getFanoutB(String message){
        log.info("fanoutQB："+message);
    }

    @RabbitListener(queues = "fanoutQC")
    public void getFanoutC(String message){
        log.info("fanoutQC："+message);
    }





}
