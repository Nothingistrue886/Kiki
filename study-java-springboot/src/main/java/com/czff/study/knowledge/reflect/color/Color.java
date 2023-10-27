package com.czff.study.knowledge.reflect.color;

import java.util.List;

/**
 * @author cuidi
 * @date 2021/4/14 10:39
 * @description TODO
 */
public class Color {

    private String name;

    private List<Red> redList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Red> getRedList() {
        return redList;
    }

    public void setRedList(List<Red> redList) {
        this.redList = redList;
    }
}
