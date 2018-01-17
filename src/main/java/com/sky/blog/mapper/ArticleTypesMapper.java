package com.sky.blog.mapper;

import com.sky.blog.entity.ArticleTags;
import com.sky.blog.entity.ArticleTypes;
import com.sky.blog.entity.TypeInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@Mapper
public interface ArticleTypesMapper {
    String tableName =  "article_types";
    String typeTableName = "type_info";

    @Select("SELECT id,name FROM article_types at,type_info t WHERE at.type_id = t.id AND at.article_id = #{articleId} ")
    List <TypeInfo> getTypeInfoByArticleId(int articleId);

    @Select("SELECT article_id,tag_id FROM " + tableName + " WHERE article_id = #{articleId}")
    List<ArticleTypes> getByArticleId(int articleId);

    @Select("SELECT * FROM " + tableName + " WHERE type_id = #{typeId}")
    List<ArticleTypes> getByTypeId(int typeId);

    @Delete("DELETE FROM " + tableName + " WHERE type_id = #{typeId}")
    void deleteByTypeId(int typeId);

    @Delete("DELETE FROM " + tableName + " WHERE type_id = #{typeId}")
    void deleteByArticleId(int articleId);

    @Delete("DELETE FROM " + tableName + " WHERE article_id = #{articleId} AND type_id = #{typeId}")
    void deleteByArticleIdAndTypeId(int articleId,int typeId);

    @Insert("INSERT INTO " + tableName + " (article_id,type_id) VALUES (#{articleId},#{typeId})")
    void insert(ArticleTypes articleTags);
}
