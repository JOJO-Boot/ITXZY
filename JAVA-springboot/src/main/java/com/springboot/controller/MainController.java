package com.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.utils.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
public class MainController implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);
    private static final long serialVersionUID = 1L;


    /**
     * 登录
     *
     * @param
     */
    @ResponseBody
    @GetMapping(value = "/login")
    public void login(String code) {
        // 微信小程序ID
        String appId = "wxd70f3bec26190eba";
        // 微信小程序秘钥
        String secret = "31a31f57c4aadcc69fc659b9108e8160";
        // 根据小程序穿过来的code想这个url发送请求
        String url = "https://api.weixin.qq.com/sns/jscode2session?"
                + "appId=" + appId
                + "&secret=" + secret
                + "&js_code=" + code
                + "&grant_type=authorization_code";
        // 发送请求，返回Json字符串
        String str = HttpRequestUtil.httpRequest(url, "GET", null);
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);
        logger.info("json对象为===>" +jsonObject);
        // 我们需要的openid，在一个小程序中，openid是唯一的
        String openid = jsonObject.get("openid").toString();
        String session_key = jsonObject.get("session_key").toString();
        logger.info("openid=====>"+  openid);
        logger.info("session_key===>" + session_key);
        // 然后书写自己的处理逻辑即可
    }
} 
