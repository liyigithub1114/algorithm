package com.liyi.algorithm.list;

/**
 * 给定一个链表和值val
 * 链表上的值小于x放左边，大于x放右边 ，链表中各元素保持不变
 *
 * 1->4->3->2->5->2  3
 *
 * 1->2->2->4->3->5
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);

        get(head,0);
    }

    public static ListNode get(ListNode head ,int x){
        if(head == null) return head;
        ListNode node = head;
        ListNode next = null;
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;
        while(node != null){
            next = node.next;
            node.next = null;//删除关联
            if(node.value < x){
                if(lessHead == null){
                    lessHead = node;
                    lessTail = node;
                }else{
                    lessTail.next = node;
                    lessTail = node;
                }
            }else{
                if(moreHead == null){
                    moreHead = node;
                    moreTail = node;
                }else{
                    moreTail.next = node;
                    moreTail = node;
                }
            }
            node =next;
        }
        if(lessTail != null){
            lessTail.next = moreHead;
        }
        return lessHead == null ? moreHead : lessHead;
    }
}
