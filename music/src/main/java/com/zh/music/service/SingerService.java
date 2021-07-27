package com.zh.music.service;

import com.zh.music.domain.Singer;

import java.util.List;

public interface SingerService {
    /**
     * 方法描述
     * @param: [singer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 上传歌手图片
    */
     boolean updateSingerPic(Singer singer) ;
    /**
     * 方法描述
     * @param: [singer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
    */
    boolean insert(Singer singer);
    /**
     * 方法描述
     * @param: [singer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
    */
    boolean update(Singer singer);
    /**
     * 方法描述
     * @param: [id]
     * @return: String
     * @author: zh
     * @date: 2021/7/8
     * 查询歌手的pic路径
    */
    String selectPicById(Integer id);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据id删除
    */

    boolean deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [id]
     * @return: Singer
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌手
    */
    Singer selectSingerById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌手
    */
    List<Singer> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 根据名字查找歌手
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

}
