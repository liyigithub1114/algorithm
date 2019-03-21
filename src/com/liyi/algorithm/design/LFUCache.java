package com.liyi.algorithm.design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer,LFUNode> keys;
    Map<LFUNode,LFUList> lists;
    LFUList headList;
    int capacity;
    int size;

    public LFUCache(int capacity){
        if(capacity < 0){
            throw new RuntimeException("初始容量麻烦让他有点意义好嘛");
        }
        this.capacity = capacity;
        size = 0;
        headList = null;
        keys = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if(keys.containsKey(key)){
            LFUNode node = keys.get(key);
            int value = (Integer)node.value;
            node.frequency++;
            LFUList oldList = lists.get(node);
            moveNodeToHighFrequency(node,oldList);
            return value;
        }
        return -1;
    }

    private void moveNodeToHighFrequency(LFUNode node ,LFUList oldList){
        oldList.delete(node);
        //判断老链表移除元素后时候是否还有元素
        // 如果含有元素(返回false)，此时获得当前链表(用于node寻找下一个list)
        // 如果不含有元素(返回true，代表换头了)
        LFUList preList = isGenerateNewHead(oldList) ? oldList.pre : oldList;
        LFUList next = oldList.next;
        if (next == null) {
            LFUList newList = new LFUList(node);
            if (preList != null) {
                preList.next = newList;
            }
            newList.pre = preList;
            if (headList == null) {
                this.headList = newList;
            }
            lists.put(node, newList);
        } else {
            if (next.head.frequency == node.frequency) {
                next.addNodeToTail(node);
                lists.put(node, next);
            } else {
                LFUList newList = new LFUList(node);
                if (preList != null) {
                    preList.next = newList;
                }
                newList.pre = preList;
                newList.next = next;
                next.pre = newList;
                if (headList == next) {
                    headList = newList;
                }
                lists.put(node, newList);
            }
        }
    }

    //是否生成新的头
    private boolean isGenerateNewHead(LFUList list){
        if(list.isEmpty()){
            if(this.headList == list){
                this.headList = list.next;
                if(this.headList != null){
                    this.headList.pre = null;
                }
            }else{
                //不是头，一定有pre
                list.pre.next = list.next;
                if(list.next != null){
                    list.next.pre = list.pre;
                }
            }
            return true;
        }
        return false;
    }

    public void put(int key, int value) {
        if(keys.containsKey(key)){
            LFUNode node = keys.get(key);
            LFUList list = lists.get(node);
            node.value = value;
            node.frequency++;
            moveNodeToHighFrequency(node,list);
        }else{
            if(size == capacity){
                //移除头链表的第一个元素
                if(capacity == 0){
                    return;
                }
                LFUNode node = this.headList.head;
                this.headList.delete(node);
                isGenerateNewHead(this.headList);
                //消除影响
                keys.remove(node.key);
                lists.remove(node);
                size--;
            }
            LFUNode node = new LFUNode(key,value);
            node.frequency++;
            if(this.headList == null){
                this.headList = new LFUList(node);
            }else{
                if(this.headList.head.frequency == 1){
                    headList.addNodeToTail(node);
                }else{
                    LFUList list = new LFUList(node);
                    list.next = this.headList;
                    this.headList.pre = list;
                    this.headList = list;
                }
            }
            keys.put(key,node);
            lists.put(node,headList);
            size++;
        }
    }
}

class LFUList{
    public LFUNode head;
    public LFUNode tail;
    public LFUList pre;
    public LFUList next;

    //每次创建List必须要有一个节点
    public LFUList(LFUNode node){
        this.head = node;
        this.tail = node;
    }

    //删除一个节点
    public void delete(LFUNode node){
        if(node == null) return;
        LFUNode up = node.up;
        LFUNode down = node.down;
        if(up == null && down==null){
            //上一个和下一个分别为Null,即只有一个节点，就是头=尾 只有一个元素
            this.head = null;
            this.tail = null;
        }else if(up != null && down != null){
            //中间节点
            up.down = down;
            down.up = up;
        }else if(up != null && down == null){
            //上一个不为空，下一个为空，就是尾节点
            this.tail  = up;
            up.down = null;
        }else if(up == null && down != null){
            //上一个为空，下一个不为空，就是头
            this.head  = down;
            down.up = null;
        }
        node.up = null;
        node.down = null;
    }

    //增加一个节点
    public void addNodeToTail(LFUNode node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.down = node;
            node.up = this.tail;
            this.tail = node;
        }
    }

    public boolean isEmpty(){
        return this.head == null;
    }
}

class LFUNode<K,V>{

    public K key;
    public V value;
    public int frequency;
    public LFUNode up;
    public LFUNode down;

    public LFUNode(K key,V value) {
        this.key = key;
        this.value = value;
    }
}