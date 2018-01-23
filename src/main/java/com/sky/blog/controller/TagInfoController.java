package com.sky.blog.controller;

import com.sky.blog.config.ResultData;
import com.sky.blog.entity.TagInfo;
import com.sky.blog.service.TagInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@RestController
@RequestMapping("/tagInfo")
public class TagInfoController {
    @Autowired
    private TagInfoService tagInfoService;

    /**
     * 获取所有标签
     * @return
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResultData getAll(){
        List<TagInfo> list = tagInfoService.getAll();
        return new ResultData(list);
    }


    /**
     * 添加新标签
     * @param name  标签名称
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResultData insert(String name){
        if(name != null){
            return new ResultData(tagInfoService.insert(name));
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }
    }

    /**
     * 删除标签
     * @param name    标签名称
     * @return
     */
    @RequestMapping(value = "/deleteByName",method = RequestMethod.DELETE)
    ResultData deleteByName(String name){
        if(name != null){
            tagInfoService.deleteByName(name);
            return new ResultData();
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }
    }


}
