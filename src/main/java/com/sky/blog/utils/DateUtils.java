package com.sky.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangkaile on 2018/1/15.
 */
public class DateUtils {
    public static void main(String args[] ){
        System.out.println(getDateTimeStr4FileName());
    }

    public static String getDateStr(String str){
        return new SimpleDateFormat(str).format(new Date());
    }
    public static String getDateStr(String str,Date date){
        return new SimpleDateFormat(str).format(date);
    }
    /**
     * 格式：yyyyMMdd_HHmmss_SSS
     * 用于生成文件名
     * @return
     */
    public static String getDateTimeStr4FileName(){
        return getDateStr("yyyyMMdd_HHmmss_SSS");
    }

    public static String getDateTimeStr4Show(){
        return getDateStr("yyyy-MM-dd HH:mm:ss");
    }
    public static String getDateTimeStr4Show(Date date){
        return getDateStr("yyyy-MM-dd HH:mm:ss",date);
    }

    public static String getDateStr4Show(){
        return getDateStr("yyyy-MM-dd");
    }
}
