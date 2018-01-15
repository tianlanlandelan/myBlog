package com.sky.blog.mapper;

import com.sky.blog.entity.TagInfo;
import com.sky.blog.entity.TypeInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * 类型信息表
 * Created by yangkaile on 2018/1/14.
 */
@Mapper
public interface TypeInfoMapper {
    String tableName = "type_info";
    /**
     * 获取所有类型
     * @return
     */
    @Select("SELECT * FROM " +  tableName +" ")
    List<TypeInfo> getAll();

    /**
     * 添加类型
     * @param typeInfo
     */
    @Insert("INSERT INTO " + tableName + "(name) VALUES(#{name})")
    @SelectKey(statement = "SELECT last_insert_id() as id", keyProperty = "id", before = false, resultType = Integer.class, statementType = StatementType.STATEMENT)
    void insert(TypeInfo typeInfo);

    /**
     * 根据ID删除类型
     * @param id
     */
    @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
    void deleteById(int id);

    @Update("UPDATE " + tableName + " SET name = #{name} WHERE id = #{id}")
    void update(TypeInfo typeInfo);

    @Select("SELECT id,name FROM " + tableName + " WHERE id = #{id}")
    TypeInfo getById(int id);
}
