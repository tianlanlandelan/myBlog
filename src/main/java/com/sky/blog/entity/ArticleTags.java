package com.sky.blog.entity;

/**
 * Created by yangkaile on 2018/1/14.
 */
public class ArticleTags {
    private int articleId;
    private String tagName;

    public ArticleTags() {
    }

    public ArticleTags(int articleId, String tagName) {
        this.articleId = articleId;
        this.tagName = tagName;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
