package com.liyi.algorithm.greedy;

/**
 * 给定一个整型数组， 求连续的子数组中累加和最大的值
 * 如 {-2,1,-3,【4,-1,2,1】,-5,4}  == 6
 */
public class MaxSumSubArr {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSum(nums));
    }

    public static int getMaxSum(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int len = nums.length;
        int sum = 0;
        for(int i =0;i<len;i++){
            sum = Math.max(sum + nums[i],nums[i]);
            res = Math.max(res,sum);
        }

        return res;
    }
}
