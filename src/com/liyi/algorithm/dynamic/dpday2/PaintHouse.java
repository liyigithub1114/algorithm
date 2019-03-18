package com.liyi.algorithm.dynamic.dpday2;

/**
 *  题意： • 有一排N栋房子，每栋房子要漆成3种颜色中的一种：红、蓝、绿
 *         • 任何两栋相邻的房子不能漆成同样的颜色
 *         • 第i栋房子染成红色、蓝色、绿色的花费分别是cost[i][0], cost[i][1], cost[i][2]
 *         • 问最少需要花多少钱油漆这些房子
 *
 *         • 例子：
 *         • 输入： –N=3 –Cost = [[14,2,11],[11,14,5],[14,3,10]]
 *         • 输出： –10 （第0栋房子蓝色，第1栋房子绿色，第2栋房子蓝色, 2+5+3=10）
 */
public class PaintHouse {
    public static void main(String[] args) {
        int res = getMin(3,new int[][]{{14,2,11},{11,14,5},{14,3,10}});
        System.out.println(res);
    }
    /**
     * 分析
     *假设第一个房子是红色
     * 那么第二个房子只能是篮或者是绿
     * 则有转换公式
     * f(i)(color) = {f(i-1)(上一次的非此颜色最小花费) + min{f(i)(除了上一次颜色的其他颜色最小花费)}}
     */

    public static int getMin(int N,int[][] cost){
        if(N == 0 || cost == null || cost.length == 0) return 0;
        int[][] dp = new int[N][3];//N个房子，3种颜色，记录每个房子每个颜色的最小花费;

        for(int i =0;i<N;i++){
            for(int j =0;j<3;j++){
                if(i == 0){
                    dp[i][j] = cost[i][j];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k =0;k<3;k++){
                        if(k != j) {
                            dp[i][j] = Math.min(dp[i][j],dp[i-1][k] + cost[i][j]);//本次房子(i)加入是红色(j),那么它等于上一次(i-1)非红色+本次红色
                        }
                    }
                }
            }
        }
        return Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
    }
}
