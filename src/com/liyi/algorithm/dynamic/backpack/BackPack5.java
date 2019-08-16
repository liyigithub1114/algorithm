package com.liyi.algorithm.dynamic.backpack;

//题意:
/*  • 给定N个正整数：A0,A1, …, AN-1
    • 一个正整数Target
    • 求有多少种组合加起来是Target
    • 每个Ai
    只能用一次
*/
public class BackPack5 {
    public static void main(String[] args) {
        //A=[1, 2, 3, 3, 7], Target=7
        System.out.println(backpack5(new int[]{1,2,3,3,7},7));//7 ; 1,3,3
    }

    public static int backpack5(int[] A, int target){
        if(A == null || A.length == 0){
            return 0;
        }
        int[][] dp = new int[A.length + 1][target + 1];
        //第0个物品，重量0  方式有一种，什么都不加
        dp[0][0] = 1;

        for(int i = 1; i <= target; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i<= A.length; i++){
            //dp[i][0] = 1;
            for(int j = 1; j <= target; j++){
                //加入不拿最后一个，会有几种方式
                dp[i][j] = dp[i - 1][j];

                //加入拿最后一个，会有几种方式、
                if(j - A[i - 1] >= 0){
                    dp[i][j] += dp[i - 1][j - A[i - 1]];
                }
            }
        }

        return dp[A.length][target];
    }
}
