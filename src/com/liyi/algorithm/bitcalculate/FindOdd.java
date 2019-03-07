package com.liyi.algorithm.bitcalculate;

/**
 * 2，2，1
 * 找出1
 * 2，2，3，3，1
 * 找出1
 */
public class FindOdd {
    public static void main(String[] args) {
        System.out.println(find(new int[]{2,1,2,1,3,4,3,4,5}));
    }
    public static int find(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            res = res ^ arr[i];
        }
        return res;
    }
}
