package com.czff.mydemo.jsoncovertpojo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author cuidi
 * @date 2023/3/8 15:41
 */
public class Address
{
    private String city;

    private String country;

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public static Address fill(JSONObject jsonobj){
        Address entity = new Address();
        if (jsonobj.containsKey("city")) {
            entity.setCity(jsonobj.getStr("city"));
        }
        if (jsonobj.containsKey("country")) {
            entity.setCountry(jsonobj.getStr("country"));
        }
        return entity;
    }
    public static List<Address> fillList(JSONArray jsonarray) {
        if (jsonarray == null || jsonarray.size() == 0)
            return null;
        List<Address> olist = new ArrayList<Address>();
        for (int i = 0; i < jsonarray.size(); i++) {
            olist.add(fill(jsonarray.getJSONObject(i)));
        }
        return olist;
    }
}
