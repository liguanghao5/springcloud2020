package com.hao.springcloud.cloudproviderpayment8001.bean;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 省表
 * </p>
 *
 * @author liguanghao
 * @since 2020-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Area对象", description="省表")
public class Area implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "省id")
    private Integer provinceId;

    @ApiModelProperty(value = "是id")
    private Integer cityId;

    private String name;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "级别名")
    private String levelName;

    private String code;

    private String code1;

    @ApiModelProperty(value = "区号")
    private String tel;

    private Integer status;

    private LocalDateTime createDate;

    private Date updateDate;


}
