package com.zh.music.mapper;

import com.zh.music.domain.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.ConsumerMapper
 * @Description : 类描述
 * Created by user on 2021-07-09 18:50:00
 * Copyright  2020 user. All rights reserved.
 * 前端用户Mapper
 */
@Mapper
public interface ConsumerMapper {
    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    int insert(Consumer consumer);
    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    int update(Consumer consumer);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据id删除
     */
    int deleteOne(Integer id);
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
    Consumer verifyLogin(@Param("username") String username,
                        @Param("password") String password);
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
