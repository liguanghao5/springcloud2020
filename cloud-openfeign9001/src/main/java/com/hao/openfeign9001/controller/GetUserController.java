package com.hao.openfeign9001.controller;


import com.hao.openfeign9001.service.User1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GetUserController {

    @Autowired
    private User1Service user1Service;


    @GetMapping("/getUserName")
    public  String getUserName(){

        log.info("getUserName11");

        return user1Service.getUserName();
    }


}
