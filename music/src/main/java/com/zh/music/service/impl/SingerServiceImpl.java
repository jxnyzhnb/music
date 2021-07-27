package com.zh.music.service.impl;

import com.zh.music.domain.Singer;
import com.zh.music.mapper.SingerMapper;
import com.zh.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.SingerServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-08 09:09:04
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;

    /**
     * 方法描述
     * @param: [singer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 上传歌手图片
     */
    @Override
    public boolean updateSingerPic(Singer singer) {
        return singerMapper.updateSingerPic(singer)>0;
    }

    /**
     * 方法描述
     * @param: [singer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer)>0;
    }

    /**
     * 方法描述
     * @param: [singer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer)>0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: String
     * @author: zh
     * @date: 2021/7/8
     * 查询歌手的pic路径
     */
    @Override
    public String selectPicById(Integer id) {
        return singerMapper.selectPicById(id);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据id删除
     */
    @Override
    public boolean deleteOne(Integer id) {
        return singerMapper.deleteOne(id)>0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Singer
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找歌手
     */
    @Override
    public Singer selectSingerById(Integer id) {
        return singerMapper.selectSingerById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌手
     */
    @Override
    public List<Singer> selectAll() {
        return singerMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 根据名字查找歌手
     */
    @Override
    public List<Singer> selectSingerByName(String name) {
        return singerMapper.selectSingerByName(name);
    }

    /**
     * 方法描述
     * @param: [sex]
     * @return: List<Singer>
     * @author: zh
     * @date: 2021/7/8
     * 根据性别
     */
    @Override
    public List<Singer> selectSingerBySex(Integer sex) {
        return singerMapper.selectSingerBySex(sex);
    }
}
