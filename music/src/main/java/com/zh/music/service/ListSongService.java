package com.zh.music.service;

import com.zh.music.domain.ListSong;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.ListSongService
 * @Description : 类描述
 * Created by user on 2021-07-09 15:46:52
 * Copyright  2020 user. All rights reserved.
 */
public interface ListSongService {
    /**
     * 方法描述
     * @param: [listSong]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    boolean insert(ListSong listSong);
    /**
     * 方法描述
     * @param: [listSong]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    boolean update(ListSong listSong);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据id删除
     */
    boolean deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [songId,songListId]
     * @return: ListSong
     * @author: zh
     * @date: 2021/7/8
     * 根据歌曲id和歌单id删除歌
     */
    boolean deleteListSongBySongIdAndSongListId(Integer songId, Integer songListId);
    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌单歌曲
     */
    ListSong selectListSongById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<ListSong>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌单中的歌曲
     */
    List<ListSong> selectAll();
    /**
     * 方法描述
     * @param: [songListId]
     * @return: List<ListSong>
     * @author: zh
     * @date: 2021/7/9
     * 通过歌单id查找歌单的歌
     */
    List<ListSong> selectListSongBySongListId(Integer songListId);
}
