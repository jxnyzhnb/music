package com.zh.music.controller;

import com.zh.music.domain.Comment;
import com.zh.music.domain.userup;
import com.zh.music.service.CommentService;
import com.zh.music.service.userupService;
import com.zh.music.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.CommentController
 * @Description : 类描述
 * Created by user on 2021-07-10 14:44:25
 * Copyright  2020 user. All rights reserved.
 * 歌曲歌单评论Controller
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private userupService userupService;
    /**
     * 方法描述
     * @param: [comment]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @PostMapping("/add")
    public ResponseResult<Object> insert(Comment comment) {
        /*Byte type = comment.getType();
        if (type==0){
            comment.setSongListId(null);
        }else {
            comment.setSongId(null);
        }*/
        comment.setCreateTime(new Date()) ;
        boolean flag = commentService.insert(comment);
        if (flag) {
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.success(0,"添加失败！");
    }

    /**
     * 方法描述
     * @param: [comment]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @PostMapping("/update")
    public ResponseResult<Object> update(Comment comment) {
        boolean flag = commentService.update(comment);
        if (flag) {
            return ResponseResult.success(1,"修改成功！");
        }
        return ResponseResult.success(0,"修改失败！");
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 根据id删除
     */
    @GetMapping("/delete")
    public ResponseResult<Object> deleteOne(Integer id) {
        boolean flag = commentService.deleteOne(id);
        if (flag) {
            return ResponseResult.success(1,"删除成功！");
        }
        return ResponseResult.success(0,"删除失败！");
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Comment
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找评论
     */
    @GetMapping("/selectByPrimaryKey")
    public ResponseResult<Comment> selectCommentById(Integer id) {
        Comment comment = commentService.selectCommentById(id);
        if (null != comment) {
            return ResponseResult.success(1,"查询成功！",comment);
        }
        return ResponseResult.success(0,"查询失败！",comment);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有歌手
     */
    @GetMapping("/allComment")
    public ResponseResult<List<Comment>> selectAll() {
        List<Comment> comments = commentService.selectAll();
        return ResponseResult.success(1, "查找成功！", comments);
    }
    /**
     * 方法描述
     * @param: [name]
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 根据指定歌曲id查找评论
     */
    @GetMapping("/commentOfSongId")
    public ResponseResult<List<Comment>> selectCommentBySongId(Integer songId) {
        List<Comment> comments = commentService.selectCommentBySongId(songId);
        if (comments.size() > 0) {
            return ResponseResult.success(1,"查询成功！",comments);
        }
        return ResponseResult.success(0,"查询失败！",comments);
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: List<Comment>
     * @author: zh
     * @date: 2021/7/8
     * 根据歌单id查询评论
     */
    @GetMapping("/commentOfSongListId")
    public ResponseResult<List<Comment>> selectCommentBySongListId(Integer songListId) {
        List<Comment> comments = commentService.selectCommentBySongListId(songListId);
        if (comments.size() > 0) {
            return ResponseResult.success(1, "查询成功！", comments);
        }
        return ResponseResult.success(0, "查询失败！", comments);
    }
    @GetMapping("/getIsUp")
    public ResponseResult<Boolean> getIsUp(Integer id,HttpServletRequest request){
        String username= (String) request.getSession().getAttribute("login_user");
        userup userup=new userup();
        userup.setId(id);
        userup.setUsername(username);
        boolean upFlag = userupService.selectSongByCommentIdUserName(userup);
        return ResponseResult.success(1,"查询成功！！",upFlag);
    }
    /**
     * 方法描述
     * @param: [id, up]
     * @return: ResponseResult<Object>
     * @author: zh
     * @date: 2021/7/10
     * 给评论点赞
    */
    @PostMapping("/like")
    public ResponseResult<Object> like(HttpServletRequest request, @RequestParam("id")Integer id,
                                       @RequestParam("up")Integer up){
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUp(up);
        String username= (String) request.getSession().getAttribute("login_name");
        userup userup=new userup();
        userup.setUsername(username);
        userup.setCommentId(id);
        boolean upFlag = userupService.selectSongByCommentIdUserName(userup);
        log.info("登录的用户为{}",request.getSession().getAttribute("login_name"));
        log.info("upFlag值为{}",upFlag);
        if (upFlag){

            comment.setUp(up-1);
            boolean deleteFlag = userupService.deleteOne(userup);
            boolean flag = commentService.update(comment);
            if (flag){
                return ResponseResult.success(1,"取消点赞成功！",true);
            }
            return ResponseResult.success(0,"点赞失败！");
        }else {
            comment.setUp(up+1);
            boolean insertFlag= userupService.insert(userup);
            boolean flag = commentService.update(comment);
            if (flag) {
                return ResponseResult.success(1,"点赞成功！",false);
            }
            return ResponseResult.success(0,"点赞失败！");
        }

    }
}
