package com.zh.music.service.impl;

import com.zh.music.domain.Comment;
import com.zh.music.mapper.CommentMapper;
import com.zh.music.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.service.impl.CommentServiceImpl
 * @Description : 类描述
 * Created by user on 2021-07-10 14:42:07
 * Copyright  2020 user. All rights reserved.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    /**
     * 方法描述
     * @param: [comment]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    /**
     * 方法描述
     * @param: [comment]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @Override
    public boolean update(Comment comment) {
        return commentMapper.update(comment) > 0;
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
        return commentMapper.deleteOne(id) > 0;
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Comment
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找评论
     */
    @Override
    public Comment selectCommentById(Integer id) {
        return commentMapper.selectCommentById(id);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌手
     */
    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定歌曲id查找评论
     */
    @Override
    public List<Comment> selectCommentBySongId(Integer songId) {
        return commentMapper.selectCommentBySongId(songId);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌单id查询评论
     */
    @Override
    public List<Comment> selectCommentBySongListId(Integer songListId) {
        return commentMapper.selectCommentBySongListId(songListId);
    }
}
