package com.company.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2020/4/22 16:44
 * @describe 1. doSearch 返回一个字符串
 *           2. doSearchUI 返回一个页面
 *           3. doSearchPages 将 java 对象转换成 json 返回
 */
@Controller
@RequestMapping("/")
public class SearchController {

    @RequestMapping("doSearchPages")
    @ResponseBody
    public List<Map<String, Object>> doSearchPages(Integer currentPage) {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> hashMap = new HashMap<>(10);
        hashMap.put("title1", "Circles");
        hashMap.put("title2", "line");
        list.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("title3", "Circles");
        hashMap.put("title4", "line");
        list.add(hashMap);
        /*
        jackson 将 java 对象自动转换成 json 串，但是需要在
        spring-configs.xml 中配置注解驱动自动加载一些 bean
         */
        return list;

    }

    /**
     * 返回一个页面，需要配置视图解析器
     *
     * @return
     */
    @RequestMapping("doSearchUI")
    public String doSearchUI() {
        return "search";
        // WEB-INF/pages/search.html
    }

    /**
     * 基于条件返回查询结果
     *
     * @param key
     * @return
     */
    @RequestMapping("doSearch")
    @ResponseBody
    public String doSearch(String key) {
        System.out.println("search...");
        return "search result by key";
    }
}
