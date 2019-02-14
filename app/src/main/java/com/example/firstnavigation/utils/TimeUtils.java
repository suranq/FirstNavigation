package com.example.firstnavigation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 马明祥 on 2019/2/13.
 */

public class TimeUtils {

    public static String getDifference(String endTime) {
        Date date = new Date();
        long time2 = date.getTime();

        long endtimes = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date parse = dateFormat.parse(endTime);
            long time1 = parse.getTime();
            endtimes = time1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = time2 - endtimes;
        long minute = 1000 * 60;
        long hour = 1000 * 60 * 60;
        long day = 1000 * 60 * 60 * 24;
        long month = 1000 * 60 * 60 * 24 * 30;
        long year = 1000 * 60 * 60 * 24 * 30 * 12;
        if (time < hour) {
            long minute1 = time / minute;
            return minute1 + "分钟之前";
        } else if (time < day) {
            long hour1 = time / hour;
            return hour1 + "小时之前";
        } else  {
            long day1 = time / day;
            return day1 + "天之前";
        }
    }

    public static String gettime(String endTime) {
        Date date = new Date();
        long time2 = date.getTime();

        long endtimes = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = dateFormat.parse(endTime);
            long time1 = parse.getTime();
            endtimes = time1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = time2 - endtimes;
        long minute = 1000 * 60;
        long hour = 1000 * 60 * 60;
        long day = 1000 * 60 * 60 * 24;
        long month = 1000 * 60 * 60 * 24 * 30;
        long year = 1000 * 60 * 60 * 24 * 30 * 12;
        if (time < hour) {
            long minute1 = time / minute;
            return minute1 + "分钟之前";
        } else if (time < day) {
            long hour1 = time / hour;
            return hour1 + "小时之前";
        } else  {
            long day1 = time / day;
            return day1 + "天之前";
        }
    }
}
