package com.liyi.algorithm.list;


public class MergeKSortList {
    //Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{listNode1,listNode2,listNode3};
        ListNode res = null;
        for(int i = 0;i<listNodes.length;i++){
            res = getRes(res,listNodes[i]);
        }
        printListNode(res);
    }

    public static ListNode getRes(ListNode node1,ListNode node2){
        if(node1  == null && node2 == null) return null;
        if(node1 != null && node2 == null) return node1;
        if(node1 == null && node2 != null) return node2;
        ListNode res = new ListNode(0);
        ListNode res1 = res;
        ListNode head1 = node1;
        ListNode head2 = node2;
        while(head1 != null && head2 != null){
            if(head1.value > head2.value){
                res1.next = new ListNode(head2.value);
                head2 = head2.next;
            }else{
                res1.next = new ListNode(head1.value);
                head1 = head1.next;
            }
            res1 = res1.next;
        }
        res1.next = head1 == null?head2:head1;
        return res.next;
    }

    public static void printListNode(ListNode node){
        if(node == null) return;
        while(node!=null){
            System.out.print(node.value+"-->");
            node = node.next;
        }
        System.out.print("null");
    }
}
