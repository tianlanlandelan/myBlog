package com.sky.blog.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by yangkaile on 2018/1/14.
 */
public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        System.out.println("-----" + filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
