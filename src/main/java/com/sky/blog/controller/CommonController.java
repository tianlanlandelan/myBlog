package com.sky.blog.controller;

import com.sky.blog.config.BlogConfig;
import com.sky.blog.entity.ArticleInfo;
import com.sky.blog.mapper.ArticleInfoMapper;
import com.sky.blog.utils.DateUtils;
import com.sky.blog.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.Date;
import java.util.List;

/**
 * 通用Controller
 * 包含文件上传功能
 * Created by yangkaile on 2018/1/13.
 */

@RestController
@RequestMapping("/common")
public class CommonController {

    /**
     * 文件上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        int index = fileName.lastIndexOf(BlogConfig.FILE_TYPE_SPLITSTR);
        if(index != -1)
            fileName = DateUtils.getDateTimeStr4FileName() + fileName.substring(index);
        else
            fileName = DateUtils.getDateTimeStr4FileName();

        try {
            FileUtils.uploadFile(file.getBytes(), BlogConfig.UPLOAD_PATH , fileName);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return e.getMessage();
        }
        //返回json
        return "uploadimg success:" + fileName;
    }
}
