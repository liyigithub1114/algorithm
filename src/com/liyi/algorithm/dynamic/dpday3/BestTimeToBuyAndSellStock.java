package com.liyi.algorithm.dynamic.dpday3;

/**
 * 股票问题，
 * 最多一次买入卖出
 * 求最大利益
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(getProfit(new int[]{7,1,5,3,6,4}));
    }

    /**
     *分析
     * 第一天只能是买入，所以dp[0] = 0,
     * 第二天可以买入可以卖出
     * f(x) = {prices[x] > prices[x-1] ? 差值 ：0 }
     */
    public static int getProfit(int[] prices){
        if(prices == null || prices.length == 0)return 0;
        int dp[] = new int[prices.length];
        int res = Integer.MIN_VALUE;
        dp[0] = 0;
        for(int i =1;i<prices.length;i++){
            dp[i] = 0;
            if(prices[i] > prices[i-1]){
                dp[i] = prices[i] - prices[i-1] + dp[i-1];
            }else{
                dp[i] = Math.max(dp[i-1] + prices[i] - prices[i-1],0);
            }
            res = Math.max(res,dp[i]);
        }
        return res == Integer.MIN_VALUE ? 0 :res;
    }
}
