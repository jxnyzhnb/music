package com.zh.music.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.content
 * @Description : 类描述
 * Created by user on 2021-07-12 14:10:18
 * Copyright  2020 user. All rights reserved.
 * 用户收藏
 */
@Data
public class Collect {
   /*主键*/
    private Integer id;
    /*用户id*/
    private Integer userId;
    /*收藏歌单为1,歌曲为0*/
    private Byte type;
    /*收藏歌曲id*/
    private Integer songId;
    /*收藏歌单id*/
    private Integer songListId;
    /*创建时间*/
    private Date createTime;
}
