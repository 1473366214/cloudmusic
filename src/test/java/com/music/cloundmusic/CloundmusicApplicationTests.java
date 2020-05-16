package com.music.cloundmusic;

import com.music.cloundmusic.entity.Album;
import com.music.cloundmusic.entity.Comment;
import com.music.cloundmusic.entity.Music;
import com.music.cloundmusic.entity.Singer;
import com.music.cloundmusic.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CloundmusicApplicationTests {

    @Autowired
    private AlbumService albumService;
    @Test
    void contextLoads() {
        Album album= albumService.getAlbumById(1);
        System.out.println(album.getName()+" "+album.getSinger().getName());
    }

}
