package com.wzk.booking.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/15 - 17:21
 */
@Data
@ApiModel("微信小程序登录入参")
public class WxLoginRequest {

    @ApiModelProperty(value = "wx.login()获取的code",required = true)
    private String code;

    @ApiModelProperty(value = "手机号",required = true)
    private String mobile;

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
