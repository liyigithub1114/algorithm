package com.liyi.algorithm.list;

public class ReverseListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode reverse = reverse(head);

        System.out.println();
    }


    //1-->2-->3
    //null<--1 2-->3
    public static ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode node = head;
        ListNode next = node.next;
        node.next = null;
        ListNode temp = null;
        while(next!=null){
            temp = next.next;
            next.next = node;
            node = next;
            next = temp;
        }
        return node;
    }
}
