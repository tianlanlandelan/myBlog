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

    /**
     * 格式：yyyyMMdd_HHmmss_SSS
     * 用于生成文件名
     * @return
     */
    public static String getDateTimeStr4FileName(){
        return new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
    }

}
