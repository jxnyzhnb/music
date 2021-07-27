package com.zh.music;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zh.music.mapper")
@SpringBootApplication
public class MusicApplication {
    static {
        System.setProperty("druid.mysql.usePingMethod","false");
    }

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        System.out.println(System.getProperty("file.separator"));
        System.out.println("file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "singerPic" + System.getProperty("file.separator"));
        SpringApplication.run(MusicApplication.class, args);

    }

}
