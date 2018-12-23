package com.liyi.algorithm.list;

public class PalindromicListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
       head.next.next.next.next.next = new ListNode(1);

        boolean isPalindromic = isPalindromic(head);
        System.out.println(isPalindromic);
    }

    public static boolean isPalindromic(ListNode head){
        if(head == null) return true;

        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode.next !=null && fastNode.next.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        //mid reverse
        fastNode = slowNode.next;
        slowNode.next = null;
        ListNode temp = null;
        while(fastNode != null){
            temp = fastNode.next;
            fastNode.next = slowNode;
            slowNode = fastNode;
            fastNode = temp;
        }
        fastNode = head;
        temp = slowNode;
        while(temp != null && fastNode!=null){
            if(temp.value == fastNode.value){
                temp = temp.next;
                fastNode = fastNode.next;
            }else{
                return false;
            }
        }
        fastNode = slowNode.next;
        slowNode.next = null;
        while(fastNode!=null){
            temp = fastNode.next;
            fastNode.next = slowNode;
            slowNode = fastNode;
            fastNode = temp;
        }

        return true;
    }
}
