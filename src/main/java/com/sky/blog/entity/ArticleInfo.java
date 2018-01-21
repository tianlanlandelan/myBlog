package com.sky.blog.entity;

import java.util.Date;

/**
 * Created by yangkaile on 2018/1/13.
 */
public class ArticleInfo {
    private int id;
    private String title;
    private String content;
    private String outline;
    private String txtContent;
    private Date sendTime;


    public ArticleInfo() {
    }

    public ArticleInfo(String title, String content, String outline, String txtContent) {
        this.title = title;
        this.content = content;
        this.outline = outline;
        this.txtContent = txtContent;
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

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getTxtContent() {
        return txtContent;
    }

    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", outline='" + outline + '\'' +
                ", txtContent='" + txtContent + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
