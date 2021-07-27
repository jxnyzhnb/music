package com.zh.music.service.impl;

import com.zh.music.domain.userup;
import com.zh.music.mapper.userupMapper;
import com.zh.music.service.userupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.userupServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-12 09:10:48
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class userupServiceImpl implements userupService {
    @Autowired
    private userupMapper userupMapper;
    /**
     * 方法描述
     * @param: [Song]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @Override
    public boolean insert(userup userup) {
        return userupMapper.insert(userup) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据评论id和用户id删除
     */
    @Override
    public boolean deleteOne(userup userup) {
        return userupMapper.deleteOne(userup) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据评论id和用户id歌手
     */
    @Override
    public boolean selectSongByCommentIdUserName(userup userup) {
        return userupMapper.selectSongByCommentIdUserName(userup) > 0;
    }
}
