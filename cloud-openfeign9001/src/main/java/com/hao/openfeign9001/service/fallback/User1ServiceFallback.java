package com.hao.openfeign9001.service.fallback;

import com.hao.openfeign9001.service.User1Service;
import org.springframework.stereotype.Component;


/**
 * 这个是User1Service兜底的类
 */
@Component
public class User1ServiceFallback implements User1Service {


    @Override
    public String getUserName() {
        return "User1Service微服务异常，我是来兜底的";
    }
}
