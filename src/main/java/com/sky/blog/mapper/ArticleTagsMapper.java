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

    /**
     * 根据文章Id查询标签
     * @param articleId
     * @return
     */
    @Select("SELECT tag_name FROM " + tableName + " WHERE article_id = #{articleId}")
    List<String> getByArticleId(int articleId);

    /**
     * 根据标签ID查询文章
     * @param tagName
     * @return
     */
    @Select("SELECT * FROM " + tableName + " WHERE tag_name = #{tagName}")
    List<ArticleTags> getArticleIdsByTagName(String tagName);



    /**
     * 根据文章ID删除
     * @param articleId
     */
    @Delete("DELETE FROM " + tableName + " WHERE article_id = #{articleId}")
    void deleteByArticleId(int articleId);


    /**
     * 添加记录
     * @param articleTags
     */
    @Insert("INSERT INTO " + tableName + " (article_id,tag_name) VALUES (#{articleId},#{tagName})")
    void insert(ArticleTags articleTags);
}
