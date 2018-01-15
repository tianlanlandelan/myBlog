package com.sky.blog.service;

import com.sky.blog.entity.TagInfo;
import com.sky.blog.mapper.TagInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@Service
public class TagInfoService {
    @Autowired
    private TagInfoMapper tagInfoMapper;
    public TagInfo update(int id,String name){
        TagInfo tagInfo = tagInfoMapper.getById(id);
        if(tagInfo == null){
            return null;
        }else{
            tagInfo.setName(name);
            tagInfoMapper.update(tagInfo);
            return tagInfo;
        }
    }
    public List<TagInfo> getAll(){
        return tagInfoMapper.getAll();
    }
    public TagInfo insert(String name){
        TagInfo tagInfo = new TagInfo(name);
        tagInfoMapper.insert(tagInfo);
        return tagInfo;
    }
    public void deleteById(int id){
        tagInfoMapper.deleteById(id);
    }
}
