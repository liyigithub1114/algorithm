package com.liyi.algorithm.list;

/***
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class ReOrderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        reOrder(head);
        System.out.println();
    }

    public static ListNode reOrder(ListNode head){
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        slow = reverse(next);
        head = merge(head,slow);
        return head;
    }

    public static ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode node= head;
        ListNode next = node.next;
        ListNode temp = null;
        node.next = null;
        while(next != null){
            temp = next.next;
            next.next = node;
            node = next;
            next = temp;
        }
        return node;
    }

    public static ListNode merge(ListNode odd,ListNode even){
        ListNode head = new ListNode(0);
        ListNode node = head;
        boolean flag = true;
        while(odd != null && even != null){
            if(flag){
                node.next = odd;
                odd = odd.next;
                node = node.next;
                flag = !flag;
            }else{
                node.next = even;
                even = even.next;
                node = node.next;
                flag = !flag;
            }
        }
        while( odd!=null ){
            node.next = odd;
            odd = odd.next;
            node = node.next;
        }
        while(even != null){
            node.next = even;
            even = even.next;
            node = node.next;
        }
        return head.next;
    }
}
