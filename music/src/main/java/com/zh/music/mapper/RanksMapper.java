package com.zh.music.mapper;

import com.zh.music.domain.Ranks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.RanksMapper
 * @Description : 类描述
 * Created by user on 2021-07-10 15:56:04
 * Copyright  2020 user. All rights reserved.
 * 歌单评分Mapper
 */
@Mapper
public interface RanksMapper {
    /**
     * 方法描述
     * @param: [ranks]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 添加评分
    */
    int insert(Ranks ranks);
    /**
     * 方法描述
     * @param: [songListId]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 计算一个歌单的总分数
    */
    int selectScoreSum(Integer songListId);
    /**
     * 方法描述
     * @param: [songListId]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 计算该歌单的评价人数
    */
    int selectRanksSum(Integer songListId);

    /**
     * 方法描述
     * @param: [ranks]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/10
     * 查找用户是否在该歌单中评价过
     */

    Integer selectRanksByConsumerAndSongList(Ranks ranks);
    /**
     * 方法描述
     * @param: [userId, songListId]
     * @return: Integer
     * @author: zh
     * @date: 2021/7/12
     * 查找用户对歌单的评分
     */
    Integer getUserRanks(@Param("consumerId") Integer consumerId,
                         @Param("songListId") Integer songListId);
}
