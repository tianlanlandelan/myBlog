package com.sky.blog.controller;

import com.sky.blog.config.ResultData;
import com.sky.blog.entity.ArticleInfo;
import com.sky.blog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章相关操作
 * Created by yangkaile on 2018/1/14.
 */
@RestController
@RequestMapping("/articleInfo")
public class ArticleInfoController {
    @Autowired
    private ArticleInfoService articleInfoService;

    /**
     * 获取所有文章列表
     * @return
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResultData getAll(){
        List<ArticleInfo> list = articleInfoService.getAll();
        return new ResultData(list);
    }

    /**
     * 获取指定类型的文章列表
     * @param typeId    类型id
     * @return
     */
    @RequestMapping(value = "/getListByTypeId",method = RequestMethod.GET)
    ResultData getListByTypeId(Integer typeId){
        if(typeId != null){
            return new ResultData(articleInfoService.getListByTypeId(typeId));
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }
    }
    /**
     * 获取指定标签的文章列表
     * @param tagId     标签id
     * @return
     */
    @RequestMapping(value = "/getListByTagId",method = RequestMethod.GET)
    ResultData getListByTagId(Integer tagId){
        if(tagId != null){
            return new ResultData(articleInfoService.getListByTagId(tagId));
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }
    }

    /**
     * 添加文章
     * @param title     标题
     * @param content   内容
     * @param tagIds    标签id列表
     * @param typeIds   类型id列表
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResultData insert(String title,String content,String tagIds,String typeIds){
        if(title == null || content == null){
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }else{
            ArticleInfo articleInfo = articleInfoService.insert(title,content,tagIds,typeIds);
            if(articleInfo == null) return new ResultData(ResultData.ERROR,ResultData.MESSAGE_ERROR);
            return  new ResultData(articleInfo);
        }
    }

    /**
     * 修改文章
     * @param id        文章id
     * @param title     标题
     * @param content   内容
     * @param tagIds    标签id列表
     * @param typeIds   类型id列表
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResultData update(Integer id,String title,String content,String tagIds,String typeIds){
        if(id == null ||title == null || content == null){
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }else{
            ArticleInfo articleInfo = articleInfoService.update(id,title,content,tagIds,typeIds);
            if(articleInfo == null) return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTEXIT);
            return  new ResultData(articleInfo);
        }
    }

}
