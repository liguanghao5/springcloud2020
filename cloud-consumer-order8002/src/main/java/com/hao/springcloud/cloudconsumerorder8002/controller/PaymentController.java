package com.hao.springcloud.cloudconsumerorder8002.controller;


import com.hao.cloudapicommons.bean.Payment;
import com.hao.cloudapicommons.bean.User;
import com.hao.springcloud.cloudconsumerorder8002.service.PaymentService;
import com.hao.springcloud.cloudconsumerorder8002.service.impl.PaymentServiceImpl;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@Api(tags = "订单管理")
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentServiceImpl paymentServiceImpl;





    @ApiIgnore
    @ApiOperation(value = "测试超时和异常，id为零出异常")
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){

        String s = paymentService.paymentInfo_TimeOut(id);

        return "8002返回值："+s;
    }

    @ApiIgnore
    @ApiOperation(value = "根据订单id查询订单信息")
    @GetMapping("/order/getPayment/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id){

        log.info("/order/getPayment--参数:"+id);

        Payment payment = paymentService.getPayMent001(id);

        log.info("/order/getPayment--返回:"+payment);

        return payment;

    }
    @ApiIgnore
    @ApiOperation(value = "通过ribben调用服务测试")
    @GetMapping("/order/sayHello/{name}")
    public String orderSayHello(@PathVariable("name") String name){

        String s = paymentServiceImpl.sayHello(name);

        return s;

    }

    @ApiIgnore
    @ApiOperation(value = "执行三秒的方法")
    @GetMapping("/run3s")
    public String run3s(){

        String s = paymentService.run3s();

        return s;

    }




}
