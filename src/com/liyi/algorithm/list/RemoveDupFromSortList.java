package com.liyi.algorithm.list;

public class RemoveDupFromSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        get(head);
    }
    public static ListNode get(ListNode head){
        if(head == null) return head;
        ListNode node = head;
        while(node != null){
            ListNode next = node.next;
            while(next != null && node.value == next.value){
                next = next.next;
            }
            node.next = next;
            node = next;
        }
        return head;
    }
}
