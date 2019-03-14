package com.liyi.algorithm.dynamic.dpday1;

/**
 * 给定一个数组和目标
 * int[] coins = {2,5,7};
 * amount = 11;
 *
 * res = 2+2+7 = 3次
 *
 * f(x) = min{f(x-2) + 1,f(x-5) + 1,f(x-7) + 1}
 */
public class CoinsChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},11));
    }
    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0 ;
        for(int i = 1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j =0;j<coins.length;j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE  ? -1 : dp[amount];
    }
}
