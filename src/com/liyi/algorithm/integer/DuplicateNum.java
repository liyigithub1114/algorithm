package com.liyi.algorithm.integer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DuplicateNum {
    public static void main(String[] args) {
        //时间复杂度O(n),空间复杂度O(1),假设数组设定为read-Only(不允许改变数组)，如何找出重复的数字
        //Floyd的循环检测算法，适用于一个数组内只出现了一次重复的数
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        //                    0 1 2 3 4 5 6 7
        //System.out.println(duplicate(arr));


        //2.一个数组内出现多个重复的数

        duplicate2(arr);
    }

    public static int  duplicate(int[] arr){
        int slow = arr[0];
        int fast = arr[arr[0]];
        System.out.println("slow = " + slow +" " + "fast = " + fast);
        while(slow != fast){
            slow = arr[slow];
            fast = arr[arr[fast]];
            System.out.println("slow = " + slow +" " + "fast = " + fast);
        }

        slow = 0;

        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static List<Integer> duplicate2(int[] nums){
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        int start = 0;
        while(start < len){
            if(nums[start] == start + 1){
                start++;
            }else if(nums[nums[start]-1] == nums[start]){
                if(!res.contains(nums[start])){
                    res.add(nums[start]);
                }
                swap(nums,start,--len);
            }else{
                swap(nums,start,nums[start]-1);
            }
        }
        return res;
    }

    public static void swap(int[] arr,int i ,int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
