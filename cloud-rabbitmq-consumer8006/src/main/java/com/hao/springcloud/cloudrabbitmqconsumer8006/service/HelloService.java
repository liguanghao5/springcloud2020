package com.hao.springcloud.cloudrabbitmqconsumer8006.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class HelloService {


    @RabbitListener(queues = "helloQ")
    public void getHelloLer(Message message, Channel channel) throws IOException {

        try {

            log.info("成功接收到helloQ的消息："+new String(message.getBody(),"UTF-8"));

            /**手动确认接受消息，告诉队列删除对应的消息
             * 参数1：获取消息的id，表明接受的是哪个消息
             * 参数2：是否批量.true:将一次性ack所有小于deliveryTag的消息。
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

        } catch (IOException e) {

            /**手动拒绝消息
             * 参数1：获取消息的id，表明接受的是哪个消息
             * 参数2：是否批量.true:将一次性ack所有小于deliveryTag的消息。
             * 参数3：被拒绝的是否重新入队列
             */
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }

    }



}
