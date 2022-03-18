package com.hao.cloudsentinel8100.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    /**
     * 链路模式流控测试
     * @return
     */
    @SentinelResource(value = "getC",blockHandler = "blo_getC") //sentinel资源名
    public String getC(){
        return "TestServiceGetC";
    }

    public String blo_getC(BlockException exception){
        return "没猜错的话你应该是getC1请求的吧(*￣︶￣)";
    }


}
