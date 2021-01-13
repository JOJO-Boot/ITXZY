package com.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.pojo.User;
import com.service.UserService;
import com.service.imp.OssService;
import com.service.imp.SmsService;
import com.util.DESUtil;
import com.util.MD5Util;
import com.util.MemcachedUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class VerifyController {

    static Logger logger = Logger.getLogger(VerifyController.class);
    @Autowired
    SmsService smsService;
    @Autowired
    UserService userService;

    MD5Util MD5 = new MD5Util();
    MemcachedUtil memcachedUtil = new MemcachedUtil();

    @RequestMapping(value = "/toRegisterByPhone")
    public String toRegisterByPhone(){
        return "registerByPhone";
    }

    @RequestMapping(value = "/toRegisterByEmail")
    public String toRegisterByEmail(){
        return "registerByEmail";
    }

    @RequestMapping(value = "/toSendCode")
    public String toSendCode(){
        return "sendCode";
    }

    @RequestMapping(value = "/sendCode")
    public String sendCode(HttpServletRequest request) throws ClientException {
        String phoneNumber = request.getParameter("phone");
        logger.info("输入手机号为"+ phoneNumber);
        //发送短信
        SendSmsResponse sendSmsResponse= smsService.sendSms(phoneNumber);
        logger.info("短信接口返回数据----------------");
        logger.info("Code=" + sendSmsResponse.getCode());
        logger.info("Message=" + sendSmsResponse.getMessage());
        return "redirect:/toRegisterByPhone";
    }

    @RequestMapping(value = "/registerByPhone")
    public String registerByPhone(User user, Model model){
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        String code = user.getCode();
        String key = (String) memcachedUtil.get("code");
        logger.info("获取缓存中的验证码为" + key);
        logger.info("输入账号为:" + username + "密码码为:" + password + "手机号：" + phone + "验证码:" + code);
        //判断输入的用户名是否为空或者空字符
       if(code.equals(key)){
        if(username != null && username !="" && phone != null && phone != ""){
            //判断数据库中是否有此用户名
            User user1 = userService.findUser(username);
            //如果查询出的账户为空（代表用户不存在），才能注册
            if(ObjectUtils.isEmpty(user1)){
                try{
                    //对传入的密码用MD5进行加密加盐
                    String MD5Password = MD5.generate(password);
                    //设置密码为新密码
                    user.setPassword(MD5Password);
                    //插入数据
                    int id = userService.addUser(user);
                    System.out.print("注册成功，请登录，用户ID是：" + id);
                    //返回到登录页面
                    return "redirect:/toLogin";
                }catch (Exception e){
                    System.out.print("注册失败，请重新填写注册信息");
                    model.addAttribute("mes","注册失败，请重新填写注册信息");
                    return "redirect:/toRegister";
                }
            }else {
                System.out.print("用户名已经存在，请更换用户名");
                model.addAttribute("mes","用户名已经存在，请更换用户名");
                return "redirect:/toRegister";
            }
        }else{
            System.out.print("用户名不能为空");
            model.addAttribute("mes","用户名不能为空");
            return "redirect:/toRegister";
        }

    }else {
           logger.info("验证码不正确");
       }
        return null;
    }
  }

