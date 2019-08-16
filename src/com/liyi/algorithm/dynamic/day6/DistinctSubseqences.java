package com.liyi.algorithm.dynamic.day6;

public class DistinctSubseqences {
    public static void main(String[] args) {

    }
    public int numDistinct(String S, String T) {
        char[] strS = S.toCharArray();
        char[] strT = T.toCharArray();
        int m = strS.length;
        int n = strT.length;
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){

                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }

                if(i == 0){
                    dp[i][j] = 0;
                    continue;
                }

                if(strS[i - 1] == strT[j - 1]){
                    dp[i][j] += dp[i - 1][j - 1];
                }

                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}
