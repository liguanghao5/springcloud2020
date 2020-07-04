package com.hao.springcloud.cloudproviderpayment8001.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao.cloudapicommons.bean.Payment;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentMapper extends BaseMapper<Payment> {

    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}