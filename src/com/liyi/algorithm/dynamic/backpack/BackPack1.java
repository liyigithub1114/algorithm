package com.liyi.algorithm.dynamic.backpack;

//在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
//输入:  [3,4,8,5], backpack size=10
//输出:  9
public class BackPack1 {
    public static void main(String[] args) {
        System.out.println(backpack1(new int[]{3,4,8,5},10));
    }

    //背包问题 ： 重量w应该放在状态里面
    public static int backpack1(int[] A, int m){
        if(A == null || A.length == 0){
            return 0;
        }

        boolean[][] dp = new boolean[A.length + 1][m + 1];
        dp[0][0] = true;//第0个物品，重量为0

        for(int i = 1; i <= m; i++){
            dp[0][i] = false;
        }

        for(int i = 1; i <= A.length; i++){
            //初始化，dp[i][0] = true
            dp[i][0] = true;
            for(int j = 1; j <= m; j++){
                //第一种可能：前一个就能拿到 j重量的物品，所以必能拿到
                dp[i][j] = dp[i - 1][j];

                //第二种可能，如 上述输入的5， 在重量j = 9时，f(9 - 5) = f(4) = true;
                if(j - A[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j - A[i - 1]] || dp[i][j];
                }
            }
        }


        for(int i = m; i >= 0; i--){
            if(dp[A.length][i]){
                return i;
            }
        }

        return 0;
    }
}
