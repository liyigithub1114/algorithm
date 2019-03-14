package com.liyi.algorithm.dynamic.dpday1;

/**
 * 矩阵左上角到右下角一共多少种走法
 */
public class NewUnquePath {
    public static void main(String[] args) {
        getCount(3,2);
    }
    public static int getCount(int m , int n){
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
