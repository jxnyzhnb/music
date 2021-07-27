package com.zh.music.controller;

import com.zh.music.domain.Collect;
import com.zh.music.service.CollectService;
import com.zh.music.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.CollectController
 * @Description : 类描述
 * Created by user on 2021-07-12 14:37:53
 * Copyright  2020 user. All rights reserved.
 * 用户收藏Controller
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    /**
     * 方法描述
     * @param: [Collect]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @PostMapping("/add")
    public ResponseResult<Object> insert(Collect collect) {
        if (collectService.selectByUserIdSingId(collect)){
            boolean flag = collectService.deleteByUserIdSongId(collect.getUserId(), collect.getSongId());
            if (flag) {
                return ResponseResult.success(2,"取消收藏成功！");
            }
            return ResponseResult.success(0,"取消收藏失败！");
        }else {
            boolean flag = collectService.insert(collect);
            if (flag){
                return ResponseResult.success(1,"收藏成功！");
            }
            return ResponseResult.success(0,"收藏失败！");
        }

    }

   /* *//**
     * 方法描述
     * @param: [id]
     * @return: int
     * @author: zh
     * @date: 2021/7/12
     * 根据id删除
     *//*
    @GetMapping("/")
    public ResponseResult<Object> deleteOne(Integer id) {
        boolean flag = collectService.deleteOne(id);
        if (flag){
            return ResponseResult.success(1,"删除成功！");
        }
        return ResponseResult.success(0,"删除失败！");
    }*/

    /**
     * 方法描述
     * @param: [userId, songId]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据用户id和歌曲id删除
     */
    @GetMapping("/delete")
    public ResponseResult<Object> deleteByUserIdSongId(Integer userId, Integer songId) {
        boolean flag = collectService.deleteByUserIdSongId(userId,songId);
        if (flag){
            return ResponseResult.success(1,"删除成功！");
        }
        return ResponseResult.success(0,"删除失败！");
    }

   /* *//**
     * 方法描述
     * @param: [id]
     * @return: Collect
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌手
     *//*
    @GetMapping("/")
    public ResponseResult<Collect> selectCollectById(Integer id) {
        Collect collects = collectService.selectCollectById(id);
        if (collects!=null){
            return ResponseResult.success(1,"删除成功！",collects);
        }
        return ResponseResult.success(0,"删除失败！",collects);
    }*/

    /**
     * 方法描述
     * @param: []
     * @return: List<Collect>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有收藏
     */
    @GetMapping("/allCollect")
    public ResponseResult<List<Collect>> selectAll() {
        List<Collect> collects = collectService.selectAll();
        if (collects.size() > 0){
            return ResponseResult.success(1,"删除成功！",collects);
        }
        return ResponseResult.success(0,"删除失败！",collects);
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Collect>
     * @author: zh
     * @date: 2021/7/8
     * 查找用户的收藏表
     */
    @GetMapping("/collectOfUserId")
    public ResponseResult<List<Collect>> selectCollectByUserId(Integer userId) {
        List<Collect> collects = collectService.selectCollectByUserId(userId);
        if (collects.size() > 0){
            return ResponseResult.success(1,"删除成功！",collects);
        }
        return ResponseResult.success(0,"删除失败！",collects);
    }
}
