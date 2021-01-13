package com.bootmvc.config;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化
 */
public class MyLocaleResolver implements LocaleResolver{

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

       String language =request.getParameter("language");

        Locale locale = Locale.getDefault();//如果没有就是用默认的
        if(!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split = language.split("_");

            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
