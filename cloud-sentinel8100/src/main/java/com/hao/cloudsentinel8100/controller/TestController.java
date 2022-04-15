package com.hao.cloudsentinel8100.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.hao.cloudsentinel8100.myBlockHand.TestBlockHand;
import com.hao.cloudsentinel8100.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;


    @GetMapping("/getA")
    public String getA(){

        int i = 1/0;
        return "getA";
    }


    @GetMapping("/getB")
    public String getB(){

        return "getB";
    }


    /**
     * 链路模式流控测试，只控制 getC1 的资源名
     * @return
     */
    @GetMapping("/getC1")
    public String getC1(){
        log.info("=====请求getC1");
        return testService.getC();
    }
    @GetMapping("/getC2")
    public String getC2(){
        log.info("====请求getC1");
        return testService.getC();
    }


    @GetMapping("/getD")
    public String getD(){
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info("getD");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "getD";
    }

    /**
     * 降级异常数
     * @return
     */
    @GetMapping("/getE")
    @SentinelResource(value = "getE",blockHandler = "blo_getE")
    public String getE(){

        log.info("getE");
        int i = 10/0;
        return "getE";
    }

    public String blo_getE(BlockException exception){

        log.info("blo_getE");

        return "blo_getE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "blo_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){

        return "testHotKey-p1:"+p1+"  p2:"+p2;
    }

    public String blo_testHotKey( String p1, String p2,BlockException exception){

        return "blo_testHotKey-p1:"+p1+"  p2:"+p2;
    }

    /**
     *
     * @param v1
     *
     * blockHandler:限流兜底的方法
     * fallback:异常兜底的方法
     * exceptionsToIgnore:忽略某个异常
     */
    @GetMapping("/getF")
    @SentinelResource(value = "getF",blockHandler = "blo_getF" ,fallback = "getF_back",exceptionsToIgnore = {IllegalArgumentException.class})
    public String getF(@RequestParam(value = "v1")Integer v1){
        if (v1.equals(1)){
            throw  new IllegalArgumentException("IllegalArgumentException异常，非法入参");
        }else if(v1.equals(2)){
            throw  new RuntimeException("其他异常");
        }

        return "getF:"+v1;
    }

    public String blo_getF (Integer v1, BlockException exception){
        log.info("我是限流返回方法blo_getF:"+v1);
        return "我是限流返回方法blo_getF:"+v1;
    }

    public String getF_back (Integer v1){
        log.info("我是异常兜底方法getF_back:"+v1);
        return "我是异常兜底方法getF_back:"+v1;
    }

    /**
     * blockHandlerClass:限流兜底的类
     * blockHandler:限流兜底的类的方法
     * @return
     */
    @GetMapping("/getG")
    @SentinelResource(value = "getG",blockHandlerClass = TestBlockHand.class,blockHandler = "blo_getG")
    public String getG(){

        return "getG";
    }

    /**
     * 热点限流
     * @return
     */
    @GetMapping("/getH")
    @SentinelResource(value = "getH" ,blockHandler = "blo_getH")
    public String getH(@RequestParam(value = "aa",required = false)String aa,
                       @RequestParam(value = "bb",required = false)String bb){


        return "getH"+aa;
    }

    public String blo_getH(String aa ,String bb,BlockException exception){
        return "blo_getH"+aa;
    }


    @GetMapping("/getI")
    @SentinelResource(value = "getI" ,blockHandler = "blo_getI")
    public String getI(@RequestParam(value = "aa",required = false)String aa){

        return "getI"+aa;
    }

    /**
     * getI 的兜底的方法
     * @param aa
     * @param exception
     * @return
     */
    public String blo_getI(String aa ,BlockException exception){

        return "blo_getI:"+aa+"异常信息:"+exception.getMessage();
    }


    @GetMapping("/getJ")
    @SentinelResource(value = "getJ" ,fallback = "getJ_back")
    public String getJ(@RequestParam(value = "aa",required = false)String aa){
        int i = 1/0;
        return "getJ"+aa;
    }

    /**
     * getJ接口异常的兜底方法
     * @param aa
     * @return
     */
    public String getJ_back(String aa){
        return "getJ接口异常，入参:"+aa;
    }

    @GetMapping("/getK")
    @SentinelResource(value = "getK" ,fallback = "getK_back" ,
            exceptionsToIgnore = {IllegalArgumentException.class})
    public String getK(@RequestParam(value = "aa",required = false)String aa){

        if(aa == null){
            throw new IllegalArgumentException();
        }else{
            int i=1/0;
        }
        return "getK"+aa;
    }


    public String getK_back(String aa){
        return "getK接口异常，入参:"+aa;
    }


}
