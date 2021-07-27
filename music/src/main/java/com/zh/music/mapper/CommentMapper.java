package com.zh.music.mapper;

import com.zh.music.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.mapper.CommentMapper
 * @Description : 类描述
 * Created by user on 2021-07-10 14:20:30
 * Copyright  2020 user. All rights reserved.
 * 评论Mapper
 */
@Mapper
public interface CommentMapper {
    /**
     * 方法描述
     * @param: [comment]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    int insert(Comment comment);
    /**
     * 方法描述
     * @param: [comment]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    int update(Comment comment);
    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     *根据id删除
     */
    int deleteOne(Integer id);
    /**
     * 方法描述
     * @param: [id]
     * @return: Comment
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找评论
     */
    Comment selectCommentById(Integer id);
    /**
     * 方法描述
     * @param: []
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌手
     */
    List<Comment> selectAll();
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定歌曲id查找评论
     */
    List<Comment> selectCommentBySongId(Integer songId);
    /**
     * 方法描述
     * @param: [id]
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌单id查询评论
     */
    List<Comment> selectCommentBySongListId(Integer songListId);

}
