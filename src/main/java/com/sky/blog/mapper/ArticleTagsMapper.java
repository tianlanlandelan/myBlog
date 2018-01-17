package com.sky.blog.mapper;

import com.sky.blog.entity.ArticleTags;
import com.sky.blog.entity.TagInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 文章标签记录表
 * Created by yangkaile on 2018/1/14.
 */
@Mapper
public interface ArticleTagsMapper {
    String tableName =  "article_tags";
    String tagTableName = "tag_info";

    @Select("SELECT id,name FROM article_tags at , tag_info t WHERE at.tag_id = t.id AND at.article_id = #{articleId} ")
    List <TagInfo> getTagInfoByArticleId(int articleId);
    /**
     * 根据文章Id查询标签
     * @param articleId
     * @return
     */
    @Select("SELECT article_id,tag_id FROM " + tableName + " WHERE article_id = #{articleId}")
    List<ArticleTags> getByArticleId(int articleId);

    /**
     * 根据标签ID查询文章
     * @param tagId
     * @return
     */
    @Select("SELECT * FROM " + tableName + " WHERE tag_id = #{tagId}")
    List<ArticleTags> getByTagId(int tagId);

    /**
     * 根据标签ID删除
     * @param tagId
     */
    @Delete("DELETE FROM " + tableName + " WHERE tag_id = #{tagId}")
    void deleteByTagId(int tagId);

    /**
     * 根据文章ID删除
     * @param articleId
     */
    @Delete("DELETE FROM " + tableName + " WHERE article_id = #{articleId}")
    void deleteByArticleId(int articleId);

    /**
     * 根据文章ID和标签ID删除
     * @param articleId
     * @param tagId
     */
    @Delete("DELETE FROM " + tableName + " WHERE article_id = #{articleId} AND tag_id = #{tagId}")
    void deleteByArticleIdAndTagId(int articleId,int tagId);

    /**
     * 添加记录
     * @param articleTags
     */
    @Insert("INSERT INTO " + tableName + " (article_id,tag_id) VALUES (#{articleId},#{tagId})")
    void insert(ArticleTags articleTags);
}
