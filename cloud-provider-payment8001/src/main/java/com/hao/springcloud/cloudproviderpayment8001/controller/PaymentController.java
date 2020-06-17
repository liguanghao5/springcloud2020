package com.hao.springcloud.cloudproviderpayment8001.controller;

import com.hao.cloudapicommons.bean.Payment;
import com.hao.springcloud.cloudproviderpayment8001.mappers.PaymentMapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局的
public class PaymentController {

    @Value("${server.port}")
    private String port;


    @Autowired
    PaymentMapper paymentMapper;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){

        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }



    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_fallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //5秒钟以内就是正常的业务逻辑
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){

        int a = 10/id;

        int b = 3;//方法执行3秒

        try {
            TimeUnit.SECONDS.sleep(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "线程池："+Thread.currentThread().getName()+"----"+a+"";
    }


    public String paymentInfo_TimeOut_fallback(Integer id){
        return "线程池："+Thread.currentThread().getName()+"我来兜底了";
    }

    public String payment_Global_FallbackMethod(){
        return "线程池："+Thread.currentThread().getName()+"我来兜底了，我是全局兜底";
    }





    @GetMapping("/getPayMent/{id}")
    public Payment getPayMent(@PathVariable("id") long id){

        Payment payment = paymentMapper.selectByPrimaryKey(id);

        payment.setPort(port);//获取当前服务器的端口号，用于区别

        log.info("payment:"+payment);
        return payment;

    }

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){

        String massger = "hello  "+name;

        System.out.println("hello  "+name);

        return massger;

    }

    @GetMapping("/run3s")
    public String run3s(){

        try {

            TimeUnit.SECONDS.sleep(3);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return "成功";
    }






}
