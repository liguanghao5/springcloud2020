package com.hao.cloudopenfeign9002.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserService {


    @GetMapping("/getUserName")
    @SentinelResource(value = "getUserName",blockHandler = "blo_getUserName")
    public String getUserName() {

        log.info("user1微服务的userName");
        return "user1微服务的userName";
    }

    public String blo_getUserName(BlockException exception){
        return "活动太火爆了，请稍后重试";
    }


}
