package com.cloud.badminton.project.wx.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.api.impl.WxMaUserServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import cn.hutool.http.HttpUtil;
import com.cloud.badminton.framework.common.utils.RedisUtils;
import com.cloud.badminton.project.wx.entity.WxLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 10:54
 */
@Service
@Slf4j
public class MyWxService {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    WxMaService wxMaService;

    public WxMaJscode2SessionResult login(String code) {
        WxMaJscode2SessionResult info = null;
        try {
            info = new WxMaUserServiceImpl(wxMaService).getSessionInfo(code);
            redisUtils.setValueExpire(info.getOpenid(), info.getSessionKey(), 120);
            /*将sessionKey值为空*/
            info.setSessionKey("");
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return info;
    }

    public WxMaUserInfo getUserInfo(WxLoginVo wxLoginVo) {
        final WxMaUserServiceImpl wxMaUserService = new WxMaUserServiceImpl(new WxMaServiceImpl());
        final String session_key = (String) redisUtils.getValue(wxLoginVo.getOpenid());
        final boolean checkUserInfo = wxMaUserService.checkUserInfo(session_key, wxLoginVo.getRawData(), wxLoginVo.getSignature());
        if (checkUserInfo) {
            return wxMaUserService.getUserInfo(session_key, wxLoginVo.getEncryptedData(), wxLoginVo.getIv());
        }
        return null;
    }




}
