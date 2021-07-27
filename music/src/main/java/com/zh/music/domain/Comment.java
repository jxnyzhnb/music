package com.zh.music.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.Comment
 * @Description : 类描述
 * Created by user on 2021-07-10 14:13:56
 * Copyright  2020 user. All rights reserved.
 * 歌单和歌曲的评论
 */
@Data
public class Comment {
    /*主键*/
    private  Integer id;
    /*用户id*/
    private  Integer userId;
    /*评论类型歌单1,歌曲0*/
    private Byte type;
    /*歌曲id*/
    private Integer songId;
    /*歌单id*/
    private Integer songListId;
    /*评论内容*/
    private String content;
    /*创建时间*/
    private Date createTime;
    /*评论点赞数*/
    private Integer up;

}
