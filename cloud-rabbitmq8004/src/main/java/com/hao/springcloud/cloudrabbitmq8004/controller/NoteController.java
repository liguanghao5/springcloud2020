//package com.hao.springcloud.cloudrabbitmq8004.controller;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//@RequestMapping("/note")
//public class NoteController {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//
//    /**
//     * 发送注解消息
//     */
//    @GetMapping("/sentNote")
//    public void sentNote(){
//
//        String message = "noteMessage";
//
//        rabbitTemplate.convertAndSend("noteRK",message);
//
//        log.info("发送注解消息:"+message);
//    }
//
//
//    /**
//     * 自动取出注解消息
//     * queuesToDeclare:创建队列
//     * name：队列名
//     * autoDelete：当没有人用到队列的时候是否自动删除
//     */
//    @RabbitListener(
//            queuesToDeclare = @Queue(name = "noteRK",autoDelete = "true")
//    )
//    public void getNoteLer(String s){
//
//        log.info("取出消息："+s);
//
//    }
//
//    //==============direct类型的交换器=========================================================
//
//
//    /**
//     * 发送direct消息
//     */
//    @GetMapping("/sentNoteDic")
//    public void sentNoteDic(){
//        log.info("sentNoteDic");
//
//        String message = "noteDicMessage";
//
//        rabbitTemplate.convertAndSend("noteDicExchange","noteDicRK",message);
//
//        log.info("发送direct消息:"+message);
//    }
//
//
//    /**
//     * 自动取出direct消息
//     * bindings:创建绑定关系
//     * value：创建队列  @Queue：后边可以什么都不写，什么都不写的情况会创建一个临时队列名字随机生成一个如：Queue spring.gen-YaKy7ELPRkKgaKAkVWJ0ng,临时的队列autoDelete为true
//     * exchange：创建交换器 ：name:指定交换器的名字； type:指定交换器的类型，默认为：direct;  autoDelete:不适用时是否自动删除 ； declare：是否持久化
//     * key：绑定关系的key,可以是多个
//     */
//    @RabbitListener(
//            bindings =@QueueBinding(
//                    value = @Queue(name = "noteDicQ",autoDelete = "true"),
//                    exchange = @Exchange(name = "noteDicExchange",type = ExchangeTypes.DIRECT,autoDelete = "true",declare = "true"),
//                    key = {"noteDicRK","noteDicRK2"}
//            )
//    )
//    public void getNoteDicLer(String s){
//
//        log.info("取出direct消息："+s);
//
//    }
//
//
//    //==============fanout类型的交换器=========================================================
//
//
//    /**
//     * 发送direct消息
//     */
//    @GetMapping("/sentNoteFan")
//    public void sentNoteFan(){
//
//        String message = "noteFanMessage";
//
//        rabbitTemplate.convertAndSend("noteFanExchange","noteFanRK",message);
//
//        log.info("发送fanout消息:"+message);
//    }
//
//
//    /**
//     * 自动取出fanout消息
//     * fanout是广播类型的交换器，所以不需要配置 key 消息发送给所有绑定了他的队列
//     */
//    @RabbitListener(
//            bindings =@QueueBinding(
//                    value = @Queue(name = "noteFanQ",autoDelete = "true"),
//                    exchange = @Exchange(name = "noteFanExchange",type = ExchangeTypes.FANOUT,autoDelete = "true")
//            )
//    )
//    public void getNoteFanLer(String s){
//
//        log.info("取出fanout消息："+s);
//
//    }
//
//    //==============topic类型的交换器=========================================================
//
//
//    /**
//     * 发送topic消息
//     */
//    @GetMapping("/sentNoteTop")
//    public void sentNoteTop(){
//
//        String message = "noteTopMessage";
//
//        rabbitTemplate.convertAndSend("noteTopExchange","noteTop.key",message);
//
//        log.info("发送topic消息:"+message);
//    }
//
//
//    /**
//     * 自动取出fanout消息
//     * key:可以通过模糊匹配
//     */
//    @RabbitListener(
//            bindings =@QueueBinding(
//                    value = @Queue(name = "noteTopQ",autoDelete = "true"),
//                    exchange = @Exchange(name = "noteTopExchange",type = ExchangeTypes.TOPIC,autoDelete = "true"),
//                    key = {"noteTop.#","#.key"}
//            )
//    )
//    public void getNoteTopLer(String s){
//
//        log.info("取出topic消息："+s);
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
