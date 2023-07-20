package com.czff.mydemo.jsoncovertpojo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author cuidi
 * @date 2023/3/8 15:42
 */
public class ArrayBrowser
{
    private String name;

    private String url;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public static ArrayBrowser fill(JSONObject jsonobj){
        ArrayBrowser entity = new ArrayBrowser();
        if (jsonobj.containsKey("name")) {
            entity.setName(jsonobj.getStr("name"));
        }
        if (jsonobj.containsKey("url")) {
            entity.setUrl(jsonobj.getStr("url"));
        }
        return entity;
    }
    public static List<ArrayBrowser> fillList(JSONArray jsonarray) {
        if (jsonarray == null || jsonarray.size() == 0)
            return null;
        List<ArrayBrowser> olist = new ArrayList<ArrayBrowser>();
        for (int i = 0; i < jsonarray.size(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}