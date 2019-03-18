package com.liyi.algorithm.dynamic.dpday3;

/**
 * 小偷偷房子
 * 已知不能偷相邻的两栋房子，求最多能偷多少钱
 *
 * 如{3，8，4}
 * res = 8 ，只偷第二栋
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(getMax(new int[]{3,8,4,1,7}));
    }

    /**
     *分析
     * 假设最后一栋房子不偷
     * 那么f(x) = f(x-1)... f(x-1)不偷 ，f(x-1) = f(x-2)
     * 假设最后一栋房子偷
     * 那么f(x) = f(x-2) + house[i];
     */
    public static int getMax(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        for(int i = 0;i < nums.length ;i++){
            if(i == 0){
                dp[i] = nums[i];
            }else if(i == 1){
                dp[i] = Math.max(nums[i],nums[i-1]);
            }else{
                dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }
}
