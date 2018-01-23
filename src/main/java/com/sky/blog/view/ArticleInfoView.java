package com.sky.blog.view;

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
    private String txtContent;
    private String tagNames;
    private List<String> tagList = new ArrayList<String>();
    private Integer typeId;
    private String typeName;
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

    public String getTagNames() {
        return tagNames;
    }

    public void setTagNames(String tagNames) {
        this.tagNames = tagNames;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    @Override
    public String toString() {
        return "ArticleInfoView{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", outline='" + outline + '\'' +
                ", txtContent='" + txtContent + '\'' +
                ", tagNames='" + tagNames + '\'' +
                ", tagList=" + tagList +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", sendTime=" + sendTime +
                ", sendTimeStr='" + sendTimeStr + '\'' +
                '}';
    }
}
