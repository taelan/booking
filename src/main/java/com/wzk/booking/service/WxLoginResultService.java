package com.wzk.booking.service;

import com.wzk.booking.request.WxLoginRequest;
import com.wzk.booking.result.WxLoginResult;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/13 - 17:08
 */
public interface WxLoginResultService {
    WxLoginResult wxLogin(WxLoginRequest loginRequest) throws Exception;
}
