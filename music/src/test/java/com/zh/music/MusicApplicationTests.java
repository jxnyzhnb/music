package com.zh.music;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class MusicApplicationTests {

    @Test
    void contextLoads() {
        String contentType="image/jpg/da/d/sad/sd";
        System.out.println(contentType.lastIndexOf("/"));
        System.out.println(contentType.substring(contentType.lastIndexOf("/") + 1));
    }
    @Test
    void  ss(){
        boolean delete = new File("C:\\Users\\86147\\IdeaProjects\\music\\img\\a").delete();
        System.out.println(delete);

    }

}
