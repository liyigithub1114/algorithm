package com.liyi.algorithm.tree;

import com.liyi.algorithm.list.ListNode;

public class SortArrToBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        PrintTree.printTree(getBST(new int[]{-10,-3,0,5,10,6},0,5));
    }

    public static Tree getBST(int[] arr,int L,int R){
        if(arr == null || arr.length == 0) return null;
        if(L<R){
            int mid = L + ((R-L) >> 1);
            Tree tree = new Tree(arr[mid]);
            tree.left = getBST(arr,L,mid-1);
            tree.right = getBST(arr,mid+1,R);
            return tree;
        }else if(L == R ){
            return new Tree(arr[L]);
        }
        return  null;
    }
}
