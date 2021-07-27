package com.zh.music.service.impl;

import com.zh.music.mapper.AdminMapper;
import com.zh.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.AdminServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-07 17:08:28
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;

/**
 * 方法描述
 * @param: [name, password]
 * @return: boolean
 * @author: zhang
 * @date: 2021/7/7
 * 验证登录
                */
        @Override
        public boolean verifyLogin(String name, String password) {
            return adminMapper.verifyLogin(name,password)>0;
    }
}
