package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组内的数，能组成长度为K的数组的集合
 */
public class CombineArrLenK {
    public static void main(String[] args) {
        System.out.println(combine(2,3));
    }
    public static List<List<Integer>> combine(int n, int k) {
        if(n == 0 || n < k) return new ArrayList<>();
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        return combines(nums,k,0,res,new ArrayList<>());
    }

    public static List<List<Integer>> combines(int[] nums,int k,int index,List<List<Integer>> res,List<Integer> list){
        if(list != null && list.size() == k){
            res.add(new ArrayList<>(list));
            return res;
        }
        for(int i =index;i<nums.length;i++){
            list.add(nums[i]);
            combines(nums,k,i+1,res,list);
            list.remove(list.size()-1);
        }
        return res;
    }
}
