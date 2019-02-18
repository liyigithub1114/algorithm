package com.liyi.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{3,2,1}));
        //[10,9,8,7,6,5,4,3,2,1,1,0]

    }

    public static int jump(int[] nums){
        if(nums == null && nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        int res = 0;
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i =0;i<len;){
            if(queue.isEmpty()){
                res++;
                int temp = nums[i];
                int jump = nums[i];
                if(i + jump >= len-1){
                    break;
                }
                while(jump > 0){
                    queue.add(nums[i + jump--]);
                }
                while(queue.peek() != nums[i + temp]){
                    temp--;
                }
                i = i+temp;
            }else{
                if(i >= len-1) break;
                int temp = queue.poll();
                int jump = temp;
                res ++;
                if(i + jump >= len -1) break;
                while(jump > 0){
                    queue.add(nums[i + jump--]);
                }
                while(queue.peek() != nums[i + temp]){
                    temp--;
                }
                i = i + temp;
            }
        }

        return res;

    }
}
