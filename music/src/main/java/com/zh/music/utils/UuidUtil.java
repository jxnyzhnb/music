package com.zh.music.utils;

import java.util.UUID;

/**
 * @author zou
 * @ClassName : com.zh.music.utils.UuidUtil
 * @Description : 类描述
 * Created by user on 2021-07-08 15:34:42
 * Copyright  2020 user. All rights reserved.
 */
public class UuidUtil {
    private UuidUtil() {
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println(UuidUtil.getUuid());
        System.out.println(UuidUtil.getUuid());
        System.out.println(UuidUtil.getUuid());
        System.out.println(UuidUtil.getUuid());
    }
}
