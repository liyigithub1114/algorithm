package com.liyi.algorithm.dynamic;

/**
 *求二位矩阵内的左上角到右下角的最短路径
 *
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 *
 *  res = 1+3+1+1
 * ]
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,5},
                                    {3,2,1}};
        System.out.println(dp(nums));
    }

    public static int dp(int[][] nums){
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        int lenX = nums.length;
        int lenY = nums[0].length;

        int[][] dp = new int[lenX][lenY];
        dp[0][0] = nums[0][0];

        for(int i = 1;i<lenX;i++){
            dp[i][0] = nums[i][0] + dp[i-1][0];
        }
        for(int i = 1;i<lenY;i++){
            dp[0][i] = nums[0][i] + dp[0][i-1];
        }
        for(int i = 1;i<lenX;i++){
            for(int j = 1;j<lenY;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + nums[i][j];
            }
        }
        return dp[lenX-1][lenY-1];
    }
}
