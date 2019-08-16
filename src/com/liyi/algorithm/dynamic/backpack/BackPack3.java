package com.liyi.algorithm.dynamic.backpack;
/*
题意:
        • 给定N种物品，重量分别为正整数A0,A1, …, AN-1，价值分别为正整数V0,
        V1, …, VN-1
        • 每种物品都有无穷多个
        • 一个背包最大承重是正整数M
        • 最多能带走多大价值的物品
*/
public class BackPack3 {
    public static void main(String[] args) {
        //输入：4个物品，重量为2, 3, 5, 7，价值为1, 5, 2, 4. 背包最大承重是10
        //输出：15 （3个物品一，重量3*3=9，价值5*3=15）

        System.out.println(backpack5(new int[]{2,3,5,7}, new int[]{1,5,2,4}, 9));
        System.out.println(backPackIII(10,new int[]{2,3,5,7}, new int[]{1,5,2,4}));
    }

    public static int backpack5(int[]A, int[] V, int M){
        if(A == null || A.length == 0){
            return 0;
        }

        int[][] dp = new int[A.length + 1][M + 1];
        dp[0][0] = 0;
        for(int i = 1; i <=M; i++){
            dp[0][i] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= M; j++){
                dp[i][j] = dp[i - 1][j];

                int tempA = A[i -1];
                int tempV = V[i - 1];
                while(j - tempA >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - tempA] + tempV);
                    tempA += A[i - 1];
                    tempV += V[i - 1];
                }

                //假如f(6) 和A[2] ,f(6) = max(f(6), f(4) + v, f(2) + 2v , f(0) + 3v)
                //f(4) A[2], f(4) = max(f(4),f(2) + v , f(0) + 2v);
                //因为每次取值都为max f(6) = max(f(6),f(4) + v);
                /*if(j - A[i - 1] >= 0 && dp[i][j - A[i - 1]] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j - A[i - 1 ]] + V[i - 1]);
                }*/

            }
        }

        int res = 0;
        for(int i = 0; i <= M; i++){
            res = Math.max(res, dp[A.length][i]);
        }

        return res;
    }

    //version2 九章
    public static int backPackIII(int m, int[] A, int V[]) {
        if(A == null || A.length == 0){
            return 0;
        }
        int[] f = new int[m + 1];
        f[0] = 0;
        for (int i = 1; i <= m ; ++i) f[i] = -1;

        for(int i = 1; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                if(j - A[i - 1] >= 0 && f[j - A[i - 1]] != -1){
                    f[j] = Math.max(f[j],f[j - A[i - 1]] + V[i - 1]);
                }
            }
        }

        int res = 0;
        for(int i = 0; i <= m; i++){
            res = Math.max(res, f[i]);
        }

        return res;
    }
}
