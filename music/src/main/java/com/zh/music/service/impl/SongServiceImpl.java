package com.zh.music.service.impl;

import com.zh.music.domain.Song;
import com.zh.music.mapper.SongMapper;
import com.zh.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.SongServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-08 16:35:59
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;
    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
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
    public boolean update(Song song) {
        return songMapper.update(song)>0;
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
        return songMapper.deleteOne(id)>0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌曲
     */
    @Override
    public Song selectSongById(Integer id) {
        return songMapper.selectSongById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 查询所有歌曲
     */
    @Override
    public List<Song> selectAll() {
        return songMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定歌名查找列表
     */
    @Override
    public List<Song> selectSongByName(String name) {
        return songMapper.selectSongByName(name);
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊歌名查找列表
     */
    @Override
    public List<Song> selectSongByLikeName(String likeName) {
        return songMapper.selectSongByLikeName(likeName);
    }

    /**
     * 方法描述
     * @param: [singerId]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌手的id查找歌曲
     */
    @Override
    public List<Song> selectSongBySingerId(Integer singerId) {
        return songMapper.selectSongBySingerId(singerId);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: String
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌曲文件url
     */
    @Override
    public String selectUrlById(Integer id) {
        return songMapper.selectUrlById(id);
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
        return songMapper.selectPicById(id);
    }
}
