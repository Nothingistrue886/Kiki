package com.czff.mydemo.string;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuidi
 * @description
 * @date 2023/3/5 13:57
 */
public class StringTest {
    public static void main(String[] args) throws ParseException {


  //      "paramList":"[{\"name\":\"ç ®ç  IP\",\"type\":\"1\",\"default\":\"15.36.26.3\",\"empty\":\"2\",\"parameter\":\"\",\"des\":\"XXX\"}]"
//        String str = "[{\"name\":\"123\",\"type\":\"1\",\"default\":\"12\",\"empty\":\"2\",\"parameter\":\"\",\"des\":\"我去额为\"}]";
//        List<JSONObject> objectList = JSONUtil.toList(str, JSONObject.class);
//        System.out.println(objectList.toString());


//
////		{"mes":"崔迪99","title":"崔迪99","type":["1","2","0"],"users":[{"ids":["1"],"userType":"0"}]}
//        Map<String, Object> map = new LinkedHashMap<>(); // linkedHashMap会使json后的字符串顺序一致
//        map.put("mes", "崔迪99");
//        map.put("title", "崔迪99");
//        List<String> typeList = new ArrayList<>();
//        typeList.add("1");
//        typeList.add("2");
//        typeList.add("0");
//        map.put("type", typeList);
//        List<Map<String, Object>> userList = new ArrayList<>();
//        HashMap<String, Object> userMap = new HashMap<>();
//        List<String> idList = new ArrayList<>();
//        idList.add("1");
//        userMap.put("ids", idList);
//        userMap.put("userType", "0");
//        userList.add(userMap);
//        map.put("users", userList);
//        System.out.println(map.toString());
////            System.out.println(jsonObject.toString());
//        JSONObject jsonObject = new JSONObject(map.toString());
//        System.out.println(jsonObject.toString());

//
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "cuidi");
//        map.put("age", 29);
//        String string = map.toString();
//        System.out.println(string);


//        String str = "2023-03-15 16:26:36.0";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = sdf.parse(str);
//        System.out.println(parse.toString());
//        String format = sdf.format(parse);
//        System.out.println(format);

//        String str = "[{\"alternateField257\": \"C:\\net.exe\"}]";
//        String replace = str.replace("\\", "\\");
//        System.out.println(replace);

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        String joinStr = String.join(",", list);
//        System.out.println(joinStr);


//        String typeName = "java.lang.String";
//        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);
//        System.out.println(typeName);


    }
}
