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


    public ArticleInfo insert(String title,String content,String tagIds,String typeIds){
        ArticleInfo articleInfo = new ArticleInfo(title,content);
        articleInfoMapper.insert(articleInfo);
        if(articleInfo.getId() != 0){
            //设置标签
            setArticleTags(articleInfo.getId(),tagIds);
            //设置类型
            setArticleTypes(articleInfo.getId(),typeIds);
            //文章内容一般较大，返回到页面时，去掉内容
            articleInfo.setContent("");
            return articleInfo;
        }else {
            return null;
        }
    }
    /**
     *  添加文章
     *  添加文章，如果传入参数有标签id列表和类型id列表，将同时设置文章的标签和类型
     * @param articleInfoView
     * @return
     */
//    public ArticleInfo insert(ArticleInfoView articleInfoView){
//        ArticleInfo articleInfo = new ArticleInfo(articleInfoView.getTitle(),articleInfoView.getContent());
//        articleInfoMapper.insert(articleInfo);
//        if(articleInfo.getId() != 0){
//            //设置标签
//            setArticleTags(articleInfo.getId(),articleInfoView.getTagIds());
//            //设置类型
//            setArticleTypes(articleInfo.getId(),articleInfoView.getTypeIds());
//            //文章内容一般较大，返回到页面时，去掉内容
//            articleInfo.setContent("");
//            return articleInfo;
//        }else {
//            return null;
//        }
//    }

    /**
     * 修改文章
     * 当传入参数中包含标签id和类型id时，修改文章标签和类型
     * @param id        文章id
     * @param title     标题
     * @param content   内容
     * @param tagIds    标签id列表
     * @param typeIds   类型id列表
     * @return
     */
    public ArticleInfo update(int id,String title,String content ,String tagIds,String typeIds){
        ArticleInfo articleInfo = articleInfoMapper.getById(id);
        if(articleInfo == null) return null;
        if(title != null) articleInfo.setTitle(title);
        if(content != null) articleInfo.setContent(content);
        articleInfoMapper.update(articleInfo);
        //设置文章标签和类型
        setArticleTags(id,tagIds);
        setArticleTypes(id,typeIds);
        articleInfo.setContent("");
        return  articleInfo;
    }

    /**
     * 设置文章标签
     * @param articleId
     * @param tagIds
     */
    private void setArticleTags(int articleId,String tagIds){
        if(tagIds != null){
            articleTagsMapper.deleteByArticleId(articleId);
            String[] list =  tagIds.split(BlogConfig.SPLITSTR);
            for(String str:list){
                Integer tagId = Integer.parseInt(str);
                if(tagId == null) continue;
                ArticleTags articleTags = new ArticleTags(articleId,tagId);
                articleTagsMapper.insert(articleTags);
            }
        }
    }

    /**
     * 设置文章类型
     * @param articleId
     * @param typeIds
     */
    private void setArticleTypes(int articleId,String typeIds){
        if(typeIds != null){
            articleTypesMapper.deleteByArticleId(articleId);
            String[] list =  typeIds.split(BlogConfig.SPLITSTR);
            for(String str:list){
                Integer typeId = Integer.parseInt(str);
                if(typeId == null) continue;
                ArticleTypes articleTags = new ArticleTypes(articleId,typeId);
                articleTypesMapper.insert(articleTags);
            }
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
        articleInfoView.setContent(articleInfo.getContent());
        articleInfoView.setSendTime(articleInfo.getSendTime());

        articleInfoView.setSendTimeStr(DateUtils.getDateTimeStr4Show(articleInfo.getSendTime()));
        List<TypeInfo> typesList = articleTypesMapper.getTypeInfoByArticleId(articleInfo.getId());
        if(typesList != null && typesList.size() > 0 ){
            articleInfoView.setType(typesList.get(0).getName());
        }
        List<TagInfo> tagInfoList = articleTagsMapper.getTagInfoByArticleId(articleInfo.getId());
        for(TagInfo tagInfo:tagInfoList){
            articleInfoView.getTags().add(tagInfo.getName());
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
