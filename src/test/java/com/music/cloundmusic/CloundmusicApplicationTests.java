package com.music.cloundmusic;

import com.music.cloundmusic.entity.*;
import com.music.cloundmusic.service.*;
import com.music.cloundmusic.util.PageInfoHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloundmusicApplicationTests {

    @Autowired
    private MusicService musicService;
    @Test
    void contextLoads() {
        PageInfoHelper<Music> pageInfoHelper = musicService.searchMusic(2,5,"Live");
        if(pageInfoHelper.getList().size()>0)
        for(Music m:pageInfoHelper.getList())
        System.out.println(m.getName());
    }

}
