package com.liyi.algorithm.dynamic.dpday3;

/**
 * 输入[4,2,4,5,3,7]
 * 输出[4]  2,4,5,7
 *
 *     f(x) = 1,1,2,3,2,4
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        getMax(new int[]{1,2,4,3,5,4,7,2});
    }

    /**
     *分析
     *序列型动态规划 (一般都是Max{f(0)....f(n)})
     * 对于倒数第二个数字来讲，3，只有一个比他小的，所以 f(3) = 2
     */
    public static int getMax(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            dp[i] = 1;
            for(int j =0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            System.out.print(dp[i] + " ");
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
