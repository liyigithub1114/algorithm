package com.liyi.algorithm.dynamic.dpday1;

/***
 * 动态规划，矩阵左上角到右下角，
 */
public class NewUnquePath2 {
    public static void main(String[] args) {

    }

    public static int getCount(int[][] obstacleGrid){
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 )return  0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for(int i =0;i < obstacleGrid.length;i++){
            for(int j = 0;j<obstacleGrid[0].length ;j++){
                if(i == 0 && j == 0) continue;
                if(i == 0 || j == 0){
                    if(i != 0){
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] == 0 ? 0 :1;
                    }
                    if(j != 0){
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j-1] == 0 ? 0 :1 ;
                    }
                }else{
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
