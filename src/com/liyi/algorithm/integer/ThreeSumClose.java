package com.liyi.algorithm.integer;

import java.util.*;

/**
 * 给定一个整形数组，求任意三个数相加累计和最接近target的几个数的集合
 */
public class ThreeSumClose {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1,4};
        int target = 1;
        threeSumClose(nums,target);

    }
    public static int threeSumClose(int[] nums,int target){
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        Arrays.sort(nums);
        int abs  = Integer.MAX_VALUE;
        int res = 0;
        for(int i =0;i<len-1;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = len -1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                int temp = Math.abs(target - sum);
                if(sum == target){
                    res = sum;
                    abs = 0;
                    j++;
                    k--;
                    while( j < k && nums[j] == nums[j-1]) j++;
                    while( j < k && nums[k] == nums[k+1]) k--;
                }else if(sum < target){
                    if(temp < abs){
                        res = sum;
                        abs = temp;
                    }
                    j++;
                }else{
                    if(temp < abs){
                        res = sum;
                        abs = temp;
                    }
                    k--;
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
