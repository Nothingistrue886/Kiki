package com.czff.mydemo.jsoncovertpojo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author cuidi
 * @date 2023/3/8 15:43
 */
public class Root
{
    private String name;

    private String url;

    private Address address;

    private List<ArrayBrowser> arrayBrowser;

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
    public void setAddress(Address address){
        this.address = address;
    }
    public Address getAddress(){
        return this.address;
    }
    public void setArrayBrowser(List<ArrayBrowser> arrayBrowser){
        this.arrayBrowser = arrayBrowser;
    }
    public List<ArrayBrowser> getArrayBrowser(){
        return this.arrayBrowser;
    }
    public static Root fill(JSONObject jsonobj){
        Root entity = new Root();
        if (jsonobj.containsKey("name")) {
            entity.setName(jsonobj.getStr("name"));
        }
        if (jsonobj.containsKey("url")) {
            entity.setUrl(jsonobj.getStr("url"));
        }
        if (jsonobj.containsKey("address")) {
            entity.setAddress((Address) jsonobj.getObj("address"));
        }
        if (jsonobj.containsKey("arrayBrowser")) {
            JSONArray arrayBrowser = jsonobj.getJSONArray("arrayBrowser");
            List<ArrayBrowser> arrayBrowserList = arrayBrowser.toList(ArrayBrowser.class);
            entity.setArrayBrowser(arrayBrowserList);
        }
        return entity;
    }
    public static List<Root> fillList(JSONArray jsonarray) {
        if (jsonarray == null || jsonarray.size() == 0)
            return null;
        List<Root> olist = new ArrayList<Root>();
        for (int i = 0; i < jsonarray.size(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}
