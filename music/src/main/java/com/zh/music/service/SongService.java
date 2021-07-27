package com.zh.music.service;

import com.zh.music.domain.Song;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.SongService
 * @Description : 类描述
 * Created by user on 2021-07-08 16:35:39
 * Copyright  2020 user. All rights reserved.
 */
public interface SongService {
    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
    */
    boolean insert(Song song);
    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
    */
    boolean update(Song song);
    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 删除
    */
    boolean deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌曲
    */
    Song selectSongById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 查询所有歌曲
    */
    List<Song> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定歌名查找列表
    */
    List<Song> selectSongByName(String name);
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊歌名查找列表
    */
    List<Song> selectSongByLikeName(String name);
    /**
     * 方法描述
     * @param: [singerId]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌手的id查找歌曲
    */
    List<Song> selectSongBySingerId(Integer singerId);
/**
 * 方法描述
 * @param: [id]
 * @return: String
 * @author: zh
 * @date: 2021/7/8
 * 根据id查找歌曲文件url
*/
    String selectUrlById(Integer id);
/**
 * 方法描述
 * @param: [id]
 * @return: String
 * @author: zh
 * @date: 2021/7/8
 * 根据id查找pic,并返回
*/
    String  selectPicById(Integer id);
}
