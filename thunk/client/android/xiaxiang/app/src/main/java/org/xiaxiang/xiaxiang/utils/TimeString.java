package org.xiaxiang.xiaxiang.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gz on 2016/8/11.
 */
public class TimeString {
    public static String getCurrentTimeStamp() {
        Long timeStamp = System.currentTimeMillis();
        return String.valueOf(timeStamp);
    }

    public static String getCurrentHourMinute() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        return String.valueOf(hour) + ":" + String.valueOf(minute);
    }
}
