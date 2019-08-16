package com.liyi.algorithm.dynamic.day5;

public class CoinsInALine2 {
    public static void main(String[] args) {

    }

    public static boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return true;
        }

        int[][] dp = new int[values.length][values.length];

        for(int i = 0; i < values.length; i++){
            dp[i][i] = values[i];
        }

        for(int i = 0; i < values.length - 1; i++){
            dp[i][i + 1] = values[i] + values[i + 1];
        }

        for(int len = 3; len <= values.length; len++){
            for(int i = 0; i<= values.length - len; i++){
                int j = len + i - 1;
                dp[i][j] = Math.max(dp[i][i] - dp[i + 1][j], dp[i][i + 1] - dp[i + 2][j]);
            }
        }

        return dp[0][values.length - 1] >= 0;
    }
}
