package com.liyi.algorithm.dynamic.day6;

public class WildcardMatch {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        char[] strS = s.toCharArray();
        char[] strP = p.toCharArray();

        boolean[][] dp = new boolean[strS.length + 1][strP.length + 1];


        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }

                if(j == 0){
                    dp[i][j] = false;
                    continue;
                }

                if(i > 0 && strP[j - 1] == strS[i - 1]){
                    dp[i][j] |= dp[i - 1][j - 1];
                }

                if(i > 0 && strP[j - 1] == '?'){
                    dp[i][j] |= dp[i - 1][j - 1];
                }

                if(strP[j - 1] == '*'){
                    //0个*
                    dp[i][j] |= dp[i][j - 1];

                    //n个*
                    if(i > 0){
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[strS.length][strP.length];
    }
}
