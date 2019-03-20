package com.liyi.algorithm.design;


import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个LFU缓存（结构大致如下）
 * --------------
 *  0|0|0|0|
 * --------------
 *  | | | |
 * 1|1|1|2|
 * 2|3|2|2|
 */
public class LFUCache<K,V> {
    private Map<Integer,LFUNode> keys ;//某个key对应哪个Node
    private Map<LFUNode,LFUListed> listeds;//某个节点在哪条链上
    private int capacity;
    private LFUListed head;

    public LFUCache(int capacity) {
        if(capacity < 1){
            throw new RuntimeException("初始化大小至少为1");
        }
        this.capacity = capacity;
        keys = new HashMap<>();
        listeds = new HashMap<>();
    }

    public int get(int key) {
        if(keys.containsKey(key)){
            LFUNode node = keys.get(key);
            int temp = (Integer) node.value;
            LFUListed listed = listeds.get(node);
            //开始处理node和listed
            moveNodeToNewList(node,listed);
            return temp;
        }
        return -1;
    }

    //这里要做的事情
    // 1.删除oldList中的node节点
    // 2.判断删除完后 oldList是不是还有节点(有：不处理，没有：处理)
    // 3.判断是否含有node.fenquency的下一条节点，如果有，往链表底部加，如果没有新建
    private void moveNodeToNewList(LFUNode node,LFUListed oldList){
        node.frequency++;
        //删除节点
        oldList.delete(node);

    }

    //判断当前链是不是头链表
    private boolean nowListIsHead(LFUListed listed){
        if(listed.isEmpty()){//如果是空，那么当前的最大链（包含所有子链）可能需要换头
            if(this.head == listed){
                this.head = listed.next;
                if(this.head == null){
                    this.head.last = null;
                }
            }else{

            }
        }
        return false;
    }

    public void put(int key, int value) {

        return ;
    }
}

/**
 * 定义链表结构
 * 双向链表，因此有头尾节点
 */
class LFUListed{//每条链都有头部和尾部
    public LFUNode head;//每条链子的头节点
    public LFUNode tail;//每条链子的尾部节点
    public LFUListed next;//下一条条链子 比如当前链子频率为1，要给他转到频率为2的链子上去
    public LFUListed last;//最后一条链子

    public LFUListed(){
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    //删除一个节点，在删除完后，在其他方法中处理这个链表
    public void delete(LFUNode node){
        LFUNode up = node.up;
        LFUNode down = node.down;

        node.up = null;
        node.down = null;
        if(up == null && down == null){//node既是头也是尾
            node.up = null;
            node.down = null;
        }else if(up == null && down != null){//node是头不是尾
            this.head = down;
            this.head.up = null;
        }else if(up != null && down == null){//node是尾
            this.tail = up;
            up.down = null;
        }else{//node是中间元素
            up.down =  down;
            down.up = up;
        }
    }

}

/**
 * 定义泛型，适用于多种形式的数据
 */
class LFUNode<K,V>{
    public K key;
    public V value;
    public int frequency;
    public LFUNode up;//上
    public LFUNode down;//下
    public LFUNode(K key,V value){
        this.key = key;
        this.value = value;
    }
}