package com.liyi.algorithm.dynamic;

/**
 *矩阵左上角走到右下角有多少条路径（中间有障碍物体）
 *
 * [
 *    0,0,0
 *    0,1,0
 *    0,0,0
 * ]
 *
 * res = 2
 */
public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,0}};
        System.out.println(getCount(nums));
    }
    public static int getCount(int[][] nums){
        if(nums == null || nums.length == 0 || nums[0].length == 0) return 0;
        int lenX = nums.length;
        int lenY = nums[0].length;
        int[][] dp = new int[lenX][lenY];
        dp[0][0] = nums[0][0] == 1 ? 0:1;
        for(int i =1;i<lenY;i++){
            dp[0][i] = nums[0][i] == 1 ? 0:dp[0][i-1] == 0 ? 0:1;//判断nums[i][j] == 1是 0 否 1，再判断他前面的路径是否为 0
        }

        for(int i =1;i<lenX ;i++){
            dp[i][0] = nums[i][0] == 1 ? 0:dp[i-1][0] == 0 ? 0:1;
        }

        for(int i =1;i<lenX;i++){
            for(int j = 1;j<lenY;j++){
                dp[i][j] = nums[i][j] == 1 ? 0:dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[lenX-1][lenY-1];
    }
}
