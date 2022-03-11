package com.hao.cloudsentinel8100.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    /**
     * 链路模式流控测试
     * @return
     */
    @SentinelResource(value = "getC") //sentinel资源名
    public String getC(){
        return "TestServiceGetC";
    }


}
