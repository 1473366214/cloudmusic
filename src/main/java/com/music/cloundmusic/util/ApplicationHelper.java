package com.music.cloundmusic.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationHelper {
    @Value("${default-user-cover}")
    String defaultUserCover;
    @Value("${default-username}")
    String defaultUserName;
    @Value("${default-music-cover}")
    String defaultMusicCover;
    @Value("${staticFilePath:/staticFile/}")
    String staticFilePath;
    @Value("${relativePath}")
    String relativePath;

    private List<String> userPage = new ArrayList<>();

    public ApplicationHelper(){

    }

    public String getStaticFilePath() {
        return staticFilePath;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public List<String> getUserPage() {
        return userPage;
    }

    public void setUserPage(List<String> userPage) {
        this.userPage = userPage;
    }

    public String getDefaultUserCover() {
        return defaultUserCover;
    }

    public String getDefaultUserName() {
        return defaultUserName;
    }

    public String getDefaultMusicCover() {
        return defaultMusicCover;
    }
}
