package com.hao.springcloud.cloudconsumerorder8002.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "用户信息")
public class User {


    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty(value = "年龄",example = "1")
    private Integer age;

    @ApiModelProperty("地址")
    private String addr;

}
