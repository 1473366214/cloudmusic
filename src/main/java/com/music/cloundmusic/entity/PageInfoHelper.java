package com.music.cloundmusic.entity;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageInfoHelper<T> {
    List<T> list;
    private int pageNum;
    private int pages;

    public PageInfoHelper(PageInfo pageInfo) {
        this.list = pageInfo.getList();
        this.pageNum=pageInfo.getPageNum();
        this.pages=pageInfo.getPages();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
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
