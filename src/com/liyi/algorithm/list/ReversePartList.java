package com.liyi.algorithm.list;

public class ReversePartList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next=new ListNode(6);

        ListNode res = reverseBetween(listNode,2, 3);
        while(res!=null){
            System.out.print( res.value+" ");
            res = res.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode node = head;
        int count = 0;
        ListNode pre = null;
        ListNode last = null;
        ListNode next = null;
        while(node != null){
            count++;
            if(count == m-1){
                pre = node;
                next = node.next;
            }
            if(count == n+1){
                last = node;
            }
            node = node.next;
        }
        if(m<1 || n>count || m>n) return head;
        next = pre == null? head:pre.next;
        ListNode res = reverse(next, last);
        if(pre != null){
            pre.next = res;
            return head;
        }
        return res;
    }
    //1-->2-->3--4
    public static ListNode reverse(ListNode node,ListNode last){
        if(node == null) return null;
        ListNode head = node;
        ListNode next = head.next;
        head.next = last;
        ListNode temp = null;
        while(next != last){
            temp = next.next;
            next.next = head;
            head = next;
            next =temp ;
        }
        return head;
    }
}
