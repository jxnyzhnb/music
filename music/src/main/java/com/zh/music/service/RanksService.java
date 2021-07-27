package com.zh.music.service;

import com.zh.music.domain.Ranks;

/**
 * @author zou
 * @ClassName : com.zh.music.service.RanksService
 * @Description : 类描述
 * Created by user on 2021-07-10 16:40:31
 * Copyright  2020 user. All rights reserved.
 * 评分Service
 */
public interface RanksService {
    /**
     * 方法描述
     * @param: [ranks]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 添加评分
     */
    boolean insert(Ranks ranks);
    /**
     * 方法描述
     * @param: [songListId]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 计算一个歌单的总分数
     */
    int averageRanks(Integer songListId);
/**
 * 方法描述
 * @param: [ranks]
 * @return: boolean
 * @author: zh
 * @date: 2021/7/10
 * 查找用户是否在该歌单中评价过
*/
    boolean selectRanksByConsumerAndSongList(Ranks ranks);

/**
 * 方法描述
 * @param: [userId, songListId]
 * @return: Integer
 * @author: zh
 * @date: 2021/7/12
 * 查找用户对歌单的评分
*/
    Integer getUserRanks(Integer consumerId, Integer songListId);
}
