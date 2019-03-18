package com.liyi.algorithm.dynamic.dpday3;

/**
 * 现在有K种颜色，有办法对上次的DP(O(NK^2))进行加速吗？
 *
 *  *  题意： • 有一排N栋房子，每栋房子要漆成K种颜色中的一种：红、蓝、绿、......
 *  *         • 任何两栋相邻的房子不能漆成同样的颜色
 *  *         • 第i栋房子染成红色、蓝色、绿色、.....的花费分别是cost[i][0], cost[i][1], cost[i][2],cost[i][....]
 *  *         • 问最少需要花多少钱油漆这些房子
 *  *
 *  *         • 例子：
 *  *         • 输入： –N=3 –Cost = [[14,2,11],[11,14,5],[14,3,10]]
 *  *         • 输出： –10 （第0栋房子蓝色，第1栋房子绿色，第2栋房子蓝色, 2+5+3=10）
 */
public class PaintHouse2 {

    public static void main(String[] args) {
        System.out.println(getNum(3,3,new int[][]{{14,2,11},{11,14,5},{14,3,10}}));
    }

    /**
     * 分析，cost[i][j] j代表房子的花费，只要求出每次 i 对应的所有j(颜色)最小的两个即可 比如 这次要求绿色cost[i][0]
     * 最小的那个如果是绿色 min1(颜色下标为x),则此次dp[i][0] += dp[i-1][y] ,y是非绿色的其他颜色，第二小
     *
     * @param N
     * @param K
     * @param cost
     * @return
     */
    public static int getNum(int N,int K,int[][] cost){
        if(N == 0 || K == 0) return 0;
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[N][K];
        for(int i = 0;i<N;i++){
            int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE,x = 0,y = 0;
            for(int j = 0;j < K ;j++){
                if(i == 0){
                    dp[i][j] = cost[i][j];
                }else{
                    if(min1 > cost[i-1][j]){
                        min2 = min1;
                        min1 = cost[i-1][j];
                        y = x;
                        x = j;
                    }else if(min2 > cost[i-1][j]){
                        min2 = cost[i-1][j];
                        y = j;
                    }
                }
            }
            if(i > 0){
                for(int j = 0;j < K;j++){
                    if(j != x){
                        dp[i][j] = dp[i-1][x] + cost[i][j];
                    }else{
                        dp[i][j] += dp[i-1][y] + cost[i][j];
                    }
                    if(res > dp[i][j]){}
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
