package com.liyi.algorithm.strings;

/**
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {
    public static void main(String[] args) {
    }
    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int[][] dp = new int[str1.length + 1][str2.length + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = i;
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;
                //最后一个相等的情况，看前面
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }

                //最后一个需要添加
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);

                //最后一个需要更改
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);

                //最后一个需要删除
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
            }
        }

        return dp[str1.length][str2.length];
    }
}
