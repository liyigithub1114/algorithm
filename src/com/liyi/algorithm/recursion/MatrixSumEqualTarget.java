package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class MatrixSumEqualTarget {
    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = i+1;
        }
        get(nums,m,0,new ArrayList<>());
    }

    public static void get(int[] nums, int target, int index, List<Integer> res){
        if(target == 0){
            System.out.println(res);
            return;
        }
        if(target < 0) return ;
        for(int i =index;i<nums.length;i++){
            res.add(nums[i]);
            get(nums,target - nums[i],i+1,res);
            res.remove(res.size()-1);
        }
    }
}
