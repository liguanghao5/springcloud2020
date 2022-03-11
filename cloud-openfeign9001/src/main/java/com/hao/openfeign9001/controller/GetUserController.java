package com.hao.openfeign9001.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hao.openfeign9001.service.User1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GetUserController {

    @Autowired
    User1Service user1Service;


    @GetMapping("/getUserName")
    public  String getUserName(){

        log.info("getUserName11");
        return "getUserName";
        //return user1Service.getUserName();
    }

    /**
     * sentinel持久化测试
     * @return
     */
    @GetMapping("/persistenceTest")
    @SentinelResource(value = "persistenceTest",blockHandler = "blo_persistenceTest")
    public  String persistenceTest(){

        log.info("persistenceTest");

        return "persistenceTest";
    }


    public  String blo_persistenceTest(BlockException exception){

        log.info("blo_persistenceTest");

        return "blo_persistenceTest";
    }





}
