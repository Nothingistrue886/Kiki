package com.czff.mydemo.hutool;

import java.util.ArrayList;

public class HutoolTest {

    public static void main(String[] args) {


        ArrayList<Object> objects = new ArrayList<>();
//        new ArrayList<>(objects).forEach(obj -> System.out.println(obj.toString()));
        for (Object object : objects) {

            System.out.println(object.toString());
        }

//        String i = "1".concat("23");
//        System.out.println("i = " + i);

//        float size = 10385660 / (1024 * 1024);
//        System.out.println(size);


//        String str = "{\n" +
//                "  \"key1\":\"value1\",\n" +
//                "  \"key2\":\"value2\"\n" +
//                "}";
//        JSONObject obj = JSONUtil.parseObj(str);
//
//        Map<String, Object> map = BeanUtil.beanToMap(obj);
//
//        List<Map<String, Object>> arrayList = null;
//        arrayList.add(map);
//        arrayList.add(map);
//
//        for (Map<String, Object> stringObjectMap : arrayList) {
//            map.forEach((k, v) -> {
//                System.out.println(k + "----" + v.toString());
//            });
//        }


//
//        boolean innerIP = NetUtil.isInnerIP("127.0.0.1");
//        System.out.println(innerIP);
    }
}
