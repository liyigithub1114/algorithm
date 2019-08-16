package com.liyi.algorithm.list;

/**
 * nLogN的时间复杂度，O(1)空间复杂度，完成list排序
 */
public class SortList {
    public static void main(String[] args) {
            //Input: -1->5->3->4->0
            //Input: 4->2->1->3
    }

    //快慢指针找到中间节点
    public ListNode findMiddle(ListNode node){
        if(node == null){
            return node;
        }

        ListNode slow = node;
        ListNode fast = node.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //合并左右两个节点
    public ListNode merge(ListNode left, ListNode right){
        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        ListNode temp = new ListNode(0);
        ListNode res = temp;

        while(left != null && right != null){
            if(left.value <= right.value){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return res.next;
    }

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMiddle(head);

        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
        while (head != null) {
            if (head.value < mid.value) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.value > mid.value) {
                rightTail.next = head;
                rightTail = head;
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }

        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;

        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);

        return concat(left, middleDummy.next, right);

    }

    public ListNode concat(ListNode left, ListNode mid, ListNode right){
        ListNode res = new ListNode(0);
        ListNode tail = res;

        tail.next = left;
        tail = getTail(tail);

        tail.next = mid;
        tail = getTail(tail);

        tail.next = right;
        tail = getTail(tail);


        return res.next;
    }

    public ListNode getTail(ListNode node){
        if(node == null){
            return node;
        }

        while(node.next != null){
            node = node.next;
        }

        return node;
    }
}
