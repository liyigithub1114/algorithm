package com.liyi.algorithm.dynamic.dpday2;

/**
 * • 题意：
 * • 给定N，要求输出0, 1, …, N的每个数的二进制表示里的1的个数
 * • 例子：
 * • 输入：5
 * • 输出：[0, 1, 1, 2, 1, 2]
 * • 0：0
 * • 1：1
 * • 2：10
 * • 3：11
 * • 4：100
 * • 5：101
 */
public class CountingBits {

    public static void main(String[] args) {
        getSum(5);
    }

    public static int[] getSum(int num){
        if(num == 0) return new int[]{0};
        int dp[] = new int[num+1];
        for(int i =0;i<=num;i++){
            if(i == 0){
                dp[i] = 0;
            }else if(i==1){
                dp[i] = 1;
            }else{
                dp[i] = dp[i / 2] + i % 2;
            }
        }
        return dp;
    }
}
