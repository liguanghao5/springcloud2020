package com.hao.springcloud.cloudproviderpayment8001.service.impl;

import com.hao.springcloud.cloudproviderpayment8001.bean.User;
import com.hao.springcloud.cloudproviderpayment8001.mapper.UserMapper;
import com.hao.springcloud.cloudproviderpayment8001.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
