package com.zh.music.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author zou
 * @ClassName : com.zh.music.utils.DestFileUtils
 * @Description : 类描述
 * Created by user on 2021-07-09 19:41:46
 * Copyright  2020 user. All rights reserved.
 * 得到随机杂乱的文件名
 */

public class  DestFileUtils {
    public static File  getDestFile(String fileName,String path){

        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        return new File(path+Consts.FILESPLIT+fileName);
    }
    public static String  getFileName(String contentType){
        String suffix ="." +contentType.substring(contentType.lastIndexOf("/") + 1);
        return UuidUtil.getUuid()+suffix;
    }
}
