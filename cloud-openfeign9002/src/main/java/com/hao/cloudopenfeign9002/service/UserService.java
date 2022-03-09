package com.hao.cloudopenfeign9002.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserService {


    @GetMapping("/getUserName")
    public String getUserName() {

        log.info("user1微服务的userName");
        return "user1微服务的userName";
    }


}
