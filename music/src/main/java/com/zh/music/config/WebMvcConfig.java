package com.zh.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.zh.music.utils.Consts;

/**
 * @author zou
 * @ClassName : com.zh.music.config.WebMvcConfig
 * @Description : 类描述
 * Created by user on 2021-07-07 15:49:12
 * Copyright  2020 user. All rights reserved.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 方法描述
     *
     * @param: [registry]
     * @return: void
     * @author: zhang
     * @date: 2021/7/7
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //哪些文件可以跨域访问(/**所有)
        registry.addMapping("/**").
                //允许跨域的域名，可以用*表示允许任何域名使用
                        allowedOriginPatterns("*").
                //允许任何方法（post、get等）
                        allowedMethods("*").
                //允许任何请求头
                        allowedHeaders("*").
                //带上cookie信息
                        allowCredentials(true).
                //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
    }

  /*  @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (!StringUtils.isEmpty(source)) {
                    convertString(source);
                }
                return null;
            }
        });
    }*/
/**
 * 方法描述
 * @param: [registry]
 * @return: void
 * @author: zh
 * @date: 2021/7/8
 * 用于重新映射歌手图片地址,当访问地址为/img/singerPic/**是
 * 去file:C:\Users\86147\IdeaProjects\music\img\singerPic\找资源
*/
// System.getProperty("user.dir")为本项目的地址C:\Users\86147\IdeaProjects\music
//  * System.getProperty("file.separator")为该服务器系统的文件分隔符
//  * Linux的为/,windows为\,mac的为:
//  * 注意：映射的地址一定要到该资源的上级目录,且地址最后一定要加文件分隔符
@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    歌手图片地址映射
        registry.addResourceHandler("/img/singerPic/**")
            .addResourceLocations("file:"+ Consts.PROJECTD +
                    Consts.FILESPLIT+"img"+Consts.FILESPLIT
                    +"singerPic"+Consts.FILESPLIT);
//        歌曲图片
        registry.addResourceHandler("/img/songPic/**")
            .addResourceLocations("file:"+Consts.PROJECTD+
                    Consts.FILESPLIT+"img"+Consts.FILESPLIT
                    +"songPic"+Consts.FILESPLIT);
//        歌曲MP3资源
        registry.addResourceHandler("/song/**")
            .addResourceLocations("file:"+Consts.PROJECTD+
                    Consts.FILESPLIT+"song"+Consts.FILESPLIT);
//        歌单图片
        registry.addResourceHandler("/img/songListPic/**")
            .addResourceLocations("file:"+Consts.PROJECTD+
                    Consts.FILESPLIT+"img"+Consts.FILESPLIT
                    +"songListPic"+Consts.FILESPLIT);
//        用户头像
        registry.addResourceHandler("/avatorImages/**")
                .addResourceLocations("file:"+Consts.PROJECTD+Consts.FILESPLIT +"avatorImages"
                        +Consts.FILESPLIT);
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:"+Consts.PROJECTD+Consts.FILESPLIT +"img"
                        +Consts.FILESPLIT);
    }


}
