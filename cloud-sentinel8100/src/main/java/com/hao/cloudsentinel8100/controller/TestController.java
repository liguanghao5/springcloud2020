package com.hao.cloudsentinel8100.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/getA")
    public String getA(){

        return "getA";
    }


    @GetMapping("/getB")
    public String getB(){

        return "getB";
    }


}
