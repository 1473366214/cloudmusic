package com.music.cloundmusic.util;

import com.github.pagehelper.PageInfo;
import com.music.cloundmusic.entity.Singer;

import java.util.List;

public class PageInfoSinger {
    List<Singer> list;
    private int pageNum;
    private int pages;

    public PageInfoSinger(){}

    public PageInfoSinger(PageInfo<Singer> pageInfo){
        this.list=pageInfo.getList();
        this.pageNum=pageInfo.getPageNum();
        this.pages=pageInfo.getPages();
    }

    public List<Singer> getList() {
        return list;
    }

    public void setList(List<Singer> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
