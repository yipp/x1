package org.x1.utils.serializer.excel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.x1.utils.SpringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
public class ExcelUtils {
    /**
     *
     */
    private static Logger logger;
    static {
        logger = Logger.getLogger(ExcelUtils.class);
    }
    public static Map<String,String> getFileName(String path)
    {
        Map<String,String> fileMap = new HashMap<>();
        File file = new File(path);
        String[] beanNames = file.list();
        File[] files = file.listFiles();
        for (int i = 0;i<files.length;i++){
            String beanName = StringUtils.substringBeforeLast(beanNames[i],".");
            beanName = StringUtils.substringAfter(beanName,"_");
            String s = files[i].toString();
            String fileName = StringUtils.replace(s,"\\","/");
            fileMap.put(beanName,fileName);
        }
        return fileMap;
    }
    public static void init() {
        Map<String,String> fileMap = getFileName("src/main/resources/excel");
        for (Map.Entry<String,String> entry:fileMap.entrySet()){
            ClassPathExcelContext(entry.getValue(),entry.getKey());
        }
    }
    /**
     * 解析ecxel表
     */
    private static void ClassPathExcelContext(String fileName,String beanName) {
        List<List<String>> objs;//用于后面转对象使用
        objs = new ArrayList<>();
        Workbook book = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);//取到文件
            book = new XSSFWorkbook(fis);
            fis.close();//及时关闭流
            Sheet sheet = book.getSheetAt(0);//取到工作谱（每一页是一个工作谱）
            Iterator<Row> rows = sheet.iterator();
            List<String> obj = null;
            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();
                obj = new ArrayList<String>();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            cell.setCellType(Cell.CELL_TYPE_STRING);//全部转换成string类型
                            break;
                    }
                    obj.add(cell.getStringCellValue());
                }
                objs.add(obj);
            }
            serializerFile(objs, beanName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                book.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void serializerFile(List<List<String>> file, String beanName) {
        List<Map<String, String>> objMap = new ArrayList<>();
        Map<String, String> objs;
        for (int i = 3; i < file.size(); i++) {
            objs = new HashMap<>();
            for (int j = 0; j < file.get(i).size(); j++) {
                objs.put(file.get(1).get(j), file.get(i).get(j));
            }
            objMap.add(objs);
        }
        serializerObj(objMap, beanName);
    }

//    private static void serializerObj(List<Map<String, String>> objs, String clazzName) {
//        Map<Serializable, Object> beanMap = new HashMap<>();
//        Class clazz = null;
//        Object beanObj;
//        String[] str = clazzName.split("\\.");
//        String beanName = str[str.length - 1];
//        System.err.println(beanName);
//        try {
//            clazz = Class.forName(clazzName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException("-------找不到-------" + clazzName+e);
//        }
//
//        try {
//            beanObj = clazz.newInstance();
//        } catch (Exception e) {
//            throw new RuntimeException("" + clazzName);
//        }
//        for (int i = 0; i < objs.size(); i++) {
//            boolean isId = true;
//            int id = 0;
//            for (Map.Entry<String, String> entry : objs.get(i).entrySet()) {
//                if(isId) {
//                    id = Integer.parseInt(entry.getValue());
//                    isId = false;
//                }
//                try {
//                    Object value = null;
//                    Method m = writeMethod(beanObj, entry.getKey());
//
//                    Class<?>[] setMethod = m.getParameterTypes();
//                    //判断属性类型并赋值
//                    for (Class<?> c : setMethod) {
//                        if (c == int.class) value = Integer.parseInt(entry.getValue());
//                        else if (c == float.class) value = Float.parseFloat(entry.getValue());
//                        else if (c == double.class) value = Double.parseDouble(entry.getValue());
//                        else if (c == long.class) value = Long.parseLong(entry.getValue());
//                        else if (c == short.class) value = Short.parseShort(entry.getValue());
//                        else value = entry.getValue();
//                    }
//                    m.invoke(beanObj, value);
//                } catch (Exception e) {
//                    logger.error(e);
//                }
//            }
//            if(id != 0)
//                beanMap.put(id, beanObj);
//        }
//        //添加到所有导表缓存类中
//        StaticConfigMessage.getInstance().put(beanObj.getClass(),beanMap);
//        System.err.println(beanMap);
//    }
//
//    private static Method writeMethod(Object beanObj, String name) {
//        //得到属性的set方法用于注入
//        Method m;
//        Field ff;
//        logger.info("开始拼接set方法");
//        String methodName = "set" + name.substring(0, 1).toUpperCase()
//                + name.substring(1);
//        try {
//            logger.info("反射字段");
//            //获取该类的字段
//            ff = beanObj.getClass().getDeclaredField(name);
//            ff.setAccessible(true);
//        } catch (Exception e) {
//            logger.error(e);
//            throw new RuntimeException(beanObj.getClass() + "没有" + name + "这个属性");
//        }
//        try {
//            m = beanObj.getClass().getMethod(methodName, ff.getType());
//        } catch (Exception e) {
//            logger.error(e);
//            throw new RuntimeException(beanObj.getClass() + "没有" + methodName + "这个方法");
//        }
//        return m;
//    }
    private static void serializerObj(List<Map<String, String>> objs, String clazzName) {
        Map<Serializable, Object> beanMap = new HashMap<>();
        Class clazz = null;
        Object beanObj = null;
        try {
            clazz = Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < objs.size(); i++) {
            try {
                beanObj = clazz.newInstance();
                BeanUtils.populate(beanObj,objs.get(i));
                beanMap.put(((DataTableMessage)beanObj).id(),beanObj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //添加到所有导表缓存类中
        StaticConfigMessage.getInstance().put(beanObj.getClass(),beanMap);
    }

//    public static void main(String[] args) {
//        init();
//        Map m = StaticConfigMessage.getInstance().getmap();
//    }
}  