package com.zh.music.service.impl;

import com.zh.music.domain.Consumer;
import com.zh.music.mapper.ConsumerMapper;
import com.zh.music.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.ConsumerServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-09 19:15:21
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;
    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @Override
    public Boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0;
    }

    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public Boolean update(Consumer consumer) {
        return consumerMapper.update(consumer) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据id删除
     */
    @Override
    public Boolean deleteOne(Integer id) {
        return consumerMapper.deleteOne(id) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Consumer
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找用户
     */
    @Override
    public Consumer selectConsumerById(Integer id) {
        return consumerMapper.selectConsumerById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Consumer>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有用户
     */
    @Override
    public List<Consumer> selectAll() {
        return consumerMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Consumer>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定用户名查找用户
     */
    @Override
    public Consumer selectConsumerByName(String username) {
        return consumerMapper.selectConsumerByName(username);
    }

    /**
     * 方法描述
     * @param: [username, password]
     * @return: Integer
     * @author: zh
     * @date: 2021/7/9
     * 验证登录
     */
    @Override
    public Consumer verifyLogin(String username, String password) {
        return consumerMapper.verifyLogin(username, password);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: String
     * @author: zh
     * @date: 2021/7/9
     * 根据id查找用户头像
     */
    @Override
    public String selectAvatorByID(Integer id) {
        return consumerMapper.selectAvatorByID(id);
    }
}
