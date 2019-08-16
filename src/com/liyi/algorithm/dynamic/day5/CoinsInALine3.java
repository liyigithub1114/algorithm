package com.liyi.algorithm.dynamic.day5;

/*• 题意：
        • 给定一个序列a[0], a[1], …, a[N-1]
        • 两个玩家Alice和Bob轮流取数
        • 每个人每次只能取第一个数或最后一个数
        • 双方都用最优策略，使得自己的数字和尽量比对手大
        • 问先手是否必胜
        – 如果数字和一样，也算先手胜*/
public class CoinsInALine3 {
    public static void main(String[] args) {
        //输入：[1, 5, 233, 7]
        //输出：True （先手取走1，无论后手取哪个，先手都能取走233）
        System.out.println(win(new int[]{1,5,233,7}));
    }

    //区间博弈型 dp
    public static boolean win(int[] A){
        if(A == null || A.length == 0){
            return true;
        }

        int[][] dp = new int[A.length][A.length];//代表（i,j）时最大的差,
        //假如取头，diff = a[0] - dp[1][len - 1]
        //假如取尾，diff = a[len - 1] - dp[0][len - 2];
        //区间型，len作为状态 len == 1,dp[][] = 拿走唯一一个的值
        for(int i = 0; i < A.length; i++){
            dp[i][i] = A[i];
        }

        for(int len = 2; len <= A.length; len ++){

            for(int i = 0; i <= A.length - len; i++){
                int j = len + i - 1;

                dp[i][j] = Math.max(A[i] - dp[i + 1][j], A[j] - dp[i][j - 1]);
            }
        }

        return dp[0][A.length - 1] >= 0;
    }
}
