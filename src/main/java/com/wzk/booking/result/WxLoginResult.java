package com.wzk.booking.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/15 - 18:21
 */
@Data
@ApiModel("微信小程序登录返回结果")
public class WxLoginResult {

    @ApiModelProperty("session_key")
    private String session_key;

    @ApiModelProperty("用户名")
    private String customerName;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("errcode 错误码")
    private String errcode;

    @ApiModelProperty("errmsg 错误信息")
    private String errmsg;


}
