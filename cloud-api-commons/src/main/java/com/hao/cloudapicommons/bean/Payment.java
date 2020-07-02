package com.hao.cloudapicommons.bean;



import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
@TableName(value = "payment")
public class Payment implements Serializable{
    private Long id;

    private String serial;

}