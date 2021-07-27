package com.zh.music.utils;

import javafx.scene.control.Tab;
import lombok.Data;

/**
 * @author zou
 * @ClassName : com.zh.music.utils.ResponseResult
 * @Description : 类描述
 * Created by user on 2021-07-07 20:35:26
 * Copyright  2020 user. All rights reserved.
 */
@Data
public class ResponseResult<T> {
    private  Integer code ;
    private String message;
    private T data;

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
/**
 * 方法描述
 * @param: []
 * @return: ResponseResult<T>
 * @author: zhang
 * @date: 2021/7/7
 * 成功返回并无数据
*/
    public  static <T>  ResponseResult<T> success(Integer code,String message) {
        return new ResponseResult<T>(code, message);
}
/**
 * 方法描述
 * @param: [data]
 * @return: ResponseResult<T>
 * @author: zhang
 * @date: 2021/7/7
 * 成功返回并有数据
*/
    public  static <T>  ResponseResult<T> success(Integer code,String message,T data) {
        return new ResponseResult<T>(code,message,data);
    }
    /**
     * 方法描述
     * @param: [data]
     * @return: ResponseResult<T>
     * @author: zhang
     * @date: 2021/7/7
     * 失败返回无数据
    */
    public  static <T>  ResponseResult<T> error(Integer code,String message) {
        return new ResponseResult<T>(code, message);
    }
    /**
     * 方法描述
     * @param: [code, message, data]
     * @return: ResponseResult<T>
     * @author: zhang
     * @date: 2021/7/7
     * 失败返回有数据
    */
    public  static <T>  ResponseResult<T> error(Integer code, String message, T data) {
        return new ResponseResult<T>(code, message,data);
    }
}
