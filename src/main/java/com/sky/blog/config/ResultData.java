package com.sky.blog.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangkaile on 2018/1/13.
 * 给前端返回的统一的数据格式
 */
public class ResultData {
    public static int SUCCESS = 0;
    public static int ERROR = 1;

    public static String MESSAGE_NOTEXIT = "数据不存在";
    public static String MESSAGE_NOTNULL = "参数不能为空";
    public static String MESSAGE_ERROR = "貌似出了点小问题，请稍后重试";

    private int code = SUCCESS;
    private String message = "success";
    private List data;

    public ResultData() {

    }

    public ResultData(int code, String message, List data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultData(List data) {
        this.data = data;
    }
    public ResultData(Object object){
        this.data = new ArrayList();
        this.data.add(object);
    }

    public ResultData(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
