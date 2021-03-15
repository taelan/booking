package com.wzk.booking.service.impl;


import cn.binarywang.wx.miniapp.api.WxMaService;
import com.alibaba.fastjson.JSONObject;
import com.wzk.booking.common.Constants;
import com.wzk.booking.request.WxLoginRequest;
import com.wzk.booking.result.WxLoginResult;
import com.wzk.booking.service.WxLoginResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/13 - 17:09
 */
@Service
public class WxLoginResultServiceImpl implements WxLoginResultService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String code2Session = "/sns/jscode2session?appid={appid}&secret={secret}&js_code={jsCode}&grant_type=authorization_code";

    @Resource
    private WxMaService wxMaService;

    private RestTemplate restTemplate;


    /**
     *  处理小程序登录授权
     */
    @Override
    public WxLoginResult wxLogin(WxLoginRequest loginRequest) throws Exception {
        WxLoginResult result = new WxLoginResult();
        //打包请求参数
        Map<String,String> params = new HashMap<>();
        params.put("appid", Constants.WX_APP_ID);
        params.put("secret",Constants.WX_APP_SECRET);
        params.put("jsCode",loginRequest.getCode());

        //请求微信小程序登录接口
        JSONObject object = restTemplate.getForObject(Constants.WX_APP_UIL+code2Session,JSONObject.class,params);
        if(object.isEmpty()){
            throw new Exception("微信登录失败,微信返回为空");
        }


        return result;
    }
}
