package com.hao.cloudapicommons.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String guid;

    @ApiModelProperty(value = "用户角色，多个角色用；分割：医生doctor；患者patient；")
    private String roles;

    @ApiModelProperty(value = "用户注册时间")
    private Date createTime;

    private Date updateTime;

    @ApiModelProperty(value = "客户端设备的设备信息")
    private String registerUuid;

    @ApiModelProperty(value = "注册时的ip地址")
    private String registerIp;


    @TableField(exist = false)
    private String level;


}
