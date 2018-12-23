package com.liyi.algorithm.list;

public class TwoListNodeInterSection {
    public static void main(String[] args) {
        ListNode testHasRing = new ListNode(1);
        testHasRing.next = new ListNode(2);
        testHasRing.next.next = new ListNode(3);
        testHasRing.next.next.next = new ListNode(4);
        testHasRing.next.next.next.next = testHasRing.next;

        System.out.println(hasRing(testHasRing).value);

        ListNode Q2_1 = new ListNode(1);
        Q2_1.next = new ListNode(2);
        Q2_1.next.next = new ListNode(3);
        Q2_1.next.next.next = new ListNode(4);

        ListNode Q2_2 = new ListNode(2);
        Q2_2.next = new ListNode(3);
        Q2_2.next.next = Q2_1.next.next.next;

        isEqualNoRing(Q2_1,Q2_2);

        ListNode Q3_1 = new ListNode(1);
        Q3_1.next = new ListNode(2);
        Q3_1.next.next = new ListNode(3);
        Q3_1.next.next.next = new ListNode(4);
        Q3_1.next.next.next.next = Q3_1.next;

        ListNode Q3_2 = new ListNode(3);
        Q3_2.next = new ListNode(4);
        Q3_2.next.next = Q3_1.next;

        ListNode equalhasRing = isEqualhasRing(Q3_1, Q3_2);

        System.out.println(equalhasRing.value);

        ListNode Q3_3 = new ListNode(1);
        Q3_3.next = new ListNode(2);
        Q3_3.next.next = new ListNode(3);
        Q3_3.next.next.next = new ListNode(4);
        Q3_3.next.next.next.next = Q3_3.next;

        ListNode Q3_4 = new ListNode(3);
        Q3_4.next = Q3_3.next.next.next;

        ListNode equalhasRing2 = isEqualhasRing(Q3_3, Q3_4);
        System.out.println(equalhasRing2.value);

    }

    //第一个问题，判断一个链表是否有环，有环，返回第一个环节点

    public static ListNode hasRing(ListNode head){
        if(head == null) return null;
        ListNode fastListNode = head;
        ListNode slowListNode = head;
        while(fastListNode.next != null && fastListNode.next.next != null){
            fastListNode = fastListNode.next.next;
            slowListNode = slowListNode.next;
            if(fastListNode == slowListNode){
                fastListNode = head;
                while(fastListNode != slowListNode){
                    fastListNode = fastListNode.next;
                    slowListNode = slowListNode.next;
                }
                return fastListNode;
            }
        }
        return null;
    }
    //第二个问题      Q2:无环和有环一定不相交，都无环的情况，判断最后一个节点是否相等
    public static ListNode isEqualNoRing(ListNode node1 ,ListNode node2){
        if(node1 !=null && node2!= null){
            //尾部相等，看谁长，长的先走，走到长度与短的相等的时候一起走
            int count = 0;
            ListNode temp1 = node1;
            ListNode temp2 = node2;
            while(temp1.next!=null){
                count++;
                temp1 = temp1.next;
            }

            while(temp2.next!=null){
                count--;
                temp2 = temp2.next;
            }

            if(temp1 != temp2){
                return null;
            }

            temp1 = count > 0 ? node1 : node2;
            temp2 = temp1 == node1 ? node2 : node1;
            count = Math.abs(count);
            while(count > 0){
                temp1 = temp1.next;
                count--;
            }
            while(temp1!=temp2){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
        return null;
    }

    public static ListNode isEqualhasRing(ListNode node1,ListNode node2){
        ListNode has1 = hasRing(node1);
        ListNode has2 = hasRing(node2);

        if(has1 != null && has2 != null && has1==has2){
            //相交
            ListNode temp1 = node1;
            ListNode temp2 = node2;

            int count = 0;
            while(temp1.next !=has1){
                count++;
                temp1 = temp1.next;
            }

            while(temp2.next !=has2){
                count--;
                temp2 = temp2.next;
            }

            temp1 = count > 0 ? node1 : node2;
            temp2 = temp1 == node1 ? node2 : node1;

            count = Math.abs(count);
            while(count>0){
                count--;
                temp1 = temp1.next;
            }

            while(temp1!=temp2){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            return temp1;
        }else{
            //判断是否类似于二叉树结构
            ListNode temp1 = has1;
            ListNode temp2 = has2;
            while(temp1!=has2 ){
                temp1 = temp1.next;
                if(temp1 == has1){
                    return null;
                }
            }
            return temp1;
        }
    }
}
