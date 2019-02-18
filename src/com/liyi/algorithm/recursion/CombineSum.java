package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个 整型数组(无重复元素)， 给定target 求数组内累加和为target的集合，一个数可重复利用多次
 */
public class CombineSum {
    public static void main(String[] args) {
        int nums[] = new int[]{2,3,6,7};
        combine(nums,7);//[2，2，3]  [7]
    }

    public static void combine(int[] nums,int target){
        if(nums == null || nums.length == 0) return ;
        List<List<Integer>> res = new ArrayList<>();

        getCombine(nums,target,0,new ArrayList<>(),res);
    }

    public static void getCombine(int[] nums,int target,int i ,List<Integer> list,List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }
        if(target < 0) return;
        for(int j = i;j<nums.length;j++){
            list.add(nums[j]);
            getCombine(nums,target - nums[j],j,list,res);
            list.remove(list.size()-1);
        }
    }
}
