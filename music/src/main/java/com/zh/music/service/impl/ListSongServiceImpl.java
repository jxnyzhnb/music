package com.zh.music.service.impl;

import com.zh.music.domain.ListSong;
import com.zh.music.mapper.ListSongMapper;
import com.zh.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.ListSongServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-09 15:49:05
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMapper listSongMapper;
    /**
     * 方法描述
     * @param: [listSong]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @Override
    public boolean insert(ListSong listSong) {
        return listSongMapper.insert(listSong) > 0;
    }

    /**
     * 方法描述
     * @param: [listSong]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public boolean update(ListSong listSong) {
        return listSongMapper.update(listSong) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据id删除
     */
    @Override
    public boolean deleteOne(Integer id) {
        return listSongMapper.deleteOne(id) > 0;
    }

    /**
     * 方法描述
     * @param: [songId, songListId]
     * @return: ListSong
     * @author: zh
     * @date: 2021/7/8
     * 根据歌曲id和歌单id删除歌
     */
    @Override
    public boolean deleteListSongBySongIdAndSongListId(Integer songId, Integer songListId) {
        return listSongMapper.deleteListSongBySongIdAndSongListId(songId, songListId);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌单歌曲
     */
    @Override
    public ListSong selectListSongById(Integer id) {
        return listSongMapper.selectListSongById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<ListSong>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌单中的歌曲
     */
    @Override
    public List<ListSong> selectAll() {
        return listSongMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [songListId]
     * @return: List<ListSong>
     * @author: zh
     * @date: 2021/7/9
     * 通过歌单id查找歌单的歌
     */
    @Override
    public List<ListSong> selectListSongBySongListId(Integer songListId) {
        return listSongMapper.selectListSongBySongListId(songListId);
    }
}
