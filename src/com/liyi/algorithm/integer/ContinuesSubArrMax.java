package com.liyi.algorithm.integer;

/**
 * 连续数组内的最大值 -1 2 1   output = 3
 */
public class ContinuesSubArrMax {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        getMax(nums);
    }

    public static void getMax(int[] nums){
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int max = 0;
        int res = nums[0];
        for(int i =0;i<len;i++){
            max = Math.max(max + nums[i],nums[i]);
            res = Math.max(res,max);
        }
        System.out.println(res);
    }
}
