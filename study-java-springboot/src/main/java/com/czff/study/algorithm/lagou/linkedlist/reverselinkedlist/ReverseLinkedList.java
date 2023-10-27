package com.czff.study.algorithm.lagou.linkedlist.reverselinkedlist;


/**
 * @author 疾风劲草
 * @date 2020/6/14 17:16
 * @description 链表反转
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
//        LinkedListCreator linkedListCreator = new LinkedListCreator();
//        Node node = linkedListCreator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
//        linkedListCreator.printList(reverseNode(node));


        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
        // 调用反转方法
        head = reverseNode(head);
        System.out.println("\n**************************");
        // 打印反转后的结果
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    /**
     * 遍历反转法:
     * 从前往后反转各个结点的指针域的指向
     *
     * @param head
     * @return Node
     */
    public static Node reverseNode(Node head) {
        /** 单链表为空或只有一个节点，直接返回原单链表 */
        if (head == null || head.getNext() == null) {
            return head;
        }
        /** 前一个节点指针 */
        Node preNode = null;
        /** 当前节点指针 */
        Node curNode = head;
        /** 下一个节点指针 */
        Node nextNode = null;

        while (curNode != null) {
            /** nextNode 指向下一个节点 */
            nextNode = curNode.getNext();
            /** 将当前节点next域指向前一个节点 */
            curNode.setNext(preNode);
            /** preNode 指针向后移动 */
            preNode = curNode;
            /** curNode指针向后移动 */
            curNode = nextNode;
        }
        return preNode;
    }
}
