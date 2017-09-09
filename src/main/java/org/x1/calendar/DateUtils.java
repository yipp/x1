package org.x1.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 作者：泡泡大湿
 * 时间： 2017/9/7.
 * 描述：
 */
public class DateUtils {
    public static long currentTime(){
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }
    public static int currentDay(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date tem = new Date();
        String to = format.format(tem);
        return Integer.parseInt(to);
    }
    private static  Calendar dayEndCalendar(){
        Calendar c= Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,24);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        return c;
    }
    public static int day(){
        Date date = dayEndCalendar().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String from = format.format(date);
        int to = Integer.parseInt(from);
        return to;
    }
    public static long dayEndMillis(){
        return dayEndCalendar().getTimeInMillis();
    }
}
