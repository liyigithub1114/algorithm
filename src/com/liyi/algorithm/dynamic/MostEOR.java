package com.liyi.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

public class MostEOR {
    public static void main(String[] args) {
        //int[] nums = new int[]{1,2,3,0,3,2,1,0};
        //System.out.println(most(nums));
        System.out.println(0 ^ 0);
    }

    public static int most(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int[] most = new int[nums.length];
        map.put(0,-1);
        int xor = 0;
        for(int i =0;i<nums.length;i++){
            xor ^= nums[i];
            if(map.containsKey(xor)){
                int preIndex = map.get(xor);//上一次出现的位置
                most[i] = preIndex == -1 ? 1 : most[preIndex] + 1;
            }
            if(i > 0){
                most[i] = Math.max(most[i],most[i-1]);
            }
            map.put(xor,i);
        }
        return most[nums.length - 1];
    }
}
