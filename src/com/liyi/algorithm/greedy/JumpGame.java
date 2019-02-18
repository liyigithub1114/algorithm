package com.liyi.algorithm.greedy;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一维数组，nums[i] 表示 位置 i 的元素可以跳动的步数
 * 求 从nums[0]开始能否跳到最后一个位置
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4},0,5,new HashMap<>()));
        System.out.println(jump(new int[]{3,2,1,0,4},0,5,new HashMap<>()));
        System.out.println(jump(new int[]{1,1,2,2,0,1,1},0,7,new HashMap<>()));
        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        //boolean[] flags = new boolean[nums.length];
        System.out.println(jump(nums,0,nums.length,new HashMap<>()));
    }

    /**
     * 递归超时
     */
    public static boolean jump(int[] nums, int index, int len, Map<Integer,Boolean> map){
        if(index >= len - 1) return true;
        if(nums[index] == 0) return false;
        if(map.get(index) != null && map.get(index) == false) return false;
        int jump = nums[index];
        while(jump > 0){
            int i = index;
            boolean flag = jump(nums,i+jump,len,map);
            if(flag){
                return true;
            }
            map.put(i+jump,false);
            jump--;
        }
        return false;
    }

    /**
     * 贪心寻找最长的路径   与 MaxSumSubArr相似
     */
    public static boolean jump2(int[] nums){
        if(nums == null || nums.length == 0) return true;
        int maxLen = 0;
        int index = 0;
        while(index < nums.length && index <= maxLen){
            maxLen =Math.max(index+nums[index],maxLen);
            index++;
        }
        return maxLen >= nums.length-1;
    }
}
