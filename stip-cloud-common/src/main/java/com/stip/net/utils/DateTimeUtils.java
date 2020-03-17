package com.stip.net.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author cja
 * @version 2014-4-15
 */
public class DateTimeUtils extends DateUtils {
    static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    //private static Date BEFORE;
    //private static Date AFTER;
    private static Calendar BEFORECALENDAR = Calendar.getInstance();
    private static Calendar AFTERCALENDAR = Calendar.getInstance();


    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到日期时间字符串，转换格式（yyyyMMddHHmmss）
     */
    public static String formatOrderCode(Date date) {
        return formatDate(date, "yyyyMMddHHmmss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 两个时间比较
     *
     * @param before
     * @param after
     * @return
     */
    public static String getCompareDate(Date before, Date after) {
        BEFORECALENDAR.setTime(before);
        AFTERCALENDAR.setTime(after);
        long l = (BEFORECALENDAR.getTimeInMillis() - AFTERCALENDAR.getTimeInMillis()) / 1000;
        int days = new Long(l / (60 * 60 * 24)).intValue();
        int hours = new Long((l % (60 * 60 * 24)) / (60 * 60)).intValue();
        int min = new Long(l % (60 * 60) / 60).intValue();
        return "还剩" + days + "天" + hours + "时" + min + "分";

    }

    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getStartTimes() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.DAY_OF_MONTH, todayStart.get(Calendar.DAY_OF_MONTH) - 7);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getnowEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.DAY_OF_MONTH, todayEnd.get(Calendar.DAY_OF_MONTH) - 1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getStartTimesM() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.MINUTE, todayStart.get(Calendar.MINUTE) - 1);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getnowEndTimeM() {
        Calendar todayEnd = Calendar.getInstance();
        return todayEnd.getTime();
    }

