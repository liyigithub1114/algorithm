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

    }


    /**
     * 分析
     *两笔交易，起始都应该为0
     * int[][] dp 代表从i位置分别买入和卖出的情况
     * 0,3,1,4
     *
     * 0 买入：0 卖出0
     * 3：买入：0 卖出：3
     * 1：买入：0 卖出：3为买入时，1 ； 3为卖出时，dp[3] + 1-3 = 1
     * 4：买入：0 卖出：1为买入时，3； 1为卖出时，4
     */
    public static void getProfit(int[] prices){
        if(prices == null || prices.length ==0) return  ;
        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0;//买入，买入时都为0
        dp[0][1] = 0;//卖出，上一个为买入时
        dp[0][2] = 0;//卖出，上一个为卖出时
     }
}
