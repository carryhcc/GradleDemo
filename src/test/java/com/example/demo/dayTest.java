package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : cchu
 * Date: 2021/8/25 17:01
 */
@SpringBootTest
public class dayTest {
    @Test
    void contextLoads() {
        System.out.println("HelloWorld！！！");
        System.out.println("HelloGitHub");
        System.out.println("HelloGogs");
    }
    @Test
    void day() {
        Date dt = new Date();
        String year = String.format("%tY", dt);
        String mon = String.format("%tm", dt);
        String day = String.format("%td", dt);
        String week = dateToWeek(dt.toString());
        System.out.println("今天是"+year+"年"+mon+"月"+day+"日"+week);
    }
    /**
     * 根据日期获取 星期 （2019-05-06 ——> 星期一）
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = f.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //一周的第几天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
