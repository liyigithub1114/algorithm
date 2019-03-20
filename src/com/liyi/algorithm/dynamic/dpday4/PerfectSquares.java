package com.liyi.algorithm.dynamic.dpday4;

/**
 * 给定一个正整数n
 * 问最少可以将n分成几个完全平方数
 *
 * 例子 13
 * 1 ,4，9
 * 最少2个
 */
public class PerfectSquares {

    public static void main(String[] args) {
        getMin(4);
    }

    /**
     * 分析
     * 倒数第一个假设被分解的完全平方数是 j 满足条件 i - j*j > 0 时
     * f(j) = f(j-1) + 1
     *
     *
     */
    public static int getMin(int n){
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i =1;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j =1;j * j <= i;j++){
                if(i - j*j >= 0){
                    dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
                }
            }
        }
        return dp[n];
    }
}
