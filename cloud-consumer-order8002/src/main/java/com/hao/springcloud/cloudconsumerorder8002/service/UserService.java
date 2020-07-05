package com.hao.springcloud.cloudconsumerorder8002.service;

import com.hao.cloudapicommons.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hao.cloudapicommons.util.R;
import com.hao.springcloud.cloudconsumerorder8002.service.fallback.PaymentServiceFallback;
import com.hao.springcloud.cloudconsumerorder8002.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-05
 */


@Service
@FeignClient(value = "cloud-payment-service",fallback = UserServiceFallback.class)
public interface UserService  {


    /**
     * 添加user
     * @param user
     * @return
     */
    @PostMapping("/user/addUser")
    public R addUser(User user);


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("getUser")
    public R getUser(long id);




}

