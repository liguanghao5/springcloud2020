package com.hao.cloudsentinel8100.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {


    @GetMapping("/getA")
    public String getA(){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "getA";
    }


    @GetMapping("/getB")
    public String getB(){

        return "getB";
    }


}
