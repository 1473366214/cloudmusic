package com.music.cloundmusic.configuration;

import com.music.cloundmusic.interceptor.AdminInterceptor;
import com.music.cloundmusic.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "user-interceptor")
@SpringBootConfiguration
public class Configuration implements  WebMvcConfigurer {

    @Value("${staticFilePath}")
    private String staticFilePath;
    @Value("${relativePath}")
    private String relativePath;
    private AdminInterceptor adminInterceptor;
    private UserInterceptor userInterceptor;
    private List<String> userPage = new ArrayList<>();

    @Autowired
    public void setAdminInterceptor(AdminInterceptor adminInterceptor) {
        this.adminInterceptor = adminInterceptor;
    }
    @Autowired
    public void setUserInterceptor(UserInterceptor userInterceptor) {
        this.userInterceptor = userInterceptor;
    }


    public List<String> getUserPage() {
        return userPage;
    }

    public void setUserPage(List<String> userPage) {
        this.userPage = userPage;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/updateAdminPassword.do");
        registry.addInterceptor(userInterceptor).addPathPatterns(userPage);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(relativePath+"*/**").addResourceLocations(staticFilePath);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/userLogin").setViewName("userLogin");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/message").setViewName("userMessage");
        registry.addViewController("/index_index").setViewName("index_index");
        registry.addViewController("/index_album").setViewName("index_album");
        registry.addViewController("/index_singer").setViewName("index_singer");
        registry.addViewController("/index_home").setViewName("index_home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/play").setViewName("musicAudio");
        registry.addRedirectViewController("/","/index");
    }
}
