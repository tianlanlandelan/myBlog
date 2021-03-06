package com.sky.blog.controller;

import com.sky.blog.config.ResultData;
import com.sky.blog.entity.ArticleInfo;
import com.sky.blog.service.ArticleInfoService;
import com.sky.blog.view.ArticleInfoView;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 文章相关操作
 * Created by yangkaile on 2018/1/14.
 */
@RestController
@RequestMapping("/articleInfo")
public class ArticleInfoController {
    @Resource
    private ArticleInfoService articleInfoService;

    /**
     * 获取所有文章列表
     * @return
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResultData getAll(){
        List<ArticleInfo> articleInfoList = articleInfoService.getAll();
        if(articleInfoList == null){
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NODATA);
        }
        List<ArticleInfoView> list = articleInfoService.getViewList(articleInfoList);
        return new ResultData(list);
    }

    /**
     * 获取指定类型的文章列表
     * @param typeId    类型id
     * @return
     */
//    @RequestMapping(value = "/getListByTypeId",method = RequestMethod.GET)
//    ResultData getListByTypeId(Integer typeId){
//        if(typeId != null){
//            return new ResultData(articleInfoService.getListByTypeId(typeId));
//        }else{
//            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
//        }
//    }
    /**
     * 获取指定标签的文章列表
     * @param tagId     标签id
     * @return
     */
//    @RequestMapping(value = "/getListByTagId",method = RequestMethod.GET)
//    ResultData getListByTagId(Integer tagId){
//        if(tagId != null){
//            return new ResultData(articleInfoService.getListByTagId(tagId));
//        }else{
//            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
//        }
//    }
    /**
     * 添加文章
     *     请求json封装成的对象
     * 原始请求参数：
     *  title       标题
     *  content     内容（html格式）
     *  outline     概要
     *  txtContent  文本内容
     *  typeId      类型ID
     *  tagNames    标签名称列表
     *  @param articleInfoView
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResultData insert(@RequestBody ArticleInfoView articleInfoView){
        if(articleInfoView.getTitle() == null || articleInfoView.getContent() == null){
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }else{
            Integer result = articleInfoService.insert(articleInfoView);
            if(result == null) return new ResultData(ResultData.ERROR,ResultData.MESSAGE_ERROR);
            return  new ResultData(result);
        }
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    ResultData getById(Integer id){
        if(id == null){
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }else{
            ArticleInfoView articleInfoView = articleInfoService.getById(id);
            if(articleInfoView == null)  return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTEXIT);
            return new ResultData(articleInfoView);
        }
    }
    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    ResultData deleteById(Integer id){
        if(id == null){
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }else{
            articleInfoService.deleteById(id);
            return new ResultData();
        }
    }
    /**
     * 修改文章
     *  title       标题
     *  content     内容（html格式）
     *  outline     概要
     *  txtContent  文本内容
     *  typeId      类型ID
     *  tagNames    标签名称列表
     * @return
     */
//    @RequestMapping(value = "/update",method = RequestMethod.PUT)
//    ResultData update(@RequestBody ArticleInfoView articleInfoView){
//        if(id == null ||title == null || content == null){
//            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
//        }else{
//            ArticleInfo articleInfo = articleInfoService.update(id,title,content,tagIds,typeIds);
//            if(articleInfo == null) return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTEXIT);
//            return  new ResultData(articleInfo);
//        }
//    }

}
