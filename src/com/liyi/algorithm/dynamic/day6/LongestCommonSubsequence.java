package com.liyi.algorithm.dynamic.day6;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String A, String B) {

        char[] strA = A.toCharArray();
        char[] strB = B.toCharArray();

        if(strA.length == 0 || strB.length == 0){
            return 0;
        }

        int[][] dp = new int[strA.length + 1][strB.length + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }

                //最后一个不相等
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if(strA[i - 1] == strB[j - 1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
