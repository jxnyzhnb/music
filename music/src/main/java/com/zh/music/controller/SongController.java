package com.zh.music.controller;

import com.zh.music.domain.Song;
import com.zh.music.service.SongService;
import com.zh.music.utils.Consts;
import com.zh.music.utils.ResponseResult;
import com.zh.music.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.SongController
 * @Description : 类描述
 * Created by user on 2021-07-08 16:34:27
 * Copyright  2020 user. All rights reserved.
 * 歌曲Controller
 */
@Slf4j
@RestController
@RequestMapping("/song")
public class SongController {
    private static String pathUrl= Consts.PROJECTD+Consts.FILESPLIT+"song";
    private static String pathPic= Consts.PROJECTD+Consts.FILESPLIT+"img"+Consts.FILESPLIT+"songPic";
    @Autowired
    private SongService songService;
    /**
     * 方法描述
     * @param: [file, song]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/8
     * 添加歌曲
    */
    @PostMapping("/add")
    public ResponseResult<Object> insert(@RequestParam("file")MultipartFile file,
                                         Song song){
        if (!file.isEmpty()){
                String fileName=System.currentTimeMillis()+file.getOriginalFilename();
                File file1 = new File(pathUrl);
                if (!file1.exists()){
                    file1.mkdirs();
                }
                File dest=new File(pathUrl+Consts.FILESPLIT+fileName);
                String dataPath="/song/"+fileName;
                try {
                    file.transferTo(dest);
                    String pic="/img/songPic/tubiao.jpg";
                    song.setUrl(dataPath);
                    song.setPic(pic);
                    song.setCreateTime(new Date());
                    song.setUpdateTime(new Date());
                    boolean flag = songService.insert(song);
                    if (flag){
                        return ResponseResult.success(1,"添加成功！");
                    }
                    return ResponseResult.error(0,"添加失败！");
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseResult.error(0,"添加失败！");
                }

            }
        return ResponseResult.error(0,"添加失败！");

    }
    /**
     * 方法描述
     * @param: [song]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/8
     * 修改歌曲(不包括歌曲的图片和MP3)
    */
    @PostMapping("/update")
    public ResponseResult<Object> update(Song song){
        song.setUpdateTime(new Date());
        boolean flag = songService.update(song);
        if (flag) {
            return ResponseResult.success(1,"修改成功！");
        }
        return ResponseResult.error(0,"修改失败！");
    }

