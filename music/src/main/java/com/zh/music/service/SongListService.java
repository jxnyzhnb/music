package com.zh.music.service;

import com.zh.music.domain.SongList;


import java.util.List;

/**
 * @author 86147
 */
public interface SongListService {
    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    boolean insert(SongList songList);
    /**
     * 方法描述
     * @param: []
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    boolean update(SongList songList);
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
     * @return: SongList
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌曲
     */
    SongList selectSongListById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 查询所有歌曲
     */
    List<SongList> selectAll();
    /**
     * 方法描述
     * @param: [String]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定标题查找列表
     */
    List<SongList> selectSongListByTitle(String title);
    /**
     * 方法描述
     * @param: [String]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊歌名查找列表
     */
    List<SongList> selectSongListByLikeStyle(String likeStyle);
    /**
     * 方法描述
     * @param: [String]
     * @return: List<SongList>
     * @author: zh
     * @date: 2021/7/8
     * 根据模糊标题查找歌单
     */
    List<SongList> selectSongListByLikeTitle(String likeTitle);
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
