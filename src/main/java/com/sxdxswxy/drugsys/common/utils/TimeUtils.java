package com.sxdxswxy.drugsys.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Justdwiwt
 */
public class TimeUtils {

    /**
     * 获取当前时间
     *
     * @param date Date
     * @return format(date)
     */
    public static String getTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
