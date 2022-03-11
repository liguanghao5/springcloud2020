package com.hao.openfeign9001.service;

import com.hao.openfeign9001.service.fallback.User1ServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "openfeign9002",fallback = User1ServiceFallback.class)
public interface User1Service {

    @GetMapping("/getUserName")
    public String getUserName();

}
