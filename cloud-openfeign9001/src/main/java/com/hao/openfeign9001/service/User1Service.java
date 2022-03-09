package com.hao.openfeign9001.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "openfeign9001")
public interface User1Service {

    @GetMapping("/getUserName")
    public String getUserName();

}
