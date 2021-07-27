package com.zh.music.service.impl;

import com.zh.music.domain.SongList;
import com.zh.music.mapper.SongListMapper;
import com.zh.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.SongListServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-09 10:46:19
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class SongListServiceImpl implements SongListService {
    @Autowired
    private SongListMapper songListMapper;

    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public boolean insert(SongList songList) {
        return songListMapper.insert(songList) > 0;
    }

    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public boolean update(SongList songList) {
        return songListMapper.update(songList) > 0;
    }

    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 删除
     */
    @Override
    public boolean deleteOne(Integer id) {
        return songListMapper.deleteOne(id) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: SongList
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌曲
     */
    @Override
    public SongList selectSongListById(Integer id) {
        return songListMapper.selectSongListById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 查询所有歌曲
     */
    @Override
    public List<SongList> selectAll() {
        return songListMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [style]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定风格查找列表
     */
    @Override
    public List<SongList> selectSongListByTitle(String title) {
        return songListMapper.selectSongListByTitle(title);
    }

    /**
     * 方法描述
     * @param: [likeStyle]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊歌名查找列表
     */
    @Override
    public List<SongList> selectSongListByLikeStyle(String likeStyle) {
        return songListMapper.selectSongListByLikeStyle(likeStyle);
    }

    /**
     * 方法描述
     * @param: [likeTitle]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌手的id查找歌曲
     */
    @Override
    public List<SongList> selectSongListByLikeTitle(String likeTitle) {
        return songListMapper.selectSongListByLikeTitle(likeTitle);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: String
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找pic,并返回
     */
    @Override
    public String selectPicById(Integer id) {
        return songListMapper.selectPicById(id);
    }
}
