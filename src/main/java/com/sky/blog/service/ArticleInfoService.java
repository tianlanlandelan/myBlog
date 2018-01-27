package com.sky.blog.service;

import com.sky.blog.config.BlogConfig;
import com.sky.blog.entity.*;
import com.sky.blog.mapper.*;
import com.sky.blog.utils.DateUtils;
import com.sky.blog.view.ArticleInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@Service
public class ArticleInfoService {
    @Autowired
    TagInfoService tagInfoService;
    @Autowired
    private ArticleInfoMapper articleInfoMapper;
    @Autowired
    private ArticleTagsMapper articleTagsMapper;
    @Autowired
    private ArticleTypesMapper articleTypesMapper;
    @Autowired
    private TagInfoMapper tagInfoMapper;
    @Autowired
    private TypeInfoMapper typeInfoMapper;

    public List<ArticleInfo> getAll(){
        return articleInfoMapper.getAll();
    }
    public List<ArticleInfo> getListByTypeId(int typeId){
        return articleInfoMapper.getListByTypeId(typeId);
    }
    public List<ArticleInfo> getListByTagId(int tagId){
        return articleInfoMapper.getListByTagId(tagId);
    }
    public ArticleInfoView getById(int id){
        ArticleInfo articleInfo =  articleInfoMapper.getById(id);
        if(articleInfo == null) return null;
        return toArticleInfoView(articleInfo);
    }
    /**
     * 添加文章
     * 当传入文章概要时，设置文章概要；
     * 当没有添加概要，设置文章前120字为概要，这个时候要做一下处理：文章内容是html格式的，需要只取文本内容
     * @return
     */
    public Integer insert(ArticleInfoView articleInfoView){
        ArticleInfo articleInfo = new ArticleInfo(articleInfoView.getTitle(),articleInfoView.getContent(),articleInfoView.getOutline(),articleInfoView.getTxtContent(),articleInfoView.getImgUrl());
        String outline;
        if(articleInfo.getOutline() != null){
            outline = articleInfo.getOutline();
            articleInfo.setOutline(outline.length() > 120 ? outline.substring(0, 120) : outline);
        }else if(articleInfo.getTxtContent() != null) {
            outline = articleInfo.getTxtContent();
            articleInfo.setOutline(outline.length() > 120 ? outline.substring(0, 120) : outline);
        }else {
            return null;
        }
        articleInfoMapper.insert(articleInfo);
        if(articleInfo.getId() != 0){
            //设置标签
            setArticleTags(articleInfo.getId(),articleInfoView.getTagNames());
            //设置类型
            setArticleTypes(articleInfo.getId(),articleInfoView.getTypeId());
            return articleInfo.getId();
        }else {
            return null;
        }
    }

    /**
     * 修改文章
     * 当传入参数中包含标签id和类型id时，修改文章标签和类型
     * @param id        文章id
     * @param title     标题
     * @param content   内容
     * @param tagNames    标签名称列表
     * @param typeId   类型id
     * @return  ArticleInfo 文章详情
     */
    public ArticleInfo update(int id,String title,String content ,String tagNames,Integer typeId){
        ArticleInfo articleInfo = articleInfoMapper.getById(id);
        if(articleInfo == null) return null;
        if(title != null) articleInfo.setTitle(title);
        if(content != null) articleInfo.setContent(content);
        articleInfoMapper.update(articleInfo);
        //设置文章标签和类型
        setArticleTags(id,tagNames);
        setArticleTypes(id,typeId);
        articleInfo.setContent("");
        return  articleInfo;
    }

    /**
     * 设置文章标签
     * 当要添加的标签不存在，同时添加标签
     * @param articleId 文章ID
     * @param tagNames  标签名称列表
     */
    private void setArticleTags(int articleId,String tagNames){
        if(tagNames != null){
            //设置标签前先删除文章所有标签
            articleTagsMapper.deleteByArticleId(articleId);
            String[] list =  tagNames.split(BlogConfig.SPLITSTR);
            for(String tagName:list){
                if(tagName == null || "".equals(tagName) || " ".equals(tagName)) continue;
                ArticleTags articleTags = new ArticleTags(articleId,tagName);
                articleTagsMapper.insert(articleTags);
            }
            tagInfoService.insertList(tagNames);
        }
    }

    /**
     * 设置文章类型
     * @param articleId
     * @param typeId
     */
    private void setArticleTypes(int articleId,Integer typeId){
        if(typeId != null){
            articleTypesMapper.deleteByArticleId(articleId);
            ArticleTypes articleTags = new ArticleTypes(articleId,typeId);
            articleTypesMapper.insert(articleTags);
        }
    }

    /**
     * 将ArticleInfo对象转换成ArticleInfoView用于在页面上显示
     * @param articleInfo 文章信息基本对象
     * @return  ArticleInfoView 视图对象
     */
    public ArticleInfoView toArticleInfoView(ArticleInfo articleInfo) {
        ArticleInfoView articleInfoView = new ArticleInfoView();
        articleInfoView.setId(articleInfo.getId());
        articleInfoView.setTitle(articleInfo.getTitle());
        articleInfoView.setOutline(articleInfo.getOutline());
        articleInfoView.setContent(articleInfo.getContent());
        articleInfoView.setTxtContent(articleInfo.getTxtContent());
        articleInfoView.setSendTime(articleInfo.getSendTime());
        articleInfoView.setImgUrl(articleInfo.getImgUrl());

        articleInfoView.setSendTimeStr(DateUtils.getDateTimeStr4Show(articleInfo.getSendTime()));
        List<TypeInfo> typesList = articleTypesMapper.getTypeInfoByArticleId(articleInfo.getId());
        for(TypeInfo type : typesList){
            articleInfoView.setTypeId(type.getId());
            articleInfoView.setTypeName(type.getName());
        }
        List<String> tagNameList = articleTagsMapper.getByArticleId(articleInfo.getId());
        for(String tagName:tagNameList){
            articleInfoView.getTagList().add(tagName);
        }
        return articleInfoView;
    }

    /**
     *
     * @param articleInfoList
     * @return
     */
    public List<ArticleInfoView> getViewList(List<ArticleInfo> articleInfoList){
        List<ArticleInfoView> list = new ArrayList<ArticleInfoView>();
        for(ArticleInfo articleInfo:articleInfoList){
            list.add(toArticleInfoView(articleInfo));
        }
        return list;
    }
}
