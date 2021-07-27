package com.zh.music.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.Song
 * @Description : 类描述
 * Created by user on 2021-07-08 16:23:00
 * Copyright  2020 user. All rights reserved.
 * 歌曲
 */
@Data
public class Song implements Serializable {
    /*主键id*/
    private Integer id;
    /*歌手id*/
    private Integer singerId;
    /*歌曲名字*/
    private String name;
    /*歌曲介绍*/
    private String introduce;
    /*歌曲创建时间*/
    private Date createTime;
    /*歌曲修改时间*/
    private Date updateTime;
    /*歌曲图片*/
    private String pic;
    /*歌词*/
    private String lyric;
    /*歌曲地址*/
    private String url;

}
