package com.zh.music.controller;

import com.zh.music.domain.ListSong;
import com.zh.music.domain.Song;
import com.zh.music.service.ListSongService;
import com.zh.music.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.ListSongController
 * @Description : 类描述
 * Created by user on 2021-07-09 15:52:37
 * Copyright  2020 user. All rights reserved.
 * 歌单歌曲Controller
 */
@RestController
@RequestMapping("/listSong")
@Slf4j
public class ListSongController {
    @Autowired
    private ListSongService listSongService;
    /**
     * 方法描述
     * @param: [listSong]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 添加
     */
    @PostMapping("/add")
    public ResponseResult<Object> insert(ListSong listSong){
        boolean flag = listSongService.insert(listSong);
        if (flag){
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.success(0,"添加失败！");
    }
    /**
     * 方法描述
     * @param: [listSong]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 修改
     */
    @PostMapping("/update")
    public ResponseResult<Object> update(ListSong listSong) {
        boolean flag = listSongService.update(listSong);
        if (flag){
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.success(0,"添加失败！");
    }
    /**
     * 方法描述
     * @param: [id]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 删除
     */
    @GetMapping("/deleteOne")
    public ResponseResult<Object> deleteOne(Integer id){
        boolean flag = listSongService.deleteOne(id);
        if (flag){
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.success(0,"添加失败！");
    }
    /**
     * 方法描述
     * @param: [id]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 根据id查找
     */
    @GetMapping("/selectByPrimaryKey")
    public ResponseResult<ListSong> selectListSongById(Integer id){
        ListSong listSong = listSongService.selectListSongById(id);
        if (listSong!=null){
            return ResponseResult.success(1,"添加成功！",listSong);
        }
        return ResponseResult.success(0,"添加失败！",listSong);
    }
    /**
     * 方法描述
     * @param: []
     * @return: ResponseResult<List<ListSong>>
     * @author: zh
     * @date: 2021/7/9
     * 查询所有歌单
     */
    @GetMapping("/allListSong")
    public ResponseResult<List<ListSong>> selectAll(){
        List<ListSong> listSongs = listSongService.selectAll();
        if (listSongs.size() > 0){
            return ResponseResult.success(1,"查询成功！",listSongs);
        }
        return ResponseResult.success(0,"查询失败！",listSongs);
    }
    /**
     * 方法描述
     * @param: [songListId]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 根据歌单id查询歌单的歌
    */
   @GetMapping("/detail")
    public ResponseResult<List<ListSong>> selectListSongBySongListId(Integer songListId){
       log.info("songListId{}",songListId);
       List<ListSong> listSongs = listSongService.selectListSongBySongListId(songListId);
       log.info("listSongs{}",listSongs);
       if (listSongs.size() > 0) {
           return  ResponseResult.success(1,"查询成功！",listSongs);
       }
       return ResponseResult.error(0,"查询失败！",listSongs);
   }
   /**
    * 方法描述
    * @param: [songId, songListId]
    * @return: ResponseResult<Object>
    * @author: zh
    * @date: 2021/7/9
    * 根据歌曲id和歌单id删除歌曲
   */
   @GetMapping("/delete")
    public ResponseResult<Object> deleteListSongBySongIdAndSongListId(@RequestParam("songId") Integer songId,
                                                                      @RequestParam("songListId") Integer songListId) {
       boolean flag = listSongService.deleteListSongBySongIdAndSongListId(songId, songListId);
       if (flag){
           return ResponseResult.success(1,"删除成功！");
       }
       return ResponseResult.error(0,"删除失败！");
   }
}
