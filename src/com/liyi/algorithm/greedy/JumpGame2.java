package com.liyi.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组 ，可以假定它每次从0开始都可以跳到最后一个位置，求它最少跳几次可以达到最后一个位置
 *
 * [2,3,1,1,4] 从 0位置开始，arr[i] 表示以跳跃的长度，比如 arr[0] 可以选择跳1步或者跳2步
 * 跳一步，到3，跳3步，到最后一个位置，最少只需跳两步
 *
 * LeetCode JumpGame2
 *
 * 解题思路，首先看nums.length 是否大于2，大于2 ，整明至少要走一步， =0 不用走 ；=1 走一步
 * 1.获取nums[0] 的下标和值，判断下一次跳到最远的位置是多少，比如 nums[0] = 10 ，第一次跳最多跳到 index = 0+10的位置
 * 一次遍历中途可能经过的index 即 0 --> 10,用优先队列记录下来他们的下标和值
 * 2.判断第一次应该跳在哪个位置，把队列中的值拿出来一次判断，如 Jump jump = queue.poll();
 * 看取出来的值依次最远能跳到什么位置，取出其中能跳到最远位置的index 和 value继续循环
 */
public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(getCount(new int[]{1,2,3}));
        //                                    10,11,8,7,6,5,4,3,2,1,[1],1,(1)
    }
    public static int getCount(int[] nums){
        if(nums == null || nums.length ==0) return 0;
        if(nums.length == 1) return 0;
        int len = nums.length;
        int res = 0;
        PriorityQueue<Jump2> priorityQueue = new PriorityQueue<>(new Comparator<Jump2>() {
            @Override
            public int compare(Jump2 o1, Jump2 o2) {
                return o2.value-o1.value;
            }
        });
        int index = 0;
        int value = nums[0];
        while(index < len -1){
            res++;
            if(index + value >= len -1) break;
            int maxIndex = index + value;
            while(value > 0){
                priorityQueue.add(new Jump2(index+value,nums[index + value--]));
            }
            int tempIndex = 0;//记录跳最多时的下标
            int tempValue = 0;//记录跳最多时的值
            while(!priorityQueue.isEmpty()){
                Jump2 temp = priorityQueue.poll();
                index = temp.index;
                value = temp.value;
                if(maxIndex < index +value){
                    maxIndex = index + value;
                    tempIndex = index;
                    tempValue = value;
                }
            }
            index = tempIndex;
            value = tempValue;
        }
        return res;
    }


    /**
     * 更快的贪心
     */
    private int s2(int[] nums) {
        int step = 0;
        int curMax = 0;
        int index = 0;

        while (curMax < nums.length - 1) {
            step++;
            int tmp = curMax;
            while (index <= tmp) {
                curMax = Math.max(curMax, index + nums[index]);
                index++;
            }
        }
        return step;
    }
}
class Jump2{
    public int index;
    public int value;
    public Jump2(int index,int value){
        this.index = index;
        this.value = value;
    }
}