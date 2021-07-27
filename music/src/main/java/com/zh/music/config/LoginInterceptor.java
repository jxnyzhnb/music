package com.zh.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zou
 * @ClassName : com.zh.music.config.LoginInterceptor
 * @Description : 类描述
 * Created by user on 2021-07-07 22:13:19
 * Copyright  2020 user. All rights reserved.
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"http://localhost:8080");
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,"x-auth,content-type,mtoken");
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,"PUT,POST,DELETE,GET");
        response.addHeader("Access-Control-Allow-credentials","true");
        String loginName = (String) request.getSession().getAttribute("name");
        if (StringUtils.hasLength(loginName)){
            return  true;
        }
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
