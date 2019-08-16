package com.liyi.algorithm.strings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定s1，s2，s3，找出s3是否由s1和s2的交织形成。
 */
public class InterLeavingString {

    public static void main(String[] args) {
        String s1 = "aabc";
        String s2 = "abad";
        String s3 = "aabcabad";
        String s4 = "";
        String s5 = "";
        System.out.println(s4.equals("2"));
        System.out.println(isInterLeaving(s1,s2,s3,0,0,0));

        System.out.println(17 % 3);
    }
    //
    public static boolean isInterLeaving(String s1,String s2,String s3,int s1Index,int s2Index,int s3Index){
        if(s1Index + s2Index == s3.length()) return true;
        char c3 = s3.charAt(s3Index);
        if(s1Index < s1.length() && s2Index < s2.length() && s1.charAt(s1Index) == s2.charAt(s2Index) && s1.charAt(s1Index) == c3){
            boolean flag = isInterLeaving(s1,s2,s3,s1Index+1,s2Index,s3Index+1);
            if(flag){
                return true;
            }else{
                flag = isInterLeaving(s1,s2,s3,s1Index,s2Index+1,s3Index+1);
                if(flag){
                    return true;
                }
            }
        }else if(s1Index < s1.length() && s1.charAt(s1Index) == c3){
            return isInterLeaving(s1,s2,s3,s1Index+1,s2Index,s3Index+1);
        }else if(s2Index < s2.length() & s2.charAt(s2Index) == c3){
            return isInterLeaving(s1,s2,s3,s1Index,s2Index+1,s3Index+1);
        }
        return false;
    }

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

