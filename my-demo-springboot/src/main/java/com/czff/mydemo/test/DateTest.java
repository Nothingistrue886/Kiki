package com.czff.mydemo.test;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {

    public static void main(String[] args) throws ParseException {



//        String dateStr = "2017-03-01 22:23:33";
//        Date date = DateUtil.parse(dateStr);
//        DateTime dateTime = DateUtil.offsetDay(date, -1);
//        System.out.println("date时间推迟1天后为:" + dateTime);
//
//        DateTime dateTime1 = DateUtil.offset(date, DateField.DAY_OF_YEAR, -1);
//        System.out.println(dateTime1);
//
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        String s = DateUtil.formatDateTime(date);
        System.out.println(s);

        DateTime dateTime = DateTime.of(time);
        String s1 = dateTime.toString();
        System.out.println(s1);


//        //设置时间格式
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //转换成对应的时间格式
//        String dateStr1 = f.format(dateTime1);
//        System.out.println(dateStr1);


//        List<String> strList = new ArrayList<>();
//        strList.add("1");
//        strList.add("2");
//        strList.add("3");
//        String jsonStr = JSONUtil.toJsonStr(strList);
//        System.out.println(jsonStr);

//        Map<String, Object> map = new HashMap<>();
//        map.put("user", "111");
//        String user = (String) map.get("user");
//        String user1 = (String) map.get("user1");
//        System.out.println(user + "---" + user1);

//        Dog dog = new Dog();
//        dog.setName("ccc");
//        Date date = new Date();
//        long time = date.getTime();
//        dog.setBirthday(date);
//        System.out.println(dog.toString());



//        String date1 = "2022-08-19 12:01:34";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = sdf.parse(date1);
//        String date2 = "2022-08-19 12:01:34";
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date parse2 = sdf2.parse(date2);
//        System.out.println(parse);
//        System.out.println(parse.toString());
//        // Fri Aug 19 12:50:21 CST 2022
//        // Fri Aug 19 12:50:21 CST 2022
//        System.out.println(parse2);
//        System.out.println(parse2.toString());
//        int rows = 4;
//        int pageSize = 5;
//        System.out.println((rows-1)/pageSize + 1);
    }

    @Data
    static
    class Dog {
        private String name;
        private Date birthday;
    }
}
