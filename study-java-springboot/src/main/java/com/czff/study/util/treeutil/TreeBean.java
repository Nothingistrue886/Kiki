package com.czff.study.util.treeutil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuidi
 * @description Recursive implementation of treeutil structure
 * @date 2023/1/30 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeBean {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父id ，根节点为0
     */
    private Integer parentId;

    /**
     * 序号
     */
    private Integer sort;

    /**
     * 子节点信息
     */
    private List<TreeBean> childList;

    /**
     * 初始化数据
     *
     * @return
     */
    public List<TreeBean> initializationData() {
        List<TreeBean> list = new ArrayList<>();
        TreeBean t1 = new TreeBean(1, "广东省", 0, 1, new ArrayList<>());
        TreeBean t2 = new TreeBean(2, "湖南省", 0, 0, new ArrayList<>());
        TreeBean t3 = new TreeBean(3, "广州市", 1, 1, new ArrayList<>());
        TreeBean t4 = new TreeBean(4, "长沙市", 2, 1, new ArrayList<>());
        TreeBean t5 = new TreeBean(5, "白云区", 3, 1, new ArrayList<>());
        TreeBean t6 = new TreeBean(6, "黄浦区", 3, 1, new ArrayList<>());
        TreeBean t7 = new TreeBean(7, "白云街道", 5, 1, new ArrayList<>());
        TreeBean t8 = new TreeBean(8, "深圳市", 1, 1, new ArrayList<>());
        TreeBean t9 = new TreeBean(9, "宝安区", 8, 1, new ArrayList<>());
        TreeBean t10 = new TreeBean(10, "福田区", 8, 1, new ArrayList<>());
        TreeBean t11 = new TreeBean(11, "南山区", 8, 1, new ArrayList<>());
        TreeBean t12 = new TreeBean(12, "南山街道", 11, 1, new ArrayList<>());
        TreeBean t13 = new TreeBean(13, "芙蓉区", 4, 1, new ArrayList<>());
        TreeBean t14 = new TreeBean(14, "岳麓区", 4, 1, new ArrayList<>());
        TreeBean t15 = new TreeBean(15, "开福区", 4, 1, new ArrayList<>());
        TreeBean t16 = new TreeBean(16, "岳阳市", 2, 1, new ArrayList<>());
        TreeBean t17 = new TreeBean(17, "岳麓街道", 14, 1, new ArrayList<>());
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t7);
        list.add(t8);
        list.add(t9);
        list.add(t10);
        list.add(t11);
        list.add(t12);
        list.add(t13);
        list.add(t14);
        list.add(t15);
        list.add(t16);
        list.add(t17);
        return list;
    }


}
