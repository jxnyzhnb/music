package com.zh.music.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.Admin
 * @Description : 类描述
 * Created by user on 2021-07-07 16:39:11
 * Copyright  2020 user. All rights reserved.
 * 管理员类
 */
@Data
public class Admin implements Serializable {
    private Integer id;
    private String name;
    private String password;

}
