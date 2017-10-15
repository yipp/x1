package org.x1.utils.serializer.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：泡泡大湿
 * 时间： 2017/9/4.
 * 描述：
 */
public class FileName {
    /**
     * 方法1
     * @param path
     * @return
     */
//    public static String [] getFileName(String path)
//    {
//        File file = new File(path);
//        String [] fileName = file.list();
//        return fileName;
//    }

    /**
     * 方法2
     * @param path
     * @param fileName
     */
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
            fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
//    public static Map<String,String> getFileName(String path)
//    {
//        Map<String,String> fileMap = new HashMap<>();
//        File file = new File(path);
//        String[] beanNames = file.list();
//        File[] files = file.listFiles();
//        for (int i = 0;i<files.length;i++){
//            String beanName = StringUtils.substringBeforeLast(beanNames[i],".");
//            beanName = StringUtils.substringAfter(beanName,"_");
//            String s = files[i].toString();
//            String fileName = StringUtils.replace(s,"\\","/");
//            fileMap.put(beanName,fileName);
//        }
//        return fileMap;
//    }

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getFileName("src/main/resources/excel")));
//    }
}
