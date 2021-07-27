package com.zh.music.service.impl;

import com.sun.webkit.ColorChooser;
import com.zh.music.domain.Collect;
import com.zh.music.mapper.CollectMapper;
import com.zh.music.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.CollectServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-12 14:34:08
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    /**
     * 方法描述
     * @param: [Collect]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @Override
    public boolean insert(Collect collect) {
        return collectMapper.insert(collect) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: int
     * @author: zh
     * @date: 2021/7/12
     * 根据id删除
     */
    @Override
    public boolean deleteOne(Integer id) {
        return collectMapper.deleteOne(id)>0;
    }

    /**
     * 方法描述
     * @param: [userId, songId]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据用户id和歌曲id删除
     */
    @Override
    public boolean deleteByUserIdSongId(Integer userId, Integer songId) {
        return collectMapper.deleteByUserIdSongId(userId, songId) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Collect
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌手
     */
    @Override
    public Collect selectCollectById(Integer id) {
        return collectMapper.selectCollectById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Collect>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有收藏
     */
    @Override
    public List<Collect> selectAll() {
        return collectMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Collect>
     * @author: zh
     * @date: 2021/7/8
     * 查找用户的收藏表
     */
    @Override
    public List<Collect> selectCollectByUserId(Integer userId) {
        return collectMapper.selectCollectByUserId(userId);
    }

    /**
     * 方法描述
     *
     * @param collect
     * @param: [collect]
     * @return: int
     * @author: zh
     * @date: 2021/7/12
     * 查看该歌曲是否被用户收藏
     */
    @Override
    public boolean selectByUserIdSingId(Collect collect) {
        return collectMapper.selectByUserIdSingId(collect) > 0;
    }
}
