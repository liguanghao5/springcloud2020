package com.hao.springcloud.cloudrabbitmqproducer8005.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMqConfig {

    /**
     * 消息队列中通过json的格式实例化消息对象
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    /**
     * 给RabbitTemplate配置属性
     * @return
     */
    @Bean
    public RabbitTemplate myRabbitTemplate(ConnectionFactory connectionFactory){

        //注意创建rabbitTemplate的写法
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        /**
          *  以下方法要想起作用，yml需要配置 publisher-confirm-type: correlated
         */

        //消息发送给没有绑定队列或者通过路由键匹配不到队列的交换机时，消息会返回给发送者,调用ConfirmCallback方法
        rabbitTemplate.setMandatory(true);

        //确认消息是否发送到exchange
        rabbitTemplate.setConfirmCallback((correlationData,ack,cause)->{
            if(ack){//发送成功
                log.info("RabbitMq消息发送到exchange成功");
            }else{//发送失败
                log.info("RabbitMq消息发送到exchange失败，原因：{"+cause+"}");
            }
        });

        //消息发送失败执行方法此方法，成功不会执行此方法-用来判断从exchange是否能正确发送给消息队列
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey)->{
            String correlationId = new String(message.getBody());
            log.info("RabbitMQ：{"+correlationId+"}消息路由失败，" +
                     "应答码：{"+replyCode+"}，" +
                     "原因：{"+replyText+"}," +
                     "交互器：{"+exchange+"}," +
                     "路由键：{"+routingKey+"}");
        });

        return rabbitTemplate;

    }

//==============================================================================

    @Bean
    public Queue helloQ(){
        return new Queue("helloQ");
    }

    @Bean
    public TopicExchange helloTop(){
        return new TopicExchange("helloTop");
    }

    @Bean
    public Binding helloToTop(){
        return BindingBuilder.bind(helloQ()).to(helloTop()).with("helloKey");
    }


}
