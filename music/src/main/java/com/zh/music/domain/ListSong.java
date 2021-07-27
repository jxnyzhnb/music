package com.zh.music.domain;

import lombok.Data;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.ListSong
 * @Description : 类描述
 * Created by user on 2021-07-09 15:09:07
 * Copyright  2020 user. All rights reserved.
 * 歌单中的歌曲
 */
@Data
public class ListSong {
    /*主键*/
    private Integer id;
    /*歌曲id*/
    private Integer songId;
    /*歌单id*/
    private Integer songListId;
}
