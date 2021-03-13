package com.wzk.booking.service.impl;

import com.wzk.booking.dto.WxLoginResultDto;
import com.wzk.booking.service.WxLoginResultService;
import org.springframework.stereotype.Service;

/**
 * @author WANGZHONGKANG
 * @date 2021/3/13 - 17:09
 */
@Service
public class WxLoginResultServiceImpl implements WxLoginResultService {

    /**
     *  处理小程序登录授权
     */
    @Override
    public WxLoginResultDto dealLoginAuth(String  code, String data, String iv) {
        WxMaJscode2SessionResult session =new WxMaJscode2SessionResult();
        //调微信官方接口获得sesssion_key openid存到 session对象里
        try {　　　　　　  //code换取sessionKey
            session = wxMaService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());

        } catch (WxErrorException e) {
            this.logger.error("获得sessionKey失败", e);
        }
        WxMaAuthResult wxMaAuthResult = new WxMaAuthResult();　　　　 //该类用来存储用户信息
        WxMaUserInfoExtends wxMaUserInfoExtends =  new WxMaUserInfoExtends();
        WxMaUserInfo wxMaUserInfo = new WxMaUserInfo();
        //暂时写死失效时间
        int expire=3600;
        String sessionKey = session.getSessionKey();
        String rawData = StringEscapeUtils.unescapeHtml4(data);
        // 解密用户信息
        try {　　　　　　　//sessionkey data iv 解密用户信息
            wxMaUserInfo = this.wxMaService.getUserService().getUserInfo(sessionKey, data, iv);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("解密用户信息失败");
            e.printStackTrace();
        }
        BeanUtils.copyProperties(wxMaUserInfo, wxMaUserInfoExtends);
        String third_session = Base64UUID.ramdomID();
        wxMaAuthResult.setToken(third_session);
        String user_id = Base64UUID.ramdomID();
        wxMaUserInfoExtends.setUser_id(user_id);
        //通过openid获取或新增用户信息
        if(wxMaUserMapper.countAny(session.getOpenid())>0 ){
            //存在 数据库更新
            wxMaUserMapper.addWxMaUser(wxMaUserInfoExtends);
            //这里是将用户信息存到redis
            wxMaAuthSessionStorage.addWxMaSession(expire,third_session,wxMaUserInfoExtends);
            //不把openId传到前台
            wxMaUserInfo.setOpenId("");
            wxMaAuthResult.setIsReg(true);
            wxMaAuthResult.setSuccess(true);
            wxMaAuthResult.setWxMaUserInfoExtends(wxMaUserInfoExtends);
        } else {
            //不存在 数据库保存信息
            wxMaUserMapper.addWxMaUser(wxMaUserInfoExtends);
            wxMaAuthSessionStorage.addWxMaSession(expire,third_session,wxMaUserInfoExtends);
            wxMaUserInfo.setOpenId("");
            wxMaAuthResult.setSuccess(true);
            wxMaAuthResult.setIsReg(false);
            wxMaAuthResult.setWxMaUserInfoExtends(wxMaUserInfoExtends);
        }
        return wxMaAuthResult;
    }
}
