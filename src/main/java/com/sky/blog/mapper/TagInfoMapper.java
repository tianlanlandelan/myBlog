package com.sky.blog.mapper;

import com.sky.blog.entity.TagInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * 标签信息表
 * Created by yangkaile on 2018/1/14.
 */
@Mapper
public interface TagInfoMapper {
    String tableName = "tag_info";
    /**
     * 获取所有的标签
     * @return
     */
    @Select("SELECT id,name FROM " +  tableName +" ")
    List<TagInfo> getAll();

    /**
     * 添加标签
     * @param tagInfo
     */
    @Insert("INSERT INTO " + tableName + "(name) VALUES(#{name})")
    @SelectKey(statement = "SELECT last_insert_id() as id", keyProperty = "id", before = false, resultType = Integer.class, statementType = StatementType.STATEMENT)
    void insert(TagInfo tagInfo);

    /**
     * 根据ID删除标签
     * @param id
     */
    @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
    void deleteById(int id);

    @Update("UPDATE " + tableName + " SET name = #{name} WHERE id = #{id}")
    void update(TagInfo tagInfo);

    @Select("SELECT id,name FROM " + tableName + " WHERE id = #{id}")
    TagInfo getById(int id);
}
