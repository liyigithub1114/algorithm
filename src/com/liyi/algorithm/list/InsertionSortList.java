package com.liyi.algorithm.list;

/**
 * 对链表进行插入排序
 */
public class InsertionSortList {
    public static void main(String[] args) {
        //6 5 3 1 8 7 2 4
        ListNode head = new ListNode(6);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(4);
        ListNode listNode = insertionSort(head);
        System.out.println();
    }

    public static ListNode insertionSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node = head;
        ListNode next = null;
        while(node.next != null){
            next = node.next;
            if(next.value >= node.value){
                node = next;
                continue;
            }
            node.next = next.next;//打断，把n隔离出来
            if(next.value <= head.value){//如果n比头节点小，直接指向头节点
                next.next = head;
                head = next;
                continue;
            }
            ListNode temp = head;//此时temp是一个有序链表，将n插入到一个有序链表中,并且因为n不可能是头节点
            while(temp.next != null && next.value > temp.next.value) temp = temp.next;
            next.next = temp.next;
            temp.next = next;
        }
        return head;
    }
}
