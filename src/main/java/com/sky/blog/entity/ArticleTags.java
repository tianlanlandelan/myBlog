package com.sky.blog.entity;

/**
 * Created by yangkaile on 2018/1/14.
 */
public class ArticleTags {
    private int articleId;
    private int tagId;

    public ArticleTags() {
    }

    public ArticleTags(int articleId, int tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
