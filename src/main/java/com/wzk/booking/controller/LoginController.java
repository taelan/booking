package com.wzk.booking.controller;



import com.alibaba.fastjson.JSONObject;
import com.wzk.booking.request.WxLoginRequest;
import com.wzk.booking.result.WxLoginResult;
import com.wzk.booking.service.WxLoginResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/13 - 15:37
 */
@Api(tags = "微信小程序登录相关")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private WxLoginResultService wxLoginResultService;
    @ApiOperation("微信小程序登录")
    @GetMapping("/code")
    public String getLoginCode(WxLoginRequest loginRequest){
        if (StringUtils.isBlank(loginRequest.getCode())){
            return "empty code";
        }
        //处理登录授权 获得openid和sessionkey，生成userid 并将session存到缓存中
        WxLoginResult result = new WxLoginResult();
        try {
            result = wxLoginResultService.wxLogin(loginRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(result);
    }
}
