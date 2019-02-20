package com.liyi.algorithm.list;

/**
 * intput:1->1->2->3->3->4
 * output:2->4
 */
public class RemoveDupFromSortList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        ListNode node = deleteListNode(head);
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
    }

    public static ListNode deleteListNode(ListNode head) {
        if (head == null) return head;
        ListNode node = head;
        ListNode res = null;
        ListNode resTail = null;
        boolean flag = false;//第一个假设不是重复的
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (next != null && node.value == next.value) {
                flag = true;
            } else {
                if (flag) {
                    //node有重复
                    flag = false;
                } else {
                    //node无重复
                    if (res == null) {
                        res = node;
                        resTail = node;
                    } else {
                        resTail.next = node;
                        resTail = node;
                    }
                }
            }
            node = next;
        }
        return res;
    }
}
