package com.liyi.algorithm.design;

/*
Consistent Hashing
一般的数据库进行horizontal shard的方法是指，把 id 对 数据库服务器总数 n 取模，然后来得到他在哪台机器上。这种方法的缺点是，当数据继续增加，我们需要增加数据库服务器，将 n 变为 n+1 时，几乎所有的数据都要移动，这就造成了不 consistent。为了减少这种 naive 的 hash方法(%n) 带来的缺陷，出现了一种新的hash算法：一致性哈希的算法——Consistent Hashing。这种算法有很多种实现方式，这里我们来实现一种简单的 Consistent Hashing。
将 id 对 360 取模，假如一开始有3台机器，那么让3台机器分别负责0~119, 120~239, 240~359 的三个部分。那么模出来是多少，查一下在哪个区间，就去哪台机器。
当机器从 n 台变为 n+1 台了以后，我们从n个区间中，找到最大的一个区间，然后一分为二，把一半给第n+1台机器。
比如从3台变4台的时候，我们找到了第3个区间0~119是当前最大的一个区间，那么我们把0~119分为0~59和60~119两个部分。0~59仍然给第1台机器，60~119给第4台机器。
然后接着从4台变5台，我们找到最大的区间是第3个区间120~239，一分为二之后，变为 120~179, 180~239。
假设一开始所有的数据都在一台机器上，请问加到第 n 台机器的时候，区间的分布情况和对应的机器编号分别是多少？
 Notice
你可以假设 n <= 360. 同时我们约定，当最大区间出现多个时，我们拆分编号较小的那台机器。
比如0~119， 120~239区间的大小都是120，但是前一台机器的编号是1，后一台机器的编号是2, 所以我们拆分0~119这个区间。
Clarification
If the maximal interval is [x, y], and it belongs to machine id z, when you add a new machine with id n, you should divide [x, y, z] into two intervals:
[x, (x + y) / 2, z] and [(x + y) / 2 + 1, y, n]
Example
for n = 1, return
[
  [0,359,1]
]
represent 0~359 belongs to machine 1.
for n = 2, return
[
  [0,179,1],
  [180,359,2]
]
for n = 3, return
[
  [0,89,1]
  [90,179,3],
  [180,359,2]
]
for n = 4, return
[
  [0,89,1],
  [90,179,3],
  [180,269,2],
  [270,359,4]
]
for n = 5, return
[
  [0,44,1],
  [45,89,5],
  [90,179,3],
  [180,269,2],
  [270,359,4]
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ConsistentHashing {

    public static void main(String[] args) {
        List<List<Integer>> my = myConsistentHashing(356);
        List<List<Integer>> other = consistentHashing(356);

        System.out.println("---------------------");
        boolean flag = true;
        for(int i=0;i<my.size();i++){
            List<Integer> myList = my.get(i);
            List<Integer> otherList = other.get(i);
            for(int j=0;j<3;j++){
                if(myList.get(j) != otherList.get(j).intValue()){
                    flag = !flag;
                    System.out.println(myList);
                    System.out.println(otherList);
                }
            }
        }
        System.out.println("finally result compare :" + flag);
    }

    //自己编写的程序
    public static List<List<Integer>> myConsistentHashing(int n){
        long startTime = System.currentTimeMillis();
        if(n == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int index1 = o1.get(1) - o1.get(0);
                int index2 = o2.get(1) - o2.get(0);
                if(index1 != index2){
                    return (index2 - index1);
                }else{
                    return o1.get(2) - o2.get(2);
                }
            }
        });
        for(int i=1;i<=n;i++){
            List<Integer> myHasing = new ArrayList<>();
            if(i == 1){
                myHasing.add(0);
                myHasing.add(359);
                myHasing.add(i);
                queue.add(myHasing);
                res.add(myHasing);
            }else{
                List<Integer> poll = queue.poll();
                int start = poll.get(0);
                int end = poll.get(1);
                if(end - start <= 0){
                    break;
                }

                poll.set(0,start);
                poll.set(1,(start+end) / 2);
                queue.add(poll);

                myHasing.add((start+end)/2 + 1);
                myHasing.add(end);
                myHasing.add(i);
                queue.add(myHasing);
                res.add(myHasing);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("MyHasing use time = " + (endTime - startTime));
        return res;
    }




    //已经通过测试的答案，用于自己写后对比
    public static List<List<Integer>> consistentHashing(int n) {
        long startTime = System.currentTimeMillis();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (n == 0) {
            return ret;
        }

        List<Integer> newMachine = new ArrayList<Integer>();
        newMachine.add(0);
        newMachine.add(359);
        newMachine.add(1);
        ret.add(newMachine);

        for (int i = 1; i < n; i++) {
            newMachine = new ArrayList<Integer>();
            int max = Integer.MIN_VALUE;
            List<Integer> target = ret.get(0);

            for (int j = 0; j < ret.size(); j++) {
                List<Integer> l = ret.get(j);
                if (l.get(1) - l.get(0) + 1 > max) {
                    max = l.get(1) - l.get(0) + 1;
                    target = l;
                }
            }

            if (max == 1) {
                long endTime = System.currentTimeMillis();
                System.out.println("otherHasing use time = " + (endTime - startTime));
                return ret;
            }


            newMachine.add((target.get(1) + target.get(0)) / 2 + 1);
            newMachine.add(target.get(1));
            newMachine.add(i + 1);
            target.set(1, (target.get(1) + target.get(0)) / 2);
            ret.add(newMachine);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("otherHasing use time = " + (endTime - startTime));
        return ret;
    }
}
