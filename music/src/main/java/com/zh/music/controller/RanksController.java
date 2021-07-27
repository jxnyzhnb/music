package com.zh.music.controller;

import com.zh.music.domain.Ranks;
import com.zh.music.service.RanksService;
import com.zh.music.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.RanksController
 * @Description : 类描述
 * Created by user on 2021-07-10 16:43:18
 * Copyright  2020 user. All rights reserved.
 */
@RestController
public class RanksController {
    @Autowired
    private RanksService ranksService;
    /**
     * 方法描述
     * @param: [ranks]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 添加评分
     */
    @PostMapping("/rank/add")
    public ResponseResult<Object> insert(Ranks ranks) {
        if (ranksService.selectRanksByConsumerAndSongList(ranks)){
            return ResponseResult.error(0,"评价失败,已评价过!");
        }
        boolean flag = ranksService.insert(ranks);
        if (flag) {
            return ResponseResult.success(1,"评价成功！");
        }
        return ResponseResult.error(0,"评价失败！");
    }

    /**
     * 方法描述
     * @param: [songListId]
     * @return: int
     * @author: zh
     * @date: 2021/7/10
     * 计算一个歌单的平均评分数
     */
    @GetMapping("/rank")
    public ResponseResult<Integer> averageRanks(Integer songListId) {
        Integer scoreSum = ranksService.averageRanks(songListId);
        return ResponseResult.success(1,"添加成功！",scoreSum);
    }
    /**
     * 方法描述
     * @param: [userId, songListId]
     * @return: ResponseResult<Integer>
     * @author: zh
     * @date: 2021/7/12
     * 获取用户对歌单的评分
    */
    @GetMapping("/rank/getUserRanks")
    public ResponseResult<Integer> getUserRanks(@RequestParam("userId")Integer consumerId,
                                                @RequestParam("songListId")Integer songListId){
        Integer userRanks=ranksService.getUserRanks(consumerId, songListId);
        if (userRanks!=null){
            return ResponseResult.success(1,"查询成功！",userRanks);
        }else {
            return ResponseResult.error(0,"查询失败！");
        }
    }

}
