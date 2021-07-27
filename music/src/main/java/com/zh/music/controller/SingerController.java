package com.zh.music.controller;

import com.zh.music.domain.Singer;
import com.zh.music.service.SingerService;
import com.zh.music.utils.Consts;
import com.zh.music.utils.ResponseResult;
import com.zh.music.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.SingerController
 * @Description : 类描述
 * Created by user on 2021-07-08 09:08:28
 * Copyright  2020 user. All rights reserved.
 * 歌手Controller
 */
@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;
    private static String path=Consts.PROJECTD+Consts.FILESPLIT+ "img"+ Consts.FILESPLIT+"singerPic";
    /**
     * 方法描述
     * @param: []
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/8
     * 增加
    */
    @PostMapping("/add")
    public ResponseResult<Object> insert(Singer singer){
        boolean flag = singerService.insert(singer);
        if (flag){
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.error(0,"添加失败！");
    }
    /**
     * 方法描述
     * @param: [singer]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/8
     * 修改
    */
    @PostMapping(value = "/update")
    public ResponseResult<Object> update(Singer singer) {
        boolean flag = singerService.update(singer);
        if (flag){
            return ResponseResult.success(1,"修改成功！");
        }
        return ResponseResult.error(0,"修改失败！");
    }
    /**
     * 方法描述
     * @param: [id]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/8
     * 删除一个歌手
    */
    @GetMapping("/delete")
    public ResponseResult<Object> deleteOne(Integer id){
        String oldPicPath = singerService.selectPicById(id);
        boolean flag = singerService.deleteOne(id);
        if (flag){
            /*由于默认图片是hhh.jpg,不能删除*/
            if (!oldPicPath.contains("hhh.jpg")){
                String oldPath = oldPicPath.substring(oldPicPath.lastIndexOf("/") + 1);
                /*删除旧的图片文件*/
                File file = new File(path +Consts.FILESPLIT+ oldPath);
                boolean deleteFlag = file.delete();
                if (deleteFlag){
                    return ResponseResult.success(1,"删除成功！");
                }else {
                    return ResponseResult.success(1,"删除成功！");
                }
              }
            }
            return ResponseResult.error(0,"删除失败！");
        }
        /**
         * 方法描述
         * @param: [id]
         * @return: ResponseResult<Singer>
         * @author: zh
         * @date: 2021/7/8
         * 根据id查找歌手
         */
        @GetMapping("/selectByPrimaryKey")
        public  ResponseResult<Singer> selectSingerById(Integer id){
            Singer singer = singerService.selectSingerById(id);
            if (singer != null){
                return ResponseResult.success(1,"查询成功！",singer);
            }
            return ResponseResult.error(0,"查询失败！");
        }
        /**
         * 方法描述
         * @param: []
         * @return: ResponseResult<List<Singer>>
         * @author: zh
         * @date: 2021/7/8
         * 查找所有
         */
        @GetMapping("/allSinger")
        public  ResponseResult<List<Singer>> selectAll(){
            List<Singer> singers;
            singers = singerService.selectAll();
            if (singers.size() > 0){
                return ResponseResult.success(1,"查询成功！",singers);
            }
            return ResponseResult.error(0,"查询失败！", singers);
        }
        /**
         * 方法描述
         * @param: [name]
         * @return: ResponseResult<List<Singer>>
         * @author: zh
         * @date: 2021/7/8
         * 根据id查找
         */
        @GetMapping("/singerOfName")
        public ResponseResult<List<Singer>> selectSingerByName(String name){
            List<Singer> singers = singerService.selectSingerByName("%"+name+"%");
            if (singers.size() > 0){
                return ResponseResult.success(1,"查询成功！",singers);
            }
            return ResponseResult.error(0,"查询失败！");
        }
        /**
         * 方法描述
         * @param: [sex]
         * @return: ResponseResult<List<Singer>>
         * @author: zh
         * @date: 2021/7/8
         * 根据歌名性别查询歌曲
         */
        @GetMapping("/singerOfSex")
        public ResponseResult<List<Singer>> selectSingerBySex(Integer sex){
            List<Singer> singers = singerService.selectSingerBySex(sex);
            if (singers.size() > 0){
                return ResponseResult.success(1,"查询成功！",singers);
            }
            return ResponseResult.error(0,"查询失败！");

        }
        /**
         * 方法描述
         * @param: [file, id]
         * @return: ResponseResult<Object>
         * @author: zh
         * @date: 2021/7/8
         * 完成歌手的图片上传
         */
        @PostMapping("/updateSingerPic")
        public ResponseResult<Object> updateSingerPic(@RequestParam("file") MultipartFile file,
                @RequestParam("id")Integer id){
            if (!file.isEmpty()){
                /*得到上传文件类型比如image/jpg*/
                String contentType = file.getContentType();
                if (contentType != null) {
                    /*lastIndexOf("/")得到最后一个/所在的索引,+1就是文件的后缀,就截取到了后缀*/
                    /*得到文件后缀如jpg*/
                    String suffix = "."+contentType.substring(contentType.lastIndexOf("/") + 1);
                    /*通过生成随机的乱码得到文件名*/
                    String fileName= UuidUtil.getUuid()+suffix;
                /*确定文件保存的路径*/
                File file1 = new File(path);
                if (!file1.exists()){
                    file1.mkdirs();
                }
                /*存放的文件的真实路径*/
                File dest = new File(file1 +Consts.FILESPLIT+ fileName);
                /*存放再数据库的文件路径*/
                String dataPath="/img/singerPic/"+fileName;
                try {
                    file.transferTo(dest);
                    Singer singer=new Singer();
                    singer.setId(id);
                    singer.setPic(dataPath);
                    /*查询得到原来的图片文件路径*/
                    String picPath = singerService.selectPicById(id);
                    String oldPic = picPath.substring(picPath.lastIndexOf("/") + 1);
                    /*删除原来的图片文件*/
                    boolean flag=singerService.updateSingerPic(singer);
                    if (flag){
                        if (!picPath.contains("hhh.jpg")){
                            File oldFile = new File(path +Consts.FILESPLIT+ oldPic);
                            boolean deleteFlag = oldFile.delete();
                            if (deleteFlag){
                                return ResponseResult.success(1,"上传成功！");
                            }
                        }else {
                            return ResponseResult.success(1,"上传成功！");
                        }

                    }
                    return ResponseResult.error(0,"上传失败！");
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseResult.error(0,"上传失败！");
                }

            }
        }
        return ResponseResult.error(0,"上传失败！");

    }
}
