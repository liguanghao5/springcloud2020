package com.hao.springcloud.cloudrabbitmq8004.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }



    //=====================队列=============================

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue userQueue() {
        return new Queue("user");
    }
//
//    @Bean
//    public Queue queueMessage() {
//        return new Queue("topic.message");
//    }
//
//    @Bean
//    public Queue queueMessages() {
//        return new Queue("topic.messages");
//    }
//
//    @Bean
//    public Queue AMessage() {
//        return new Queue("fanout.A");
//    }
//
//    @Bean
//    public Queue BMessage() {
//        return new Queue("fanout.B");
//    }
//
//    @Bean
//    public Queue CMessage() {
//        return new Queue("fanout.C");
//    }

    //=====================交换器====================================

    /**
     * 点对点交换器
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    /**
     * 根据规则匹配实现多对多的交换器
     * @return
     */
    @Bean
    public TopicExchange topicexchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 广播类型的交换器
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }


    //======================binding===========================================

    @Bean
    public Binding aabb(Queue helloQueue , DirectExchange directExchange){
        return BindingBuilder.bind(helloQueue).to(directExchange).with("helloQueue");
    }

//    /**
//     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
//     * @param queueMessage
//     * @param exchange
//     * @return
//     */
//    @Bean
//    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }
//
//    /**
//     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
//     * @param queueMessages
//     * @param exchange
//     * @return
//     */
//    @Bean
//    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
//    }
//
//    @Bean
//    public Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(AMessage).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(BMessage).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(CMessage).to(fanoutExchange);
//    }



}
