package com.liyi.algorithm.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回一个整型数组任意四个数相加 得到target 得到的集合
 */
public class FourSum {
    public static void main(String[] args) {
        //[0,0,0,0] 0
        //[-1,0,-5,-2,-2,-4,0,1,-2] -9
        //[-1,0,1,2,-1,-4] -1
        //[4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5] -13
        //
        int[] nums = new int[]{-10,-9,-9,-7,-4,-2,-2,-2,2,4,4,4,5,5,5,9,9,10};
        int target = -13;
        //sort(nums);
        System.out.println(fourSum(nums,target).toString());
    }


    public static List<List<Integer>> fourSum(int[] nums,int target){
        if(nums == null || nums.length == 0 || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<len-2;i++){
            if(i > 0 && nums[i] == nums[i -1]) continue;
            for(int j =i+1;j<len-1;j++){
                if(j > 0 && nums[j] == nums[j-1] && j != i+1) continue;
                int k = j+1;
                int p = len-1;
                while(k<p){
                    int sum = nums[i] + nums[j] + nums[k] + nums[p];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[p]);
                        res.add(list);
                        k++;
                        p--;
                        while(k < p && nums[k] == nums[k-1]){
                            k++;
                        }
                        while(k < p && nums[p] == nums[p+1]){
                            p--;
                        }
                    }else if(sum < target){
                        k++;
                    }else{
                        p--;
                    }
                }
            }
        }
        return res;
    }

    public static void sort(int[] nums){
        if(nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }
}
