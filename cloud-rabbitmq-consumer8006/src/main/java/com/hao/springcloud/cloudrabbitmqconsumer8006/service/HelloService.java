package com.hao.springcloud.cloudrabbitmqconsumer8006.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Service
@Slf4j
public class HelloService {

    /**
     * 注意接收消息的方式
     */
    @RabbitListener(queues = "helloQ")
    public void getHelloLer(Message message, Channel channel)  {

        try {

            String s = new String(message.getBody(),"UTF-8");

            log.info("成功接收到helloQ的消息："+s);


            /**手动确认接受消息，告诉队列删除对应的消息
             * 参数1：获取消息的id，表明接受的是哪个消息
             * 参数2：是否批量.true:将一次性ack所有小于deliveryTag的消息。
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        } catch (IOException e) {

            log.error("手动接收消息出错");


            //下面的代码会把Unacked中的消息返回给到Ready中，队列又发送给此消费者或者其他消费者
            //根据实际情况判断是否手动返回消息，手动返回可能造成一直死循环
            /**手动退还消息
             * 参数1：获取消息的id，表明接受的是哪个消息
             * 参数2：是否批量.true:将一次性ack所有小于deliveryTag的消息。
             * 参数3：被拒绝的是否重新入队列
             */
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            } catch (IOException e1) {
                log.error("手动退还消息出错");
            }
        }

    }


//    @RabbitListener(queues = "helloQ")
//    public void getHelloLer2(Message message, Channel channel) {
//
//        try {
//            String s = new String(message.getBody(),"UTF-8");
//
//            log.info("手动确认接收消息成功："+s);
//
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        } catch (IOException e) {
//            log.error("手动接收消息2出错");
//        }
//
//    }

    @RabbitListener(queues = "helloQ")
    public void getHelloLer2(Message message, Channel channel) {


        try {
            String s = new String(message.getBody(),"UTF-8");

            log.info("手动确认接收消息成功："+s);

            int i = 1/0;

            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        } catch (Exception e) {
            log.info("手动确认接收消息失败");
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }


    }
