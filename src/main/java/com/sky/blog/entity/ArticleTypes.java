package com.sky.blog.entity;

/**
 * Created by yangkaile on 2018/1/14.
 */
public class ArticleTypes {
    private int articleId;
    private int typeId;

    public ArticleTypes() {
    }

    public ArticleTypes(int articleId, int typeId) {
        this.articleId = articleId;
        this.typeId = typeId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
