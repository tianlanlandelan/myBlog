package com.sky.blog.service;

import com.sky.blog.entity.TagInfo;
import com.sky.blog.entity.TypeInfo;
import com.sky.blog.mapper.TagInfoMapper;
import com.sky.blog.mapper.TypeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@Service
public class TypeInfoService {
    @Autowired
    private TypeInfoMapper typeInfoMapper;
    public TypeInfo update(int id, String name){
        TypeInfo typeInfo = typeInfoMapper.getById(id);
        if(typeInfo == null){
            return null;
        }else{
            typeInfo.setName(name);
            typeInfoMapper.update(typeInfo);
            return typeInfo;
        }
    }
    public List<TypeInfo> getAll(){
        return typeInfoMapper.getAll();
    }
    public TypeInfo insert(String name){
        TypeInfo typeInfo = new TypeInfo(name);
        typeInfoMapper.insert(typeInfo);
        return typeInfo;
    }
    public void deleteById(int id){
        typeInfoMapper.deleteById(id);
    }
}