    /**
     * 方法描述
     * @param: [singerId]
     * @return: ResponseResult<List<Song>>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌手的id查询歌曲列表
    */
    @GetMapping("/singer/detail")
    public ResponseResult<List<Song>> selectSongBySingerId(Integer singerId){
        List<Song> songs = songService.selectSongBySingerId(singerId);
        if (songs.size() > 0){
            return  ResponseResult.success(1,"查询成功！",songs);
        }
        return ResponseResult.error(0,"查询失败！",songs);
    }
/**
 * 方法描述
 * @param: [id]
 * @return: ResponseResult<Object>
 * @author: zh
 * @date: 2021/7/8
 * 删除歌
*/
    @GetMapping("/delete")
    public ResponseResult<Object> deleteOne(Integer id){
        String oldUrlPath=songService.selectUrlById(id);
        String oldPicPath = songService.selectPicById(id);
        boolean flag = songService.deleteOne(id);
        if (flag){
            String oldUrl = oldUrlPath.substring(oldUrlPath.lastIndexOf("/") + 1);
            String oldPic = oldPicPath.substring(oldPicPath.lastIndexOf("/") + 1);
            File fileUrl = new File(pathUrl + Consts.FILESPLIT + oldUrl);
            File filePic = new File(pathPic + Consts.FILESPLIT + oldUrl);
            boolean deleteFlag = fileUrl.delete();
            boolean deleteFlag1 = filePic.delete();
            if (deleteFlag&&deleteFlag1){
                return ResponseResult.success(1,"删除成功！");
            }
        }
        return ResponseResult.error(0,"删除失败！");
    }
    @PostMapping("/updateSongPic")
    public ResponseResult<Object> updateSongPic(@RequestParam("file")MultipartFile file,
                                                @RequestParam("id") Integer id ){
        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            if (contentType!=null){
                String suffix = "."+contentType.substring(contentType.lastIndexOf("/") + 1);
                String fileName=UuidUtil.getUuid()+ suffix;
                File file1 = new File(pathPic);
                if (!file1.exists()){
                    file1.exists();
                }
                File dest=new File(file1+Consts.FILESPLIT+fileName);
                log.info("真实地址{}",dest);
                log.info("file1地址{}",file1);
                String dataPath="/img/songPic/"+fileName;
                try {
                    file.transferTo(dest);
                    Song song=new Song();
                    song.setId(id);
                    song.setPic(dataPath);
                    song.setUpdateTime(new Date());
                    String picPath = songService.selectPicById(id);
                    boolean flag = songService.update(song);
                    String oldPic = picPath.substring(picPath.lastIndexOf("/") + 1);
                    if (flag){
                        if (!picPath.contains("tubiao.jpg")){
                            File oldFile=new File(pathPic+Consts.FILESPLIT+oldPic);
                            log.info("旧的图片地址{}",oldFile);
                            boolean deleteFlag = oldFile.delete();
                            log.info("旧的图片删除flag{}",deleteFlag);
                                if (deleteFlag){
                                    return  ResponseResult.success(1,"上传成功！");
                            }

                        } else {
                            return  ResponseResult.success(1,"上传成功！");
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ResponseResult.error(0,"修改失败！");
    }
    @PostMapping("/updateSongUrl")
    public ResponseResult<Object> updateSongUrl(@RequestParam("file")MultipartFile file,
                                                @RequestParam("id")Integer id ){
        if (!file.isEmpty()){
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            String filePath=pathUrl;
            File file1 = new File(pathUrl);
            if (!file1.exists()){
                file1.mkdirs();
            }
            File dest = new File(filePath + Consts.FILESPLIT + fileName);
            String dataPath="/song/"+fileName;
            try {
                file.transferTo(dest);
                Song song = new Song();
                song.setId(id);
                song.setUrl(dataPath);
                song.setUpdateTime(new Date());
                boolean flag = songService.update(song);
                if (flag){
                    return ResponseResult.success(1,"修改成功！");
                }
                return ResponseResult.error(0,"修改失败！");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseResult.error(0,"修改失败！");
            }

        }
        return  ResponseResult.error(0,"修改成功！");
    }
    /**
     * 方法描述
     * @param: []
     * @return: ResponseResult<Song>
     * @author: zh
     * @date: 2021/7/8
     * 查找歌曲通过id
    */
    @GetMapping("/detail")
    public ResponseResult<Song> selectSongById(@RequestParam("songId") Integer id){
        log.info("id{}",id);
        Song song = songService.selectSongById(id);
        if (song!=null){
            return ResponseResult.success(1,"查询成功！",song);
        }
        return ResponseResult.error(0,"查询失败！");
    }
    /**
     * 方法描述
     * @param: [name]
     * @return: ResponseResult<List<Song>>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌曲名称搜索歌曲
    */
    @GetMapping("/songOfSongName")
    public ResponseResult<List<Song>> selectSongByName(@RequestParam("songName") String name){
        List<Song> songs = songService.selectSongByName(name);
        if (songs.size()>0){
            return ResponseResult.success(1,"查询成功！",songs);
        }
        return ResponseResult.error(0,"查询失败！",songs);
    }
    /**
     * 方法描述
     * @param: [likeName]
     * @return: ResponseResult<List<Song>>
     * @author: zh
     * @date: 2021/7/9
     * 根据歌名模糊查找
    */
    @GetMapping("/likeSongOfName")
    public ResponseResult<List<Song>> selectSongByLikeName(@RequestParam("songName") String likeName){
        List<Song> songs = songService.selectSongByLikeName("%" + likeName + "%");
        if (songs.size()>0){
            return ResponseResult.success(1,"查询成功！",songs);
        }
        return ResponseResult.error(0,"查询失败！",songs);

    }
    /**
     * 方法描述
     * @param: []
     * @return: ResponseResult<List<Song>>
     * @author: zh
     * @date: 2021/7/9
     * 查询所有歌曲
    */
    @GetMapping("/allSong")
    public ResponseResult<List<Song>> selectAll(){
        List<Song> songs = songService.selectAll();
        if (songs.size()>0){
            return ResponseResult.success(1,"查询成功！",songs);
        }
        return ResponseResult.error(0,"查询失败！",songs);

    }
}
