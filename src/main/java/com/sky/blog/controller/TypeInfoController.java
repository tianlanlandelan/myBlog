package com.sky.blog.controller;

import com.sky.blog.config.ResultData;
import com.sky.blog.entity.TypeInfo;
import com.sky.blog.service.TypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yangkaile on 2018/1/14.
 */
@RestController
@RequestMapping("/typeInfo")
public class TypeInfoController {
    @Autowired
    private TypeInfoService typeInfoService;

    /**
     * 获取所有类型
     * @return
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResultData getAll(){
        List<TypeInfo> list = typeInfoService.getAll();
        return new ResultData(list);
    }

    /**
     * 修改类型
     * @param id    原类型id
     * @param name  类型新名称
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResultData update(Integer id,String name){
        if(id != null && name != null){
            TypeInfo info = typeInfoService.update(id,name);
            if(info != null){
                return new ResultData(info);
            }else{
                return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTEXIT);
            }
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }

    }

    /**
     * 添加新类型
     * @param name  类型名称
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResultData insert(String name){
        if(name != null){
            return new ResultData(typeInfoService.insert(name));
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }
    }

    /**
     * 删除类型
     * @param id    类型id
     * @return
     */
    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    ResultData deleteById(Integer id){
        if(id != null){
            typeInfoService.deleteById(id);
            return new ResultData();
        }else{
            return new ResultData(ResultData.ERROR,ResultData.MESSAGE_NOTNULL);
        }
    }
}
