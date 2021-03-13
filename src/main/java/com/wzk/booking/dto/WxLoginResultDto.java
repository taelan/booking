package com.wzk.booking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/13 - 16:00
 */
@Data
@ApiModel("登录信息DTO")
public class WxLoginResultDto {
    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "openId")
    private String openId;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "语言")
    private String language;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "头像URL")
    private String avatarUrl;

    @ApiModelProperty(value = "唯一标识")
    private String unionId;

    @ApiModelProperty(value = "创建时间")
    private Date create_date;
}
