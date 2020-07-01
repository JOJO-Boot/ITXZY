package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.DESUtil;
import util.MD5Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    DESUtil des = new DESUtil();
    MD5Util MD5 = new MD5Util();
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/toRegister")
    public String toRegister(){
        return "register";
    }

    /**
     * 登录
     * @param user
     * @param response
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpServletResponse response, Model model) throws Exception{

        String u = user.getUsername();
        String p = user.getPassword();

        //判断输入的用户名是否为空
        if (u != null && u !="") {
            System.out.println("用户名通过");
            User user2 = userService.findUser(u);
            System.out.println("查询内容为" + user2);

            if(!ObjectUtils.isEmpty(user2)){
                System.out.println("用户名不为空");
                if (MD5Util.verify(p,user2.getPassword())==true){
                    System.out.println("密码正确");
                    //把用户转化为long类型
                    int BId = user2.getId();
                    long B = BId;

                    //对用户id进行加密
                    String desId = des.encryptFromLong(B);
                    System.out.println("对用户id加密的结果为========" + desId);

                    //对当前时间进行des加密
                    String desTime = des.encryptFromLong(System.currentTimeMillis());
                    System.out.println("对时间加密的结果为========" + desTime);

                    //对用户id和登陆时间一起进行des加密
                    String token = des.encrypt(desId + "|" +user2.getUsername()+ "|" + desTime);
                    System.out.println("对用户id和登陆时间加密的结果（token）为========" + token);

                    //创建2个cookie赋值
                    //Cookie nameCookie = new Cookie("name",u);
                    Cookie tokenCookie = new Cookie("token", token);

                    //设置cookie存在时间
                    tokenCookie.setMaxAge(30 * 60);

                    //向客户端返回cookie
                    response.addCookie(tokenCookie);

                    //把token放到header头里
                    //response.setHeader("token",token)

                    System.out.println("登录成功，正在进入页面");
                    model.addAttribute("mes","登录成功");
                    return "redirect:/u/profession";
                }else {
                    System.out.println("密码错误,请重新输入");
                    model.addAttribute("mes","密码错误,请重新输入");
                    return "redirect:/toLogin";
                }
            }else {
                System.out.println("用户名不存在，请重新输入");
                model.addAttribute("mes","用户名不存在，请重新输入");
                return "redirect:/toLogin";
            }
        }else {
            System.out.println("用户名不能为空");
            model.addAttribute("mes","用户名不能为空");
            return "redirect:/toLogin";
        }
    }

    /**
     * 注册
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user,Model model){
        System.out.println("输入对象为" + user);

        String u = user.getUsername();
        String p = user.getPassword();

        System.out.println("输入账号为" + u + "密码为" + p);


        //判断输入的用户名是否为空 或者  空字符
        if(u != null && u !=""){

            //判断数据库中是否有此用户名
            User user1 = userService.findUser(u);

            //如果查询出的账户为空（代表用户不存在），才能注册
            if(ObjectUtils.isEmpty(user1)){

                try{

                    //对传入的密码用MD5进行加密加盐
                    String MD5Password = MD5Util.generate(p);

                    //设置密码为新密码
                    user.setPassword(MD5Password);

                    //插入数据
                    int id = userService.addUser(user);

                    System.out.print("注册成功，请登录");

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
    }

    //注销按钮
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletResponse response, HttpServletRequest Request) {
//创建一个cookie对象,得到cookie
        Cookie[] cookies = Request.getCookies();
        //先取出cookie
        for (Cookie cookie : cookies) {
//如果存在name为token的cookie,则取出并修改token的时效为0
            if (cookie.getName().equals("token")) {
                cookie.setMaxAge(0);
                System.out.println("被删除的token是" + cookie.getName());
                response.addCookie(cookie);
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

}
