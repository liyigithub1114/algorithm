package com.liyi.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，链表的节点Node含有next和random 复制它
 */
public class CopyRandomNode {

    public static void main(String[] args) {
        Node head = new Node(-1);
        //head.next = new Node(2);
        //head.next.next = new Node(3);
        copy(head);
    }

    //1->2->3->null  1->1'->2->2'->3->3'->null
    public static Node copy(Node head){
        if(head == null) return null;
        Node node = head;
        Node next = null;
        Node temp = null;
        while(node != null){
            temp = new Node(node.val);
            next = node.next;
            node.next = temp;
            temp.next = next;
            node = next;
        }
        node = head;
        while(node != null){
            next = node.next;
            next.random = node.random == null ? null : node.random.next;
            node = next.next;
        }
        Node res = new Node(0);
        temp = res;
        node = head;
        while(node != null){
            next = node.next;
            temp.next = next;
            temp = temp.next;
            node.next = next.next;
            node = node.next;
        }
        return res.next;
    }

    //首先使用傻白甜的Map
    public static Node copyByMap(Node head){
        if(head == null) return null;
        Map<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
