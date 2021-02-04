/**
 * Copyright (c) 2015, sinlov Corporation, All Rights Reserved
 */
package com.sinlov.java.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * for matcher date
 * <p>Created by "sinlov" on 2015/11/29.
 */
public class DateMatcher {

    private static final String MATCHES_TIMESTAMP_NUMBER = "^\\d{13}$";
    private static SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private static Calendar calendar = Calendar.getInstance();

    /**
     * time String to long
     * @param time string
     * @return long
     */
    public static long timeString2Long(String time){
        long result = 0l;
        if (null != time) {
            if (isValidDate(time)) {
                try {
                    Date date = defaultDateFormat.parse(time);
                    result = date.getTime() / 1000;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                String trim = time.trim();
                if (!trim.equals("")){
                    try{
                        result = Long.valueOf(trim);
                    }catch (Exception e){
                        new Throwable("Error date format").printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    /**
     * is valid date
     * @param time string
     * @return boolean
     */
    public static boolean isValidDate(String time) {
        try{
            defaultDateFormat.setLenient(false);
            if (null != time){
                defaultDateFormat.parse(time);
            }
            return true;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * get yesterday timestamp
     * @return timestamp
     */
    public static String timestampYesterday(){
        return timestampPastDay(-1);
    }

    /**
     * get past day timestamp -1 is yesterday
     * @param pastDay int
     * @return timestamp
     */
    public static String timestampPastDay(int pastDay){
        resetCalendar();
        calendar.add(Calendar.DATE, pastDay);
        return String.valueOf(calendar.getTimeInMillis());
    }

    /**
     *  get timestamp date by zero
     * @param day int
     * @return timestamp
     */
    public static long timestampDateZero(int day){
        resetCalendar();
        int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day_of_year + day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * get timestamp date string by zero
     * @param day day
     * @return timestamp string
     */
    public static String timestampDateZeroString(int day){
        return String.valueOf(timestampDateZero(day));
    }

    /**
     * get timestamp yesterday at Zero
     * @return timestamp size 13
     */
    public static String timestampYesterdayZero(){
        return String.valueOf(timestampDateZero(-1));
    }

    /**
     * PHP timestamp only 10 need sub string 0 10
     * @return "" or timestamp by change
     */
    public static String timestampToPHP(String timestamp) {
        if (null == timestamp) {
            new Throwable("timestamp is empty").printStackTrace();
            return "";
        } else {
            if (timestamp.matches(MATCHES_TIMESTAMP_NUMBER)) {
                return timestamp.substring(0, 10);
            } else {
                new Throwable("input timestamp is not timestamp").printStackTrace();
                return "";
            }
        }
    }

    /**
     * PHP timestamp now
     * @return timestamp
     */
    public static String phpTimeStampNow(){
        return timestampToPHP(String.valueOf(System.currentTimeMillis()));
    }

    /**
     * PHP timestamp string by day
     * @param day today is [0] yesterday is [-1]
     * @return timestamp
     */
    public static String phpTimestampStringZero(int day){
        return timestampToPHP(timestampDateZeroString(day));
    }

    /**
     * PHP timestamp yesterday
     * @return timestamp
     */
    public static String phpTimestampYesterday(){
        return timestampToPHP(timestampYesterday());
    }

    /**
     * PHP timestamp yesterday Zero
     * @return timestamp at Zero
     */
    public static String phpTimestampYesterdayZero(){
        return timestampToPHP(timestampYesterdayZero());
    }

    private static void resetCalendar(){
        DateMatcher.calendar = Calendar.getInstance();
    }

    private DateMatcher() {
    }
}
