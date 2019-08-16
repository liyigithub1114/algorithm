package com.liyi.algorithm.dynamic.backpack;

/*• 题意:
        • 给定N个物品，重量分别为正整数A0,A1, …, AN-1，价值分别为正整数V0,
        V1, …, VN-1
        • 一个背包最大承重是正整数M
        • 最多能带走多大价值的物品
*/
public class BackPack2 {
    public static void main(String[] args) {
        //• 输入：4个物品，重量为2, 3, 5, 7，价值为1, 5, 2, 4. 背包最大承重是12
        //• 输出：9 （物品一+物品三，重量3+7=10，价值5+4=9）

        System.out.println(backpack2(new int[]{2,3,5,7},new int[]{1,5,2,4},11));
        System.out.println(backPackII(11,new int[]{2,3,5,7},new int[]{1,5,2,4}));
    }

    public static int backpack2(int[] A, int[] V, int M){
        if(A == null || A.length == 0 || V == null || V.length == 0){
            return 0;
        }

        int[][] dp = new int[A.length + 1][M + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= M; i++){
            dp[0][1] = Integer.MAX_VALUE;
        }

        int res = 0;
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= M; j++){

                dp[i][j] = dp[i - 1][j];

                //假如当前A[i]
                if(j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]] != Integer.MIN_VALUE){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }

            }
        }

        for(int i = 0; i <= M; i++){
            if(dp[A.length][i] != Integer.MAX_VALUE){
                res = Math.max(res, dp[A.length][i]);
            }
        }
        return res;
    }

    //version2 九章
    public static int backPackII(int m, int[] A, int V[]) {
        if(A == null || A.length == 0){
            return 0;
        }
        int[] f = new int[m + 1];
        f[0] = 0;
        for (int i = 1; i <= m ; ++i) f[i] = -1;

        for(int i = 1; i <= A.length; i++){
            for(int j = m; j >= 0; j--){
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
