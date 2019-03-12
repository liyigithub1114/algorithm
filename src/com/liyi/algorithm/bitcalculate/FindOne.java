package com.liyi.algorithm.bitcalculate;

/**
 * 一个数字转换为二进制后，含有多少个1
 */
public class FindOne {

    public static void main(String[] args) {
        System.out.println(count(5));
    }
    public static int count(int nums){
        int res = 0;
        while(nums != 0){
            nums &= (nums-1);
            res++;
        }
        return res;
    }
}
