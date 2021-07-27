package com.zh.music.service;

import com.zh.music.domain.userup;

/**
 * @author zou
 * @ClassName : com.zh.music.service.userupService
 * @Description : 类描述
 * Created by user on 2021-07-12 09:09:44
 * Copyright  2020 user. All rights reserved.
 */
public interface userupService {
    /**
     * 方法描述
     * @param: [Song]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    boolean insert(userup userup);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据评论id和用户id删除
     */
    boolean deleteOne(userup userup);
    /**
     * 方法描述
     * @param: [id]
     * @return: Song
     * @author: zh
     * @date: 2021/7/8
     * 根据评论id和用户id歌手
     */
    boolean selectSongByCommentIdUserName(userup userup);

}
