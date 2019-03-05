package com.liyi.algorithm.tree;

import com.liyi.algorithm.list.ListNode;

/**
 * 将一个排好序的链表构建成BST搜索二叉树
 * LeetCode
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortListToBST {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        PrintTree.printTree(getBST(head));
    }

    //想法：通过快慢指针，每次拿到中间数，作为头部，然后递归 left和right
    public static Tree getBST(ListNode head){
        if(head == null) return null;

        if(head.next == null) return new Tree(head.value);

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        ListNode right = mid.next;
        //防止重复遍历，打断list
        slow.next = null;
        mid.next = null;

        Tree tree = new Tree(mid.value);
        tree.left = getBST(head);
        tree.right = getBST(right);

        return tree;
    }

}
