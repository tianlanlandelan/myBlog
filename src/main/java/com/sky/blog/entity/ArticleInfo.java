package com.sky.blog.entity;

import java.util.Date;

/**
 * Created by yangkaile on 2018/1/13.
 */
public class ArticleInfo {
    private String title;
    private String content;
    private Date sendTime;
    private int id;

    public ArticleInfo() {
    }

    public ArticleInfo(String title, String content, Date sendTime) {
        this.title = title;
        this.content = content;
        this.sendTime = sendTime;
    }

    public ArticleInfo(String title, String content) {
        this.title = title;
        this.content = content;
        this.sendTime = new Date();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
