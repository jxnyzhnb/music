package com.zh.music.service;

import com.zh.music.domain.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.CollectService
 * @Description : 类描述
 * Created by user on 2021-07-12 14:33:43
 * Copyright  2020 user. All rights reserved.
 */
public interface CollectService {
    /**
     * 方法描述
     * @param: [Collect]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    boolean insert(Collect collect);
    /**
     * 方法描述
     * @param: [id]
     * @return: int
     * @author: zh
     * @date: 2021/7/12
     * 根据id删除
     */
    boolean deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [userId,songId]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据用户id和歌曲id删除
     */
    boolean deleteByUserIdSongId(Integer userId,Integer songId);
    /**
     * 方法描述
     * @param: [id]
     * @return: Collect
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌手
     */
    Collect selectCollectById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Collect>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有收藏
     */
    List<Collect> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Collect>
     * @author: zh
     * @date: 2021/7/8
     * 查找用户的收藏表
     */
    List<Collect> selectCollectByUserId(Integer userId);
    /**
     * 方法描述
     * @param: [collect]
     * @return: int
     * @author: zh
     * @date: 2021/7/12
     * 查看该歌曲是否被用户收藏
     */
    boolean selectByUserIdSingId(Collect collect);
}
