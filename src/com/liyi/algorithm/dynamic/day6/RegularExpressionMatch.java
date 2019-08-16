package com.liyi.algorithm.dynamic.day6;

public class RegularExpressionMatch {
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

                //最后一字符串成功匹配
                if(i > 0 && strS[i - 1] == strP[j - 1]){
                    dp[i][j] |= dp[i - 1][j - 1];
                }

                //最后一字符串不匹配，但是是。
                if(i > 0 && strP[j - 1] == '.'){
                    dp[i][j] |= dp[i - 1][j - 1];
                }

                if(strP[j - 1] == '*'){
                    //如果 * == 0
                    if(j >= 2){
                        dp[i][j] |= dp[i][j - 2];
                    }

                    //如果 * == n
                    if(j >= 2 && i >= 1){
                        dp[i][j] |= dp[i - 1][j] && (strS[i - 1] == strP[j - 2] || strP[j - 2] == '.');
                    }
                }
            }
        }

        return dp[strS.length][strP.length];
    }
}
