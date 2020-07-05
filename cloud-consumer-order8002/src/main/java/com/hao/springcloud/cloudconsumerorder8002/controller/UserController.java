package com.hao.springcloud.cloudconsumerorder8002.controller;


import com.hao.cloudapicommons.bean.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-05
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @ApiOperation(value = "swagger测试头",notes = "swagger测试内")
    @ApiResponses({
            @ApiResponse(code = 200 ,message = "成功"),
            @ApiResponse(code = 400 ,message = "服务器错误"),
            @ApiResponse(code = 404 ,message = "未找到方法")
    })
    @PostMapping("/swagger/postTest")
    public User getUser(User user){

        return user;

    }









}

