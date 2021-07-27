package com.zh.music.controller;

import com.zh.music.domain.Consumer;
import com.zh.music.mapper.ConsumerMapper;
import com.zh.music.service.ConsumerService;
import com.zh.music.utils.Consts;
import com.zh.music.utils.DestFileUtils;

import com.zh.music.utils.ResponseResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author zou
 * @ClassName : com.zh.music.controller.ConsumerController
 * @Description : 类描述
 * Created by user on 2021-07-09 19:17:24
 * Copyright  2020 user. All rights reserved.
 * 前端用户Controller
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private static String path= Consts.PROJECTD+Consts.FILESPLIT+"avatorImages";
    @Autowired
    private ConsumerService consumerService;
    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 增加
     */
    @PostMapping("/add")
    public ResponseResult<Object> insert(Consumer consumer) {
        String username = consumer.getUsername();
        String password = consumer.getPassword();
        if (username==null|| "".equals(username)){
            return ResponseResult.success(0,"用户名不能为空！");
        }
        Consumer consumer1 = consumerService.selectConsumerByName(username);
        if (consumer1!=null){
            return ResponseResult.success(0,"该用户已存在！");
        }
        if (password==null|| "".equals(password)){
            return ResponseResult.success(0,"密码不能为空！");
        }
        consumer.setCreateTime(new Date());
        consumer.setUpdateTime(new Date());
        Boolean flag = consumerService.insert(consumer);
        if (flag) {
            return ResponseResult.success(1,"添加成功！");
        }
        return ResponseResult.success(0,"添加失败！");
    }

    /**
     * 方法描述
     * @param: [consumer]
     * @return: boolean
     * @author: zh
     * @date: 2021/7/8
     * 修改
     */
    @PostMapping("/update")
    public ResponseResult<Object> update(Consumer consumer) {
        consumer.setUpdateTime(new Date());
        Boolean flag = consumerService.update(consumer);
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
        Boolean flag = consumerService.deleteOne(id);
        if (flag) {
            return ResponseResult.success(1,"修改成功！");
        }
        return ResponseResult.success(0,"修改失败！");
    }

    /**
     * 方法描述
     * @param: [id]
     * @return: Consumer
     * @author: zh
     * @date: 2021/7/8
     * 根据id查找用户
     */
    @GetMapping("/selectByPrimaryKey")
    public ResponseResult<Consumer> selectConsumerById(Integer id) {
        Consumer consumer = consumerService.selectConsumerById(id);
        if (consumer!=null) {
            return ResponseResult.success(1,"修改成功！",consumer);
        }
        return ResponseResult.success(0,"修改失败！",consumer);
    }

    /**
     * 方法描述
     * @param: []
     * @return: List<Consumer>
     * @author: zh
     * @date: 2021/7/8
     * 查找所有用户
     */
    @GetMapping("/allConsumer")
    public ResponseResult<List<Consumer>> selectAll() {
        List<Consumer> consumers = consumerService.selectAll();
        return ResponseResult.success(1,"查找成功！",consumers);
    }

    /**
     * 方法描述
     * @param: [name]
     * @return: List<Consumer>
     * @author: zh
     * @date: 2021/7/8
     * 更新用户图片
     */
    @PostMapping("/updateConsumerPic")
    public ResponseResult<String> updateConsumerPic(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("id") Integer id) {
        if (!file.isEmpty()){
            String contentType = file.getContentType();
            if (contentType!=null){
                String fileName = DestFileUtils.getFileName(contentType);
                File destFile = DestFileUtils.getDestFile(fileName, path);
                log.info("destFile是{}",destFile);
                String dataPath="/avatorImages/"+fileName;
                try {
                    file.transferTo(destFile);
                    Consumer consumer = new Consumer();
                    consumer.setId(id);
                    consumer.setAvator(dataPath);
                    consumer.setUpdateTime(new Date());
                    String oldAvatorPath = consumerService.selectAvatorByID(id);
                    Boolean flag = consumerService.update(consumer);
                    if (flag){
                        if (!oldAvatorPath.contains("user.jpg")){
                            String oldFileName = oldAvatorPath.substring(oldAvatorPath.lastIndexOf("/") + 1);
                            File oldFile = new File(path + Consts.FILESPLIT + oldFileName);
                            boolean deleteFlag = oldFile.delete();
                            if (deleteFlag){
                                log.info("deleteFlag是{}",deleteFlag);
                                return ResponseResult.success(1,"上传成功！",dataPath);
                            }else {
                                return ResponseResult.success(0,"上传失败！");
                            }

                        }
                        return ResponseResult.success(1,"上传成功！",dataPath);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseResult.error(0,"上传失败！");
                }
            }

        }
        return ResponseResult.error(0,"上传失败！");
    }

    /**
     * 方法描述
     * @param: [username, password]
     * @return: Integer
     * @author: zh
     * @date: 2021/7/9
     * 验证登录
     */
    @PostMapping("/login")
    public ResponseResult<Object> verifyLogin(HttpServletRequest request, @RequestParam("username") String username,
                                              @RequestParam("password") String password) {
        Consumer consumer = consumerService.verifyLogin(username, password);
        if (consumer!=null){
            request.getSession().setAttribute("login_name",username);
            return ResponseResult.success(1,"登录成功！",consumer);
        }
        return ResponseResult.error(0,"登录失败！",consumer);
    }
}
