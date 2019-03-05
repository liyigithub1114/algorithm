package com.liyi.algorithm.list;

/**
 * nLogN的时间复杂度，O(1)空间复杂度，完成list排序
 */
public class SortList {
    public static void main(String[] args) {
            //Input: -1->5->3->4->0
            //Input: 4->2->1->3
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next  = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode res = sort(head);
        System.out.println(res);
    }

    public static ListNode sort(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sort(head);
        ListNode right = sort(mid);
        ListNode res = merge(left,right);
        return res;
    }


    public static ListNode merge(ListNode left ,ListNode right){
        if(left == null && right == null) return  null;
        if(right == null) return left;
        if(left == null) return right;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(left != null && right != null){
            if(left.value < right.value){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else if(left.value >= right.value){
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        if(left != null){
            temp.next = left;
        }
        if(right != null){
            temp.next = right;
        }
        return head.next;
    }
}
