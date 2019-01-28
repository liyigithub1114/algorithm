package com.liyi.algorithm.integer;

import java.util.LinkedList;

public class WindowSlidLtNum {
    //一个数组的子数组，最大值减去最小值是否小于num
    public static void main(String[] args) {

    }

    public static void slide(Integer[] nums,int num){
        if(nums == null || nums.length < 0)  return;

        LinkedList<Integer> maxLinked = new LinkedList<>();
        LinkedList<Integer> minLinked = new LinkedList<>();

        int res = 0;
        int L = 0;
        int R = 0;
        while(L<nums.length){
            while(R<nums.length){
                while(!maxLinked.isEmpty() && nums[maxLinked.peekLast()] <= nums[R]){
                    maxLinked.pollLast();
                }
                maxLinked.add(R);

                while(!minLinked.isEmpty() && nums[minLinked.peekLast()] >= nums[R]){
                    minLinked.pollLast();
                }
                minLinked.add(R);

                if(nums[maxLinked.peekFirst()] - nums[minLinked.peekFirst()] > num){
                    break;
                }
                R++;
            }
            if(L == maxLinked.peekFirst()){
                maxLinked.pollFirst();
            }
            if(L == minLinked.peekFirst()){
                minLinked.pollFirst();
            }
            res += R-L;
            L++;
        }
    }
}
