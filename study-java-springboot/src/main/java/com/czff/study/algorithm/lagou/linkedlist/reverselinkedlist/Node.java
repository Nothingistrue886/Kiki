package com.czff.study.algorithm.lagou.linkedlist.reverselinkedlist;

/**
 * @author 疾风劲草
 * @date 2020/6/14 17:07
 * @description 节点
 */
public class Node {
    /**
     * 数据域
     */
    private Object data;
    /**
     * 指针域
     */
    private Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
