package com.cloud.badminton.project.wx.controller;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.cloud.badminton.project.wx.entity.WxLoginVo;
import com.cloud.badminton.project.wx.service.MyWxService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
 * Create by 2023/3/6 23:25
 */
@RequestMapping("/wechat")
@RestController
public class WxController {

    @Autowired
    MyWxService myWxService;


    @GetMapping("/login")
    public WxMaJscode2SessionResult login(@RequestParam("code") String code) throws IOException, InterruptedException {
        final WxMaJscode2SessionResult login = myWxService.login(code);
        System.out.println(login);
        return login;
    }

    @PostMapping("/getUserInfo")
    public WxMaUserInfo getUserInfo(@RequestBody WxLoginVo wxLoginVo) {
        final WxMaUserInfo userInfo = myWxService.getUserInfo(wxLoginVo);
        System.out.println(userInfo);
        return userInfo;
    }

}