    // 判断时间是否是当天
    public static boolean getDateIsToday(Date date) {
        if (date == null) {
            return false;
        }
        Calendar todaystart = Calendar.getInstance();
        todaystart.set(Calendar.HOUR_OF_DAY, 0);
        todaystart.set(Calendar.MINUTE, 0);
        todaystart.set(Calendar.SECOND, 0);
        todaystart.set(Calendar.MILLISECOND, 0);
        if (todaystart.getTimeInMillis() > date.getTime()) {
            return false;
        }

        Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.DAY_OF_MONTH, 1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 0);
        todayEnd.set(Calendar.MINUTE, 0);
        todayEnd.set(Calendar.SECOND, 0);
        todayEnd.set(Calendar.MILLISECOND, 0);
        if (todayEnd.getTimeInMillis() <= date.getTime()) {
            return false;
        }
        return true;
    }

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static Date getMondayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);

        return c.getTime();
    }

    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static Date getSundayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7);

        return c.getTime();
    }

    public static Date stringToDate(Object dateString, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        Date d = null;
        if (dateString != null && !"".equals(dateString)) {
            try {
                d = df.parse((String) dateString);
            } catch (ParseException e) {
            }
        }
        return d;
    }

    public static String dateToString(Date date, String dateFormat) {
        // DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat df = new SimpleDateFormat(dateFormat);
        String d = null;
        if (date != null) {
            d = df.format(date);
        }
        return d;
    }

    public static String getTodayString() {
        GregorianCalendar today = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String todayString = df.format(today.getTime());

        return todayString;
    }

    public static String getTodayString(String format) {
        GregorianCalendar today = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat(format);
        String todayString = df.format(today.getTime());

        return todayString;
    }

    public static String getTomorrowString() {
        GregorianCalendar tomorrow = new GregorianCalendar();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrowStringg = df.format(tomorrow.getTime());

        return tomorrowStringg;
    }

    public static String getYesterdayString() {
        GregorianCalendar yesterday = new GregorianCalendar();
        yesterday.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setCalendar(yesterday);
        String yesterdayString = df.format(yesterday.getTime());

        return yesterdayString;
    }

    public static String getDayByCount(int count) {
        GregorianCalendar yesterday = new GregorianCalendar();
        yesterday.add(Calendar.DAY_OF_MONTH, count);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setCalendar(yesterday);
        String yesterdayString = df.format(yesterday.getTime());

        return yesterdayString;
    }

    public static String getPrevMonthString(Date oneday) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oneday);
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(calendar.getTime());
    }

    /**
     * 指定时间 天 向前 或 向后 平移
     *
     * @param date
     * @param dayNum
     * @return
     */
    public static Date setDateDay(Date date, int dayNum) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(date);
        now.add(GregorianCalendar.DATE, dayNum);
        return now.getTime();
    }

    /**
     * 指定时间 分钟 向前 或 向后 平移
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date setDateMinute(Date date, int minute) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(date);
        now.add(GregorianCalendar.MINUTE, minute);
        return now.getTime();
    }

    /**
     * 指定时间 月 向前 或 向后 平移
     *
     * @param date
     * @param MonthNum
     * @return
     */
    public static Date setDateMonth(Date date, int MonthNum) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(date);
        now.add(GregorianCalendar.MONTH, MonthNum);
        return now.getTime();
    }

    /**
     * 指定时间 年 向前 或 向后 平移
     *
     * @param date
     * @param num
     * @return
     */
    public static Date setDateYear(Date date, int num) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(date);
        now.add(GregorianCalendar.YEAR, num);
        return now.getTime();
    }

    // 不管时分秒
    public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
        int nDay = (int) ((stringToDate(dateToString(secondDate, "yyyy-MM-dd"), "yyyy-MM-dd").getTime() - stringToDate(dateToString(firstDate, "yyyy-MM-dd"), "yyyy-MM-dd").getTime()) / (24 * 60 * 60 * 1000));
        return nDay;
    }

    /**
     * 指定时间 秒 向前 或 向后 平移
     *
     * @param date
     * @param Second
     * @return
     */
    public static Date setDateSecond(Date date, int Second) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(date);
        now.add(GregorianCalendar.SECOND, Second);
        return now.getTime();
    }

    /**
     * 计算两个时间的工作日天数
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int isWeekend(String startDate, String endDate) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date now = df.parse(startDate);
        Date date = df.parse(endDate);
        int i;
        if (now.getDay() == 1 || now.getDay() == 2 || now.getDay() == 3 || now.getDay() == 4 || now.getDay() == 5) {
            i = 1;
        } else {
            i = 0;
        }

        int subdate = (int) ((date.getTime() - now.getTime()) / (24 * 60 * 60 * 1000));
        for (int j = 0; j < subdate; j++) {
            now = setDateDay(now, 1);
            if (now.getDay() == 1 || now.getDay() == 2 || now.getDay() == 3 || now.getDay() == 4 || now.getDay() == 5) {
                i++;
            }// 判断是不是双休日
        }
        return i;

    }

    /**
     * 获取该日期是周几
     *
     * @param date
     * @return
     */
    public static int getWeekDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date getTraningDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int week = getWeekDay(cal.getTime());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        switch (week) {
            case 1:
            case 3:
            case 5:
                cal.add(Calendar.DAY_OF_MONTH, 1);
                break;
            case 2:
            case 4:
                if (hour >= 14) {
                    cal.add(Calendar.DAY_OF_MONTH, 2);
                }
                break;
            case 6:
                if (hour >= 14) {
                    cal.add(Calendar.DAY_OF_MONTH, 3);
                }
                break;
            case 0:
                cal.add(Calendar.DAY_OF_MONTH, 2);
            default:
                break;
        }
        cal.set(Calendar.HOUR_OF_DAY, 14);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定时间 小时 向前 或 向后 平移
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date setDateHour(Date date, int hours) {
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(date);
        now.add(GregorianCalendar.HOUR_OF_DAY, hours);
        return now.getTime();
    }

    /**
     * 得到北京时间
     *
     * @return
     * @throws Exception
     */
    public static Date getBeijinTime() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        URL url = new URL("http://www.ntsc.ac.cn/");// 取得资源对象
        URLConnection uc = url.openConnection();// 生成连接对象
        uc.connect(); // 发出连接
        long ld = uc.getDate(); // 取得网站日期时间
        Date date = new Date(ld); // 转换为标准时间对象

        return date;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getYearStart());
    }

    public static Date getTimeByType(int type) {
        Calendar todayStart = Calendar.getInstance();

        switch (type) {
            case 1:
                todayStart.set(Calendar.MINUTE, todayStart.get(Calendar.MINUTE) - 1);
                break;
            case 2:
                todayStart.set(Calendar.HOUR_OF_DAY, todayStart.get(Calendar.HOUR_OF_DAY) - 1);
                break;
            case 3:
                todayStart.set(Calendar.DAY_OF_MONTH, todayStart.get(Calendar.DAY_OF_MONTH) - 1);
                break;
            case 4:
                todayStart.set(Calendar.DAY_OF_MONTH, todayStart.get(Calendar.DAY_OF_MONTH) - 7);
                break;
            case 5:
                todayStart.set(Calendar.DAY_OF_MONTH, todayStart.get(Calendar.DAY_OF_MONTH) - 30);
                break;
        }

        return todayStart.getTime();
    }

    public static String timestampToStr(Integer time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String sd = sdf.format(new Date(time * 1000L)); // 时间戳转换成时间
        return sd;
    }

    public static String timestampToStr(Long time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String sd = sdf.format(new Date(time)); // 时间戳转换成时间
        return sd;
    }

    public static Integer getNowTimestamp() {
        return Math.toIntExact(System.currentTimeMillis() / 1000);
    }

    public static long getTodayStart() {
        long current = System.currentTimeMillis();
        return current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
    }

    public static long getWeekStart() {
        LocalDate with = LocalDate.now().with(DayOfWeek.MONDAY);
        return with.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long getMonthStart() {
        LocalDate now = LocalDate.now();
        LocalDate with = LocalDate.of(now.getYear(), now.getMonth(), 1);
        return with.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static long getYearStart() {
        LocalDate now = LocalDate.now();
        LocalDate with = LocalDate.of(now.getYear(), 1, 1);
        return with.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


}
