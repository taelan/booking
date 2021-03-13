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
    @ApiModelProperty(value = "登录CODE")
    private String code;

    @ApiModelProperty(value = "用户唯一标识")
    private String openId;

    @ApiModelProperty(value = "会话密钥")
    private String session_key;

    @ApiModelProperty(value = "错误码")
    private Number errcode;

    @ApiModelProperty(value = "错误信息")
    private String errmsg;

    @ApiModelProperty(value = "用户在平台唯一标识")
    private String unionId;

}
