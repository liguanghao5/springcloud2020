package com.hao.springcloud.cloudconsumerorder8002.service.fallback;

import com.hao.cloudapicommons.bean.User;
import com.hao.cloudapicommons.util.R;
import com.hao.springcloud.cloudconsumerorder8002.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {
    @Override
    public R addUser(User user) {
        return null;
    }

    @Override
    public R getUser(long id) {
        return null;
    }
}
