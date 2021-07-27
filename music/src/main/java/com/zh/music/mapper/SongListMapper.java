package com.zh.music.mapper;

import com.zh.music.domain.SongList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.SongListListMapper
 * @Description : 类描述
 * Created by user on 2021-07-09 10:11:22
 * Copyright  2020 user. All rights reserved.
 * 歌单Mapper
 */
@Mapper
public interface SongListMapper {

    /**
     * 方法描述
     * @param: [SongList]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    int insert(SongList songList);
    /**
     * 方法描述
     * @param: [SongList]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    int update(SongList songList);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据id删除
     */
    int deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [id]
     * @return: SongList
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌单
     */
    SongList selectSongListById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌单
     */
    List<SongList> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定风格查找歌单
     */
    List<SongList> selectSongListByTitle(String title);
    /**
     * 方法描述
     * @param: [name]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊风格查询查找歌单
     */
    List<SongList> selectSongListByLikeStyle(String likeStyle);
    /**
     * 方法描述
     * @param: [id]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌单精确查询歌曲
     */
    List<SongList> selectSongListByLikeTitle(String likeTitle);


    String selectPicById(Integer id);
}
