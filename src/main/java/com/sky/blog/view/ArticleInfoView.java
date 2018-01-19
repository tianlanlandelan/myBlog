package com.sky.blog.view;

import com.sky.blog.entity.*;
import com.sky.blog.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yangkaile on 2018/1/16.
 */
public class ArticleInfoView {

    private int id;
    private String title;
    private String content;
    private String outline;
    private String tagIds;
    private String typeIds;
    private List<String> tags = new ArrayList<String>();
    private String type;
    private Date sendTime;
    private String sendTimeStr;

    public ArticleInfoView() {
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

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(String typeIds) {
        this.typeIds = typeIds;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendTimeStr() {
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    @Override
    public String toString() {
        return "ArticleInfoView{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", outline='" + outline + '\'' +
                ", tagIds='" + tagIds + '\'' +
                ", typeIds='" + typeIds + '\'' +
                ", tags=" + tags +
                ", type='" + type + '\'' +
                ", sendTime=" + sendTime +
                ", sendTimeStr='" + sendTimeStr + '\'' +
                '}';
    }
}
