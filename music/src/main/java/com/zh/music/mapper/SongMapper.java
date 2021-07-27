package com.zh.music.mapper;

import com.zh.music.domain.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author zou
 * @ClassName : com.zh.music.mapper.SongListListMapper
 * @Description : 类描述
 * Created by user on 2021-07-09 10:11:22
 * Copyright  2020 user. All rights reserved.
 * 歌曲Mapper
 */
@Mapper
public interface SongMapper {
  /*  *//**
     * 方法描述
     * @param: [Song]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 上传歌手图片
     *//*
    boolean updateSingerPic(Song song) ;*/
    /**
     * 方法描述
     * @param: [Song]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    int insert(Song song);
    /**
     * 方法描述
     * @param: [Song]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    int update(Song song);
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
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌手
     */
    Song selectSongById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌手
     */
    List<Song> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定歌曲名查找歌曲
     */
    List<Song> selectSongByName(String name);
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊查询查找歌曲
     */
    List<Song> selectSongByLikeName(String likeName);
    /**
     * 方法描述
     * @param: [id]
     * @return: List<Song>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌手id查询歌曲
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
 * 根据id查找pic
*/
    String selectPicById(Integer id);
}
