package com.zh.music.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.AdminMapper
 * @Description : 类描述
 * Created by user on 2021-07-07 16:42:51
 * Copyright  2020 user. All rights reserved.
 * 管理员Mapper
 */

@Mapper
public interface AdminMapper {
    /**
     * 方法描述
     * @param: [username, password]
     * @return: int
     * @author: zhang
     * @date: 2021/7/7
    */
    int verifyLogin(String name, String password);
}
