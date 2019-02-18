package com.liyi.algorithm.recursion;

import java.util.*;

/**
 * 给定一个整形数组(有重复值) 求组合为target数的集合，一个数只能用一次，切结果集中不能存在相同的集合
 */
public class CombineSum2 {
    public static void main(String[] args) {
        //1，1，2，5，6，7，10
        int[] nums = new int[]{2,5,2,1,2};//2,5,2,1,2
        int target = 5;//5
        combine(nums,target);
    }

    public static void combine(int[] nums,int target){
        if(nums == null || nums.length == 0) return;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getCombine(nums,target,0,new ArrayList<>(),res);
        System.out.println();
    }

    public static void getCombine(int[] nums,int target,int k,List<Integer> list,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }
        if(target < 0) return;
        for(int i = k;i<nums.length;i++){
            if(i != k && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            getCombine(nums,target-nums[i],i+1,list,res);
            list.remove(list.size()-1);
        }
    }
}
