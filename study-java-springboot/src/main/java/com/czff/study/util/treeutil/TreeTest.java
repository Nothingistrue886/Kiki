package com.czff.study.util.treeutil;

import cn.hutool.json.JSONUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cuidi
 * @description Stream流递归实现遍历树形结构
 * @date 2023/1/30 14:40
 */
public class TreeTest {

    public static void main(String[] args) {

        // Stream流递归实现遍历树形结构
        List<TreeBean> treeBeanList = new TreeBean().initializationData();
        List<TreeBean> collect = treeBeanList.stream()
                .filter(treeBean -> treeBean.getParentId() == 0)
                .peek(map -> map.setChildList(getChildren(map, treeBeanList)))
//                .sorted(Comparator.comparing(TreeBean::getSort))
                .sorted(Comparator.comparing(TreeBean::getSort).reversed())
                .collect(Collectors.toList());
        System.out.println(JSONUtil.toJsonStr(collect));
    }

    /**
     * 递归查询子节点
     */
    public static List<TreeBean> getChildren(TreeBean root, List<TreeBean> all) {
        return all.stream()
                .filter(treeBean -> treeBean.getParentId().equals(root.getId()))
                .peek(map -> map.setChildList(getChildren(map, all)))
                .collect(Collectors.toList());
    }

}
