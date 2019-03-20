package com.liyi.algorithm.integer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在数组中找到 累加和为K 的最大子数组 系列问题
 *
 * sum 代表从0开始加到 i位置的和
 * sum-K代表  从 之前i的位置到现在i的位置的累加和为K
 */
public class MaxLenSerialProblem {
    public static void main(String[] args) {
        //"ABAAABB"
        int[] arr = new int[]{-1,1,-1,-1,-1,1,1};
        getMaxlen(arr,0);
    }

    public static void getMaxlen(int[] arr ,int K){
        if(arr == null || arr.length < 0) return ;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int len =0;
        map.put(0,-1);
        for(int i = 0 ;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum-K)){
                int j = map.get(sum-K);//假如这个数存在，代表j这个位置到i位置的累加和为K；
//                if(len<i-j){
//                    len = i - j;
//                }
                len = Math.max(len,i-j);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        System.out.println(len);
    }
}
