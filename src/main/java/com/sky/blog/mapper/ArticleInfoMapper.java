package com.sky.blog.mapper;

import com.sky.blog.entity.ArticleInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by yangkaile on 2018/1/13.
 * 文章详情的Mapper
 * 增删改查操作
 */
@Mapper
public interface ArticleInfoMapper{
     String tableName =  "article_info";

    /**
     * 获取文章列表
     * 该方法只返回文章id、标题、发表时间，不返回文章内容
     * @return
     */
    @Select("SELECT id,title,content,sendtime FROM " + tableName + " ORDER BY sendtime DESC")
    List<ArticleInfo> getAll();

    /**
     * 查询指定标签的文章列表
     * @param tagId
     * @return
     */
    @Select("SELECT  a.id,a.title,a.sendtime FROM article_info a,article_tags at WHERE a.id = at.article_id and at.tag_id = #{tagId}")
    List<ArticleInfo> getListByTagId(int tagId);

    /**
     * 查询指定类型的文章列表
     * @param typeId
     * @return
     */
    @Select("SELECT  a.id,a.title,a.sendtime FROM article_info a,article_types at WHERE a.id = at.article_id and at.type_id = #{typeId}")
    List<ArticleInfo> getListByTypeId(int typeId);

    /**
     * 查询指定文章详情
     * @param id
     * @return
     */
    @Select("SELECT id,title,content,sendtime FROM " + tableName + " where id = #{id}")
    ArticleInfo getById(int id);

    /**
     * 添加文章并返回文章ID
     * @param articleInfo
     */
    @Insert("INSERT INTO " + tableName + " (title,content,sendtime) VALUES (#{title},#{content},#{sendTime})")
    @SelectKey(statement = "SELECT last_insert_id() as id", keyProperty = "id", before = false, resultType = Integer.class, statementType = StatementType.STATEMENT)
    void insert(ArticleInfo articleInfo);

    @Update("UPDATE " + tableName + " SET title = #{title} , content = #{content} WHERE id = #{id} ")
    void update(ArticleInfo articleInfo);

}
