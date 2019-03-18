package com.liyi.algorithm.dynamic.dpday3;

/**
 * 可以多次买入卖出一只股票
 * 求最大利润
 *
 * 输入： [7,1,5,3,6,4]
 输出： 7
 说明：在第2天买入（价格= 1）并在第3天卖出（价格= 5），利润= 5-1 = 4。
 然后在第4天买入（价格= 3）并在第5天卖出（价格= 6），利润= 6-3 = 3。
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        System.out.println(getProfit(new int[]{3,8,9,3,2,5,7,3}));
    }

    /**
     * 分析
     * dp[0] = 0
     * 只要第i天大于前一天，dp[i] = dp[i-1] + prices[i] - prices[i-1]
     * 如果小于，则判定为买入
     *
     */
    public static int getProfit(int[] prices){
        if(prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int res = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                dp[i] = dp[i-1] + prices[i] - prices[i-1];
            }else{
                res += dp[i-1];
                dp[i] = 0;
            }
        }
        res += dp[prices.length - 1 ];
        return res;
    }
}
