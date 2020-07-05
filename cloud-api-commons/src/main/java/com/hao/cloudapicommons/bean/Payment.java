package com.hao.cloudapicommons.bean;




import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;


import java.io.Serializable;


@Data
public class Payment implements Serializable{

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String serial;

}