package com.hao.springcloud.cloudproviderpayment8001.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.cloudapicommons.util.R;
import com.hao.springcloud.cloudproviderpayment8001.bean.Area;
import com.hao.springcloud.cloudproviderpayment8001.mapper.AreaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import sun.applet.Main;

/**
 * <p>
 * 省表 前端控制器
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-08
 */
@RestController
@RequestMapping("/area")
@Slf4j
public class AreaController {


    @Autowired
    private AreaMapper areaMapper;


    @GetMapping("/get")
    public R getArea(){

        log.info("aabb");

        Page<Area> areaPage = areaMapper.selectPage(new Page<>(1, 10), null);


        return R.ok(areaPage);
    }





}

