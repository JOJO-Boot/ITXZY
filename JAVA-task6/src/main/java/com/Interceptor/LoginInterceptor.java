package com.Interceptor;

import com.pojo.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.DESUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Autowired
    UserService userService;
    DESUtil des = new DESUtil();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //   请求cookie里的信息,放入cookies
        Cookie[] cookies = request.getCookies();
        //如果cookies的长度等于0,表示没有cookies,返回登录页面,让用户登录一下下,发给用户一个cookie,下次光临的时候用户就有cookie了
        if(cookies.length == 0){
            logger.info("没有cookie");

            //如果没有token  就从header里取token
            String token = request.getHeader("token");

            logger.info("从header里取出的token为"+token);

            //用des对token进行解密
            String firstDecrypt = des.decrypt(token);
            logger.info("对token进行第一次解密的结果"+firstDecrypt);

            //把token解密后的结果根据|进行拆分

            String[] plaintext = firstDecrypt.split("//|");
            logger.info("把token解密后的结果根据|进行拆分");

            //token根据 | 拆分出的第一个（用户id）
            String TokenId = plaintext[0];
            logger.info("token中解密出第一个是id"+TokenId);
            long id = des.decryptToLong(TokenId);
            logger.info("把id解密并转换成long类型"+id);

            //long类型转化为int类型
            int AId = (int)id;

            //根据id查询数据库中有无此用户
            User user1 = userService.findById(AId);

            //如果用户为空，返回登录界面
            if (user1 == null){
                logger.info("没有此token内所含Id的用户,必须去登录");
                response.sendRedirect(request.getContextPath()+"/toLogin");
                return false;
            }

            //token根据 | 拆分出的第二个（用户名称）  这个不需要验证
            String TokenName = plaintext[1];
            logger.info("token中解密出第二个是名字"+TokenName);

            //token根据 | 拆分出的第三个（用户登陆时间）
            String TokenTime = plaintext[2];
            logger.info("token中解密出第三个是登陆时间"+TokenTime);
            long time = des.decryptToLong(TokenTime);
            logger.info("把时间解密并转换成long类型"+time);

            //把当前时间（long）减去登陆时间（long）  如果>=30分钟   意味着时间已经超过了  返回登录页面
            if (System.currentTimeMillis() - time >= 30 * 60 * 1000) {
                System.out.println("token过期=====");
                //返回登录页面
                response.sendRedirect(request.getContextPath()+"/toLogin");
                return false;
            }

            logger.info("token（id,有效期）验证通过，登录成功");
            return  true;
            //验证某一项

        }else {
            //用户有cookies
            logger.info("有cookie");
            //遍历一下用户的cookies,放入cookie,看看他的cookie是什么
            for (Cookie cookie: cookies){
                //如果他的cookie与我发给他的cookie相等,就可以直接返到页面里
                if (cookie.getName().equals("token")){
                    String mytoken = cookie.getValue();
                    logger.info("从cookie取出的token 为:" + mytoken);

                    //用des对token进行解密
                    String plaintext1 = des.decrypt(mytoken);
                    logger.info("对token进行第一次解密的结果"+plaintext1);

                    //把token解密后的结果根据|进行拆分
                    String[] plaintext2  =  plaintext1.split("\\|");
                    logger.info("对token解密后的结果根据|进行拆分后的结果"+plaintext2);

                    //token根据 | 拆分出的第一个（用户id）
                    String TokenId = plaintext2[0];
                    logger.info("token中解密出第一个是id"+TokenId);
                    long id = des.decryptToLong(TokenId);
                    logger.info("把id解密并转换成long类型"+id);

                    //long类型转化为int类型
                    int BId = (int)id;

                    //根据id查询数据库中有无此用户
                    User user2 = userService.findById(BId);

                    //如果用户为空，返回登录界面
                    if (user2 == null){
                        logger.info("没有此token内所含Id的用户,必须去登录");
                        response.sendRedirect(request.getContextPath()+"/toLogin");
                        return  false;
                    }
                    //token根据 | 拆分出的第三个（用户登陆时间）
                    String TokenTime = plaintext2[2];
                    logger.info("token中解密出第三个是登陆时间"+TokenTime);
                    long time = des.decryptToLong(TokenTime);
                    logger.info("把时间解密并转换成long类型"+time);

                    //把当前时间（long）减去登陆时间（long）  如果>=30分钟   意味着时间已经超过了  返回登录页面
                    if (System.currentTimeMillis() - time >= 30 * 60 * 1000) {
                        System.out.println("token过期=====");
                        //返回登录页面
                        response.sendRedirect(request.getContextPath()+"/toLogin");
                        return false;
                    }
                    logger.info("token（id,有效期）验证通过，登录成功");
                    return  true;
                }
            }
        }
        //返回登录页面
        response.sendRedirect(request.getContextPath()+"/toLogin");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
