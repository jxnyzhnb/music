package com.zh.music.controller;


import com.zh.music.domain.Admin;
import com.zh.music.service.impl.AdminServiceImpl;
import com.zh.music.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.AdminController
 * @Description : 类描述
 * Created by user on 2021-07-07 17:14:00
 * Copyright  2020 user. All rights reserved.
 * 用户Controller
 */
@RestController
public class AdminController {
    @Autowired
    public AdminServiceImpl adminService;
    @PostMapping("/admin/login/status")
    public ResponseResult<Object> verifyLogin(String name, String password, HttpServletRequest request){
        boolean flag = adminService.verifyLogin(name, password);
        if (flag){
            request.getSession().setAttribute("name",name);
            return ResponseResult.success(1, "登录成功");
        }else {
            return ResponseResult.error(0,"用户名或密码错误") ;
        }
    }
}
