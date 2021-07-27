package com.zh.music.domain;

import lombok.Data;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.Ranks
 * @Description : 类描述
 * Created by user on 2021-07-10 15:51:24
 * Copyright  2020 user. All rights reserved.
 * 歌曲的评分,评价
 */
@Data
public class Ranks {
    /*主键*/
    private Integer id;
    /*歌单id*/
    private Integer songListId;
    /*前端用户id*/
    private Integer consumerId;
    /*评分*/
    private Integer score;
}
