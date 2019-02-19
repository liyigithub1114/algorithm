package com.liyi.algorithm.dynamic;

import java.util.Arrays;

/**
 * 矩阵内左上角走到右下角有多少条路经
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

    /**
     * DP
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        Arrays.fill(dp[0],1);

        for(int r=0;r<m;r++) dp[r][0]=1;

        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                dp[r][c]=dp[r-1][c]+dp[r][c-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     *暴力递归i
     */
    public static int uniquePaths1(int m, int n) {
        if(m==0 || n == 0) return 0;
        int startX = 0;
        int startY = 0;
        int endX = m-1;
        int endY = n-1;

        return getCount(startX,startY,endX,endY);
    }

    public static int getCount(int startX,int startY,int endX,int endY){
        if(startX == endX && startY == endY){
            return 1;
        }
        if(startX == endX){
            return 1;
        }
        if(startY == endY){
            return 1;
        }
        int count=0;
        count += getCount(startX,startY+1,endX,endY);
        count += getCount(startX+1,startY,endX,endY);
        return count;
    }
}
