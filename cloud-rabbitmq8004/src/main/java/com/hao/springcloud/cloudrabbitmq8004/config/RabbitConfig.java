package com.hao.springcloud.cloudrabbitmq8004.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    /**
     * 消息队列中通过json的格式实例化消息对象
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }



//=====================队列=============================

    @Bean
    public Queue helloQueue() {

        /**
         * name:队列名字
         * durable:是否支持持久化，默认true
         * exclusive:表示该消息队列是否只在当前connection中生效，默认是false
         * autoDelete:没有消息和连接时是否自动删除，默认时false
         */
        Queue hello = new Queue("hello",true,false,false);
        return hello;
    }

//==========================direct==========================================================

    /**
     * 直连交换器
     */
    @Bean
    public DirectExchange directExchange(){
        /**
         * name:交换器的名字
         * durable:是否支持持久化，默认为true
         * autoDelete:不使用时是否自动删除，默认为false
         */
        return new DirectExchange("directExchange",true,true);
    }

    /**
     * user队列
     */
    @Bean
    public Queue userQueue() {
        return new Queue("user",true,false,true);
    }

    /**
     * user2队列
     */
    @Bean
    public Queue userQueue2() {
        return new Queue("user2",true,false,true);
    }

    /**
     * 把user队列绑定到 directExchange 交换器中 routingKey 为 user
     * @param userQueue user队列，注意参数名要和user队列的方法名统一
     * @param directExchange 直连交换器，注意参数名要和直连交换器方法名统一
     */
    @Bean
    public Binding bindingDirectUserQueue(Queue userQueue,DirectExchange directExchange){
        return BindingBuilder.bind(userQueue).to(directExchange).with("user_routingKey");
    }
    /**
     * 把user2队列绑定到 directExchange 交换器中 routingKey 为 user
     * @param userQueue2 user队列，注意参数名要和user队列的方法名统一
     * @param directExchange 直连交换器，注意参数名要和直连交换器方法名统一
     */
    @Bean
    public Binding bindingDirectUserQueue2(Queue userQueue2,DirectExchange directExchange){
        return BindingBuilder.bind(userQueue2).to(directExchange).with("user_routingKey");
    }


//==============================fanout================================================================


    /**
     * 广播类型的交换器
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange",true,true);
    }

    // 创建消息队列 A、B、C

    @Bean
    public Queue AMessage() {
    return new Queue("fanoutQA",true,false,true);
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanoutQB",true,false,true);
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanoutQC",true,false,true);
    }

    // 队列和交换器绑定


    @Bean
    public Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }



//========================topic=====================================================================

    /**
     * 根据规则匹配实现多对多的交换器
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange",true,true);
    }

    // 创建两个队列

    @Bean
    public Queue queueMessage1() {
        return new Queue("topicQ1",true,false,true);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue("topicQ2",true,false,true);
    }

    // 队列和交换器绑定

    /**
     * 将队列topic.messages1与exchange绑定，binding_key为topic.#,模糊匹配
     */
    @Bean
    public Binding bindingExchangeMessage1(Queue queueMessage1, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage1).to(topicExchange).with("topic.#");
    }

    /**
     * 将队列topic.messages2与exchange绑定，binding_key为topic.#,模糊匹配
     */
    @Bean
    public Binding bindingExchangeMessage2(Queue queueMessage2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage2).to(topicExchange).with("topic.*");
    }





}
