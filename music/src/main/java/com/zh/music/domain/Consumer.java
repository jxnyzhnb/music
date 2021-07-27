package com.zh.music.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.Consumer
 * @Description : 类描述
 * Created by user on 2021-07-09 15:05:54
 * Copyright  2020 user. All rights reserved.
 * 前台用户
 */
@Data
public class Consumer {
    /*主键*/
    private Integer id;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*性别*/
    private Byte sex;
    /*电话号码*/
    private String phoneNum;
    /*邮件*/
    private String email;
    /*生日*/
    private String birth;
    /*介绍*/
    private String introduce;
    /*地区*/
    private String location;
    /*头像*/
    private String avator;
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private Date updateTime;

}
