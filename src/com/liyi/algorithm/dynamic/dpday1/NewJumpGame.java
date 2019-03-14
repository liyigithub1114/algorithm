package com.liyi.algorithm.dynamic.dpday1;

/**
 * 使用动态规划来写jumpGame
 *
 * 能不能跳到最后一个格子 j？
 * 当前格子i 加上A[i] 能不能到达j
 *
 * 子问题， 有没有某个格子 k 能加上A[k] 到达i
 *
 */
public class NewJumpGame {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{0,1,2}));
    }

    /**
     * 使用动态规划
     * @param nums
     * @return
     */
    public static boolean jump(int[] nums){
        if(nums == null || nums.length == 0) return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i = 1;i<nums.length;i++){
            dp[i] = false;
            for(int j =0;j<i;j++){
                if(dp[j] && j + nums[j] >= i){//如果当前的路径存在，并且能够+num[n] >= i 那么就能跳到i
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
