package com.liyi.algorithm.design;


import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个LRU缓存
 */
public class LRUCache {
    private Map<Integer,LRUNode> map;
    private LRULinked linked;
    private int capacity = -1;

    public LRUCache(int capacity) {
        if(capacity < 1){
            throw new RuntimeException("初始化容量0？搞笑呢");
        }
        map = new HashMap<>();
        linked = new LRULinked();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(this.map.containsKey(key)){
            LRUNode temp = this.map.get(key);
            int res = (int)temp.vaule;
            this.linked.removeToTail(temp);
            return res;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            LRUNode temp = this.map.get(key);
            temp.vaule = value;
            this.linked.removeToTail(temp);
        }else{//不包含key
            LRUNode temp = new LRUNode(key,value);
            this.map.put(key,temp);
            this.linked.addNode(temp);
            if(this.map.size() == this.capacity + 1){//如果新加入一个 超过了容量，移除头部
                LRUNode node = this.linked.removeHead();//链表中移除后，再从map中移除
                this.map.remove(node.key);
            }
        }
    }
}
//定义一个链表节点
class LRUNode<K,V>{
    K key;
    V vaule;
    LRUNode<K,V> pre ;
    LRUNode<K,V> next;

    public LRUNode(K key,V value){
        this.key = key;
        this.vaule = value;
    }
}
//定义一个双向链表结构 ，里面有三个方法 ，1.加入一个新节点  2.移除一个节点  3.将某个节点放入尾部
class LRULinked{
    private LRUNode head;
    private LRUNode tail;

    public LRULinked(){
        this.head = null;
        this.tail = null;
    }

    //增加操作，应该注意的点 1.假如加入节点是空 2.假如加入节点时链表为空 3.假如加入节点时链表不为空
    public void addNode(LRUNode temp){
        if(temp == null) return;
        if(this.head == null){
            this.head = temp;
            this.tail = temp;
            temp.pre = null;
            temp.next = null;
        }else {
            this.tail.next = temp;
            temp.pre = this.tail;
            this.tail = temp;
        }
    }

    //移除头部节点，当容量到达时，移除最久没有被使用的节点，并且返回
    public LRUNode removeHead(){
        if(this.head == null){
            return null;
        }else if(this.head == this.tail){
            LRUNode temp = this.head;
            this.head = null;
            this.tail = null;
            return temp;
        }else{
            LRUNode temp = this.head;
            LRUNode next = this.head.next;
            next.pre = null;
            this.head = next;
            return temp;
        }
    }

    //假如调用了一次get方法，就变成了最近经常使用，要移到尾部，同样保证进来的时候一定存在于链表当中
    public LRUNode removeToTail(LRUNode temp){
        if(temp == null) return  null;
        if(this.head == this.tail){//头等于尾，他又存在于链表中，根本不用动
            return temp;
        }else if(this.head == temp){//头等于temp ,头就应该下移一位，尾部连上temp
            LRUNode next = this.head.next;
            this.head = next;
            next.pre = null;
            this.tail.next = temp;
            temp.pre = this.tail;
            this.tail = temp;
            return temp;
        }else if(this.tail == temp){//尾部等于temp,不用动
            return temp;
        }else{//中间节点
            LRUNode pre = temp.pre;
            LRUNode next = temp.next;
            pre.next = next;
            next.pre = pre;
            this.tail.next = temp;
            temp.pre = this.tail;
            this.tail = temp;
            return temp;
        }
    }
}