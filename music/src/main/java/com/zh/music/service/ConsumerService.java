package com.zh.music.service;

import com.zh.music.domain.Consumer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.ConsumerService
 * @Description : 类描述
 * Created by user on 2021-07-09 19:13:31
 * Copyright  2020 user. All rights reserved.
 */
public interface ConsumerService {
    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    Boolean insert(Consumer consumer);
    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    Boolean update(Consumer consumer);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据id删除
     */
    Boolean deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [id]
     * @return: Consumer
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找用户
     */
    Consumer selectConsumerById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Consumer>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有用户
     */
    List<Consumer> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Consumer>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定用户名查找用户
     */
    Consumer selectConsumerByName(String username);
    /**
     * 方法描述
     * @param: [username, password]
     * @return: Integer
     * @author: zh
     * @date: 2021/7/9
     * 验证登录
     */
    Consumer verifyLogin( String username, String password);
    /**
     * 方法描述
     * @param: [id]
     * @return: String
     * @author: zh
     * @date: 2021/7/9
     * 根据id查找用户头像
     */
    String selectAvatorByID(Integer id);
}
