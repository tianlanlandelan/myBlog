package com.sky.blog.service;

import com.sky.blog.config.BlogConfig;
import com.sky.blog.entity.TagInfo;
import com.sky.blog.mapper.TagInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@Service
public class TagInfoService {
    @Autowired
    public TagInfoMapper tagInfoMapper;

    public List<TagInfo> getAll(){
        return tagInfoMapper.getAll();
    }

    public int insertList(String tagNames){
        if(tagNames == null) return 0;
        String[] list = tagNames.split(BlogConfig.SPLITSTR);
        int count = 0 ;
        List<String> tagNameList = tagInfoMapper.getAllName();
        for(String tagName:list){
            if(tagName == null || "".equals(tagName) || " ".equals(tagName)) continue;
            if(tagNameList == null || tagNameList.size() < 1 || !tagNameList.contains(tagName)){
                TagInfo tagInfo = new TagInfo(tagName);
                tagInfoMapper.insert(tagInfo);
                count ++;
            }
        }
        return count;
    }
    public TagInfo insert(String tagName){
        TagInfo tagInfo = new TagInfo(tagName);
        tagInfoMapper.insert(tagInfo);
        return tagInfo;
    }
    public void deleteByName(String  name){
        tagInfoMapper.deleteByName(name);
    }
}
