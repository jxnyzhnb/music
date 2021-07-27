package com.zh.music.mapper;

import com.zh.music.domain.ListSong;
import com.zh.music.domain.Song;
import com.zh.music.domain.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.ListSongMapper
 * @Description : 类描述
 * Created by user on 2021-07-09 15:11:57
 * Copyright  2020 user. All rights reserved.
 * 歌单歌曲Mapper
 */
@Mapper
public interface ListSongMapper {

    /**
     * 方法描述
     * @param: [listSong]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    int insert(ListSong listSong);
    /**
     * 方法描述
     * @param: [listSong]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    int update(ListSong listSong);
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
     * @param: [songId,songListId]
     * @return: ListSong
     * @author: zh
     * @date: 2021/7/8
     * 根据歌曲id和歌单id删除歌
     */
    boolean deleteListSongBySongIdAndSongListId(@Param("songId") Integer songId,
                                                 @Param("songListId") Integer songListId);
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
