package com.liyi.algorithm.integer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个整形数组，求任意3个数能组成 目标为target的集合
 *
 * nums = new int[]{0,1,2,3,4,5,6,7}; target = 6
 * res = {1,2,3},{0,2,4} 注意，结果不一定是连续的几个数
 */
public class ThreeSum {
    public static void main(String[] args) {

    }

    public static void threeSum(int[] nums,int target){
        if(nums == null || nums.length == 0) return ;
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i = 0;i<len-1;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(k);
                    res.add(temp);
                    j++;
                    k--;
                    while(j > k && nums[j] == nums[j-1]) j++;
                    while(j > k && nums[k] == nums[k+1]) k--;
                }else if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
    }
}
