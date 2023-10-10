package com.czff.mydemo.algorithm.lagou.linkedlist.linkedlisthascyc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 疾风劲草
 * @date 2022/6/27 21:39
 * @description 链表是否有环
 */
public class LinkedListHasCycle {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        boolean b = hasCycle1(listNode1);
        System.out.println(b);
    }

    /**
     * 哈希表
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> setNode = new HashSet<ListNode>();
        while (head != null) {
            if (!setNode.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针1
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 快慢指针2
     * @param head
     * @return
     */
    public static boolean hasCycle3(ListNode head) {
        ListNode s = head, f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f) return true;
        }
        return false;
    }
}
