package com.zh.music.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.SongList
 * @Description : 类描述
 * Created by user on 2021-07-09 10:02:28
 * Copyright  2020 user. All rights reserved.
 * 歌单
 */
@Data
public class SongList implements Serializable {
    /*主键*/
    private Integer id;
    /*标题*/
    private String title;
    /*图片pic*/
    private String pic;
    /*介绍introduce*/
    private String introduce;
    /*风格*/
    private String style;
}
