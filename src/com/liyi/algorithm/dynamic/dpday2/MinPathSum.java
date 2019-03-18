package com.liyi.algorithm.dynamic.dpday2;

/**
 * • 题意:
 * • 给定m行n列的网格，每个格子(i, j)里都一个非负数A[i][j]
 * • 求一个从左上角(0, 0)到右下角的路径，每一步只能向下或者向右走一步
 * • 使得路径上的格子里的数字之和最小
 * • 输出最小数字和

 */
public class MinPathSum {
    public static void main(String[] args) {
        getMin(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    public static int getMin(int[][] nums){
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        int[][] dp = new int[nums.length][nums[0].length];
        for(int i =0;i<nums.length;i++){
            for(int j = 0;j<nums[0].length;j++){
                if(i ==0  || j == 0){
                    if(i > 0){
                        dp[i][j] = dp[i-1][j] + nums[i][j];
                    }
                    if(j > 0){
                        dp[i][j] = dp[i][j-1] + nums[i][j];
                    }
                    if(i==0 && j == 0){
                        dp[i][j] = nums[i][j];
                    }
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + nums[i][j];
                }
            }
        }
        return dp[nums.length - 1][nums[0].length - 1];
    }
}
