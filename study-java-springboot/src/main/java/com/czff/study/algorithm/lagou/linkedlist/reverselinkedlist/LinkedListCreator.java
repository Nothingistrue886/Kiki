package com.czff.mydemo.algorithm.lagou.linkedlist.reverselinkedlist;


import java.util.List;

/**
 * @author 疾风劲草
 * @date 2020/6/14 17:56
 * @description
 */
public class LinkedListCreator {

    /** 构建函数 */
    public Node createLinkedList(List<Object> list) {
        if (list.isEmpty()) {
            return null;
        }
        Node head = new Node(list.get(0));
        List<Object> nodes = list.subList(1, list.size());
        Node node = createLinkedList(nodes);
        head.setNext(node);
        return head;
    }

    /** 测试方便的打印函数 */
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.getData());
            System.out.print(" ");
            node = node.getNext();
        }
        System.out.println();
    }
}
