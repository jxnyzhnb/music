package com.zh.music.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zou
 * @ClassName : com.zh.music.domain.Singer
 * @Description : 类描述
 * Created by user on 2021-07-08 07:54:26
 * Copyright  2020 user. All rights reserved.
 * 歌手
 */
@Data
public class Singer implements Serializable {
    /*主键id*/
    private Integer id;
    /*姓名*/
    private String  name;
    /*性别*/
    private Byte sex;
    /*图片*/
    private String pic;
    /*生日*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date  birth;
    /*地区*/
    private String location;
    /*介绍*/
    private String introduce;

}
