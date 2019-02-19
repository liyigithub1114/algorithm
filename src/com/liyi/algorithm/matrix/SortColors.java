package com.liyi.algorithm.matrix;

import java.util.Arrays;

/**
 * 对数组进行排序，数组内只有0，1，2要求 不能使用系统函数库以及计数排序
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1,1,1,1,1,1,2,1,2,2,1};
        int[] nums1 = new int[]{0,1,0,0,1,1,0,0,2,0,0,0,2,2,1,1,0,2,1,0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,1};
        sort(nums);
    }

    public static void sort(int[] nums){
        if(nums == null || nums.length == 0)return;

        int len = nums.length;
        for(int i =0;i<len;i++){
            if(nums[i] == 1){
                swap(nums,i,len-1);
                break;
            }
        }
        int left = -1;
        int right = len -1;
        int more = right;
        int index = 0;
        while(index < more){
            if(nums[index] > 1){
                swap(nums,--more,index);
            }else if(nums[index] < 1){
                swap(nums,index++,++left);
            }else{
                index++;
            }
        }
        swap(nums,more,right);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums,int i ,int j){
        if(i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
