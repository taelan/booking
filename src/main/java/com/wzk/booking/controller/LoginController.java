package com.wzk.booking.controller;



import com.alibaba.fastjson.JSONObject;
import com.wzk.booking.dto.WxLoginResultDto;
import com.wzk.booking.service.WxLoginResultService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/13 - 15:37
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/code")
    public String getLoginCode(String code){
        if (StringUtils.isBlank(code)){
            return "empty code";
        }
        //处理登录授权 获得openid和sessionkey，生成userid 并将session存到缓存中
        WxLoginResultDto result =
                WxLoginResultService.dealLoginAuth(code,encryptedData,iv);
        return JSONObject.toJSONString(result);
    }
}
