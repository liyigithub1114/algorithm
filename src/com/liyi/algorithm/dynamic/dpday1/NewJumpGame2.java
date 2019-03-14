package com.liyi.algorithm.dynamic.dpday1;

/**
 * 和 jumpGame思路一样
 *
 * 您可以假设始终可以到达最后一个索引（从0位置一定能跳到）
 */
public class NewJumpGame2 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums ){
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for(int i =1;i<nums.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0;j<i;j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
