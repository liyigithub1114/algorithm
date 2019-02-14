package com.liyi.algorithm.list;

/**
 *  将一个链表，每K组之间反转
 *
 *  1-->2-->3-->4-->5
 *  2-->1-->4-->3-->5
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        //m=1+k  n=k+k;
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        //listNode.next.next.next.next.next=new ListNode(6);
        int k = 3;

        int count = 0;
        ListNode node = listNode;
        while(node!=null){
            count++;
            node = node.next;
        }
        int m = 1;
        int n = k;

        ListNode res = listNode;
        while(m < count && n <= count){
            res = reverse(res,m,n);
            m+=k;
            n+=k;
        }

        while(res!=null){
            System.out.print( res.value+" ");
            res = res.next;
        }
    }

    public static ListNode reverse(ListNode head,int m ,int n){
        if(head == null) return head;
        int count =0;
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode tail = null;
        while(node != null){
            count++;
            if(count == m-1){
                pre = node;
            }
            if(count == n+1){
                tail = node;
            }
            node = node.next;
        }
        if(m < 1 || n > count || m > n) return head;
        next = pre == null ? head:pre.next;
        ListNode listNode = reversePart(next, tail);
        if(pre != null){
            pre.next = listNode;
            return head;
        }
        return listNode;
    }

    // 1-->4  2-->3-->4
    public static ListNode reversePart(ListNode head,ListNode last){
        if(head == null) return head;
        ListNode node = head;
        ListNode next = node.next;
        ListNode temp = null;
        node.next = last;
        while(next != last){
            temp = next.next;
            next.next = node;
            node = next;
            next = temp;
        }
        return node;
    }

}
