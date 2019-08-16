package com.liyi.algorithm.dynamic.day6;

public class InterleavingString {
    public static void main(String[] args) {

    }

    /**
     * A[i - 1] = T[i] dp[i][j] = dp[i - 1][j]
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();

        if(str1.length + str2.length != str3.length){
            return false;
        }

        boolean[][] dp = new boolean[str1.length + 1][str2.length + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }

                if(i == 0){
                    dp[i][j] = str2[j - 1] == str3[i + j - 1];
                    continue;
                }

                if(j == 0){
                    dp[i][j] = str1[i - 1] == str3[i + j - 1];
                    continue;
                }

                //假如在str1中
                if(i > 0 && str1[i - 1] == str3[i + j - 1]){
                    dp[i][j] |= dp[i - 1][j];
                }
                if(j > 0 && str2[j - 1] == str3[i + j - 1]){
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[str1.length][str2.length];
    }
}
