package com.zh.music.mapper;

import com.zh.music.domain.Song;
import com.zh.music.domain.userup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.userupMapper
 * @Description : 类描述
 * Created by user on 2021-07-12 08:58:51
 * Copyright  2020 user. All rights reserved.
 * 用户点赞记录Mapper
 */
@Mapper
public interface userupMapper {
    /**
     * 方法描述
     * @param: [Song]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    int insert(userup userup);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据评论id和用户id删除
     */
    int deleteOne(userup userup);
    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据评论id和用户歌手
     */
    int selectSongByCommentIdUserName(userup userup);

}
