package com.zh.music.domain;

import lombok.Data;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.userup
 * @Description : 类描述
 * Created by user on 2021-07-12 08:55:52
 * Copyright  2020 user. All rights reserved.
 * 用户点赞记录
 */
@Data
public class userup {
    /*主键*/
    private Integer id;
    /*给这条评论点赞的用户id*/
    private String username;
    /*评论id*/
    private Integer commentId;
}
