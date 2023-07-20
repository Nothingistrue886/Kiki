package com.drools.entity;

import java.util.List;

/**
 * @author cuidi
 * @description 比较操作符实体
 * @date 2023/6/29 17:22
 */
public class ComparisonOperator {
    private String names;
    private List<String> list;
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
}