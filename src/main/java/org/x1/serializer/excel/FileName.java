package org.x1.serializer.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }

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
    public static void main(String[] args)
    {
//        String [] fileName = getFileName("E:\\JavaUtils/SerializerUtils/src/main/java/org/yunet/serializer/ecxel");
//        for(String name:fileName)
//        {
//            System.out.println(name);
//        }
        System.out.println(ExcelUtils.class);
        File file = new File("src/main/resources/excel");
        File [] files = file.listFiles();
        String [] names = file.list();
        System.out.println(Arrays.toString(files));
//        System.out.println("--------------------------------");
//        ArrayList<String> listFileName = new ArrayList<String>();
//        getAllFileName("E:\\JavaUtils/SerializerUtils/src/main/java/org/yunet/serializer/ecxel",listFileName);
//        for(String name:listFileName)
//        {
//            System.out.println(name);
//        }

    }

}
