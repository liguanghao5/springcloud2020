package com.hao.springcloud.cloudproviderpayment8001.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.cloudapicommons.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-04
 */
@Component
public interface UserMapper extends BaseMapper<User> {


    IPage selectAllPage(Page page, @Param(Constants.WRAPPER)QueryWrapper<User> queryWrapper);

    IPage selectAllPage2(Page page, @Param("roles") String roles,@Param("guid") String guid);
}
