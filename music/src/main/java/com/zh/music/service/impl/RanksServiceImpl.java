package com.zh.music.service.impl;

import com.zh.music.domain.Ranks;
import com.zh.music.mapper.RanksMapper;
import com.zh.music.service.RanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.RanksServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-10 16:41:25
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class RanksServiceImpl implements RanksService {
    @Autowired
    private RanksMapper ranksMapper;
    /**
     * 方法描述
     * @param: [ranks]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 添加评分
     */
    @Override
    public boolean insert(Ranks ranks) {
        return ranksMapper.insert(ranks)>0;
    }

    /**
     * 方法描述
     * @param: [songListId]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 计算一个歌单的总分数
     */
    @Override
    public int averageRanks(Integer songListId) {
        int scoreSum = ranksMapper.selectScoreSum(songListId);
        int ranksSum = ranksMapper.selectRanksSum(songListId);
        return scoreSum/ranksSum;
    }

    /**
     * 方法描述

     * @param: [ranks]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/10
     * 查找用户是否在该歌单中评价过
     */
    @Override
    public boolean selectRanksByConsumerAndSongList(Ranks ranks) {
        return ranksMapper.selectRanksByConsumerAndSongList(ranks) > 0;
    }

    /**
     * 方法描述
     * @param: [userId, songListId]
     * @return: Integer
     * @author: zh
     * @date: 2021/7/12
     * 查找用户对歌单的评分
     */
    @Override
    public Integer getUserRanks(Integer consumerId, Integer songListId) {
        return ranksMapper.getUserRanks(consumerId,songListId);
    }


}
