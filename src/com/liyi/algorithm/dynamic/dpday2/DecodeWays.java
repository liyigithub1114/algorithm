package com.liyi.algorithm.dynamic.dpday2;

/**
 * • 题意：
 * • 有一段由A-Z组成的字母串信息被加密成数字串
 * •加密方式为：A=1, B=2, …, Z=26 • 给定加密后的数字串S[0…N-1]，问有多少种方式解密成字母串
 • 例子：
 • 输入： –12
 • 输出： –2 (AB 或者 L)
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(getCount("12214153212231321"));
    }

    /**
     * 分析
     *假设f(x)为最终能解密的数量
     * 那么他应该满足 f(x) = {f(x-1)+f(x-2)}
     * 当 x >= 1 && x<=9 时 f(x) += f(x-1)
     * 当 x >=10 && x<=26 时 f(x) += f(x-2)
     *123
     * ABC
     * LC
     * AW
     *
     * 即转换公式为
     * f(x) = { f(x-1) + (x = {1...9} ? 1 : 0)}
     * */
    public static int getCount(String ss){
        if(ss == null || ss.length() == 0) return 0;
        char[] chars = ss.toCharArray();
        int len = ss.length();
        int dp[] = new int[len+1];
        dp[0] = 1;
        for(int i =1;i<=len;i++){
            int temp = chars[i-1] - '0';
            if(temp >= 1 && temp <= 9){
                dp[i] += dp[i-1];
            }
            if(i>=2){
                temp = (chars[i-2] - '0') * 10 + (chars[i-1] - '0');
                if(temp >= 10 && temp <= 26){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len];
    }
}
