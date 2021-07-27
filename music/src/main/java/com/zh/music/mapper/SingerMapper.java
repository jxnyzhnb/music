package com.zh.music.mapper;

import com.zh.music.domain.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.SingerMapper
 * @Description : 类描述
 * Created by user on 2021-07-08 08:05:47
 * Copyright  2020 user. All rights reserved.
 * 歌手Mapper
 */
@Mapper
public interface SingerMapper {

    /**
     * 方法描述
     * @param: [singer]
     * @return: int
     * @author: zh
     * @date: 2021/7/8
     * 增加
    */
    int insert(Singer singer);
    /**
     * 方法描述
     * @param: [singer]
     * @return: int
     * @author: zh
     * @date: 2021/7/8
     * 修改
    */
    int update(Singer singer);
    /**
     * 方法描述
     * @param: [id]
     * @return: int
     * @author: zh
     * @date: 2021/7/8
     * 根据歌手id查询歌手的图片,返回图片路径
    */
    String selectPicById(Integer id);
    int deleteOne(Integer id);

    /**
     * 方法描述
     * @param: [id]
     * @return: Singer
     * @author: zh
     * @date: 2021/7/8
     * 根据id查询歌手
    */
    Singer selectSingerById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 查询所有
    */
    List<Singer> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 根据名字查找
    */
    List<Singer> selectSingerByName(String name);
    /**
     * 方法描述
     * @param: [sex]
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 根据性别
    */
    List<Singer> selectSingerBySex(Integer sex);
/**
 * 方法描述
 * @param: [singer]
 * @return: int
 * @author: zh
 * @date: 2021/7/8
 * 更新歌手的图片
*/
    int updateSingerPic(Singer singer);

}
