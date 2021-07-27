package com.zh.music.controller;

import com.zh.music.domain.SongList;
import com.zh.music.service.SongListService;
import com.zh.music.utils.Consts;
import com.zh.music.utils.ResponseResult;
import com.zh.music.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.SongListController
 * @Description : 类描述
 * Created by user on 2021-07-09 10:47:37
 * Copyright  2020 user. All rights reserved.
 * 歌单Controller
 */
@Slf4j
@RestController
@RequestMapping("/songList")
public class SongListController {
    private static String path= Consts.PROJECTD+Consts.FILESPLIT+"img"+Consts.FILESPLIT+"songListPic";
    @Autowired
    private SongListService songListService;
    /**
     * 方法描述
     * @param: [songList]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 添加
    */
    @PostMapping("/add")
    public ResponseResult<Object> insert(SongList songList){
        boolean flag = songListService.insert(songList);
        if (flag){
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.success(0,"添加失败！");
    }
    /**
     * 方法描述
     * @param: [songList]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/9
     * 修改
    */
    @PostMapping("/update")
    public ResponseResult<Object> update(SongList songList) {
        boolean flag = songListService.update(songList);
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
    @GetMapping("/delete")
    public ResponseResult<Object> deleteOne(Integer id){
        boolean flag = songListService.deleteOne(id);
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
    public ResponseResult<SongList> selectSongListById(Integer id){
        SongList songList = songListService.selectSongListById(id);
        if (songList!=null){
            return ResponseResult.success(1,"添加成功！",songList);
        }
        return ResponseResult.success(0,"添加失败！",songList);
    }
    /**
     * 方法描述
     * @param: []
     * @return: ResponseResult<List<SongList>>
     * @author: zh
     * @date: 2021/7/9
     * 查询所有歌单
    */
    @GetMapping("/allSongList")
    public ResponseResult<List<SongList>> selectAll(){
        List<SongList> songLists = songListService.selectAll();
        if (songLists.size() > 0){
            return ResponseResult.success(1,"查询成功！",songLists);
        }
        return ResponseResult.success(0,"查询失败！",songLists);
    }
    /**
     * 方法描述
     * @param: [title]
     * @return: ResponseResult<List<SongList>>
     * @author: zh
     * @date: 2021/7/9
     * 指定标题查询歌单
    */
    @GetMapping("/songListOfTitle")
    public ResponseResult<List<SongList>> selectSongListByTitle(String title) {
        List<SongList> songLists = songListService.selectSongListByTitle(title);
        if (songLists.size() > 0){
            return ResponseResult.success(1,"查询成功！",songLists);
        }
        return ResponseResult.success(0,"查询失败！",songLists);
    }
    /**
     * 方法描述
     * @param: [likeTitle]
     * @return: ResponseResult<List<SongList>>
     * @author: zh
     * @date: 2021/7/9
     * 模糊标题查询歌单
    */
    @GetMapping("/likeTitle")
    public ResponseResult<List<SongList>> selectSongListByLikeTitle(String likeTitle){
        List<SongList> songLists = songListService.selectSongListByLikeTitle("%"+likeTitle+"%");
        if (songLists.size() > 0){
            return ResponseResult.success(1,"查询成功！",songLists);
        }
        return ResponseResult.success(0,"查询失败！",songLists);
    }
    /**
     * 方法描述
     * @param: [likeStyle]
     * @return: ResponseResult<List<SongList>>
     * @author: zh
     * @date: 2021/7/9
     * 根据模糊风格查询歌单
    */
    @GetMapping("/likeStyle")
    public ResponseResult<List<SongList>> selectSongListByLikeStyle(@RequestParam("style") String likeStyle){
        List<SongList> songLists = songListService.selectSongListByLikeStyle("%"+likeStyle+"%");
        if (songLists.size() > 0){
            return ResponseResult.success(1,"查询成功！",songLists);
        }
        return ResponseResult.success(0,"查询失败！",songLists);
    }
    @PostMapping("/updateSongListPic")
    public ResponseResult<Object> updateSongListPic(@RequestParam("file")MultipartFile file,
                                                    @RequestParam("id")Integer id){
       if (!file.isEmpty()){
           String contentType = file.getContentType();
           if (contentType!=null){
               String suffix = "."+contentType.substring(contentType.lastIndexOf("/") + 1);
               String fileName= UuidUtil.getUuid()+suffix;
               File file1= new File(path);
               if (!file1.exists()){
                   file1.mkdirs();
               }
               File dest = new File(path+ Consts.FILESPLIT+fileName);
               String dataPath="/img/songListPic/"+fileName;
               String oldPicPath = songListService.selectPicById(id);
               try {

                   String oldFileName = oldPicPath.substring(oldPicPath.lastIndexOf("/") + 1);
                   String oldPath=path+Consts.FILESPLIT+oldFileName;
                   log.info("oldPath{}",oldPath);
                   file.transferTo(dest);
                   SongList songList = new SongList();
                   songList.setPic(dataPath);
                   songList.setId(id);
                   boolean flag = songListService.update(songList);
                   log.info("flag{}",flag);
                   if (flag){
                       if (!oldPicPath.contains("123.jpg")){
                           File oldFile = new File(oldPath);
                           boolean deleteFlag = oldFile.delete();
                           log.info("deleteFlag{}",deleteFlag);

                           if (deleteFlag){
                               return ResponseResult.error(1,"上传成功！");
                           }
                       }else {
                           return ResponseResult.error(1,"上传成功！");
                       }

                   }

               } catch (IOException e) {
                   e.printStackTrace();
                   return ResponseResult.error(0,"上传失败！");
               }

           }

       }
       return ResponseResult.error(0,"上传失败！");

    }
}
