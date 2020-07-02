package com.hao.springcloud.cloudproviderpayment8001.controller;


import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.cloudapicommons.bean.User;
import com.hao.cloudapicommons.util.R;
import com.hao.springcloud.cloudproviderpayment8001.mappers.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public R addUser(User user){

        log.info("addUser入参："+user);

        int insert = userMapper.insert(user);

        return R.ok(user);

    }

    /**
     * 获取一个用户
     * @param id
     * @return
     */
    @GetMapping("getUser")
    public R getUser(long id){

        User user = userMapper.selectById(id);

        return R.ok(user);

    }

    @GetMapping("getUserList")
    public R getUserList(String roles,int current,int size){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roles", roles);
        queryWrapper.allEq(params);

        queryWrapper.orderByDesc("id");//根据id倒叙排序

        IPage iPage = new Page(current,size);//分页

        IPage data = userMapper.selectPage(iPage, queryWrapper);

        return R.ok(data);

    }

    @PutMapping("updateUser")
    public R updateUser(User user){

        log.info("updateUser入参："+user);

        userMapper.updateById(user);

        return R.ok();
    }


    @DeleteMapping("deleteUser")
    public R deleteUser(long id){

        userMapper.deleteById(id);

        return R.ok();
    }


}
