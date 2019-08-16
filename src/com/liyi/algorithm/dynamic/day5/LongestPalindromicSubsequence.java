package com.liyi.algorithm.dynamic.day5;

//区间型动态规划

/*
        • 给定一个字符串S，长度是N
        • 找到它最长的回文子序列的长度*/
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //bbbab ==> 4(bbbb)序列 ，非连续

        System.out.println(maxLength("bbbab"));
    }


    //序列型通常以 len作为状态，从小到大
    public static int maxLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        char[] strs = s.toCharArray();

        int[][] dp = new int[strs.length][strs.length];
        //初始化len == 1
        for(int i = 0; i < strs.length ;i++){
            dp[i][i] = 1;
        }

        //初始化len == 2
        for(int i = 0; i < strs.length - 1; i++){
            dp[i][i + 1] = (strs[i] == strs[i + 1] ? 2 : 1);
        }

        for(int len = 3; len <= strs.length; len++){

            for(int i = 0; i <= strs.length - len; i++){
                //限定 len = 3, abc, i=0时，j=2     (i,j) == len (j - i + 1)
                int j = len + i - 1;

                //假设某一段 字符串 T（i，j） = 回文串，必定有 strs[i] == strs[j], 即：dp[i][j] = dp[i + 1][j - 1] + 2
                //假设某一段字符串 T（i，j ） strs[i] != strs[j] dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1])
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);//要头不要尾，要尾不要头


                //为什么不用 j > 1，因为len == 3开始 len + i - 1一定大于1
                if(strs[i] == strs[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }

        //为什么是0，因为以长度划分，0 到 strs.length - 1是最长长度
        return dp[0][strs.length - 1];
    }
}
