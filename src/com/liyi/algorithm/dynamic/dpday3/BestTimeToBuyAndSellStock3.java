package com.liyi.algorithm.dynamic.dpday3;

/**
 * 买股票，最多两笔交易
 * 求最大利润
 *
 * 输入： [3,3,5,0,0,3,1,4]
 输出： 6
 说明：第4天买入（价格= 0）并在第6天卖出（价格= 3），利润= 3-0 = 3。
 然后在第7天买入（价格= 1）并在第8天卖出（价格= 4），利润= 4-1 = 3。
 */
public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        System.out.println(getProfit(new int[]{ 4,4,6,1,1,4,2,5},2));
    }


    /**
     * 分析
     *两笔交易，起始都应该为0
     * int[][] dp 代表从i位置分别买入和卖出的情况
     *
     *例如 k = 2
     *
     * 阶段1 ： 没有股票
     * 阶段2 ： 有股票，且第一次购买
     * 阶段3 ： 没有股票，第一次卖出
     * 阶段4 ： 有股票， 第二次购入
     * 阶段5 ： 没有股票， 第二次卖出
     *
     * 此处写通用方法，最多K次买卖
     */
    public static int getProfit(int[] prices, int k){
        if(prices == null || prices.length == 0){
            return 0;
        }


        //在第i天处于状态 k 时的收益
        int[][] dp = new int[prices.length + 1][2 * k + 2];

        dp[0][1] = 0;

        for(int i = 2; i < dp[0].length; i++){
            dp[0][i] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= prices.length; i++){
            dp[i][1] = 0;

            for(int j = 1; j < dp[0].length; j = j + 2){
                //假如在阶段1，3，5
                //可能1：前一天就在状态3，5
                dp[i][j] = dp[i - 1][j];

                //可能2： 前一天在2，或者4, dp[i][j] = 前一天的收益加今天的收益(注意判断条件 j > 1){因为阶段1是最小，没有阶段0}
                if(i > 1 && j >1 && dp[i - 1][j - 1] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for(int j = 2; j < dp[0].length; j = j + 2){
                //假如在2，4阶段

                //假如在阶段3,默认继承
                dp[i][j] = dp[i - 1][j - 1];

                //假如在前一天在阶段4
                if(i > 1 && j > 1 && dp[i - 1][j] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
                //假如前一天在阶段2
                if(i > 1 && j > 1 && dp[i - 1][j - 2] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2] + prices[i - 1] - prices[i - 2]);
                }

            }
        }

        int res = 0;
        for(int i = 1; i < dp[0].length; i++){
            res = Math.max(dp[prices.length][i],res);
        }

        return res;
     }
}
