package com.liyi.algorithm.dynamic.dpday4;

/**
 * 有N本书需要被抄写，第i本书有A[i]页
 * 有K个抄写员，每个抄写员可以连续抄写若干本书
 *
 * 每个抄写员的速度是一样的，每个抄写员1分钟抄写1页
 * 最少需要多长时间抄完所有的书
 *
 * 输入 A = [3, 2, 4], K=2 •输出 5 （第一个抄写第1本和第2本  第二个抄写员抄写第3本）
 */
public class CopyBooks {

    public static void main(String[] args) {
        System.out.println(minTime(new int[]{3,2,4},2));
    }

    /**
     * 分析
     * 假设最后一个抄写员抄写的 j ... i -1本书
     */
    public static int minTime(int[] A,int K){
        if(A == null || A.length == 0 || K == 0) return 0;

        int len = A.length;
        if(K > len){
            K = len;
        }

        int[][] dp = new int[K + 1][len + 1];
        dp[0][0] = 0;//第0 个人，第0本书

        for(int i = 1; i <= len; i++){
            dp[0][i] = Integer.MAX_VALUE;
        }

        int sum = 0;

        for(int i = 1; i <= K; i++){
            for(int j = 1; j <= len; j++){
                dp[i][j] = Integer.MAX_VALUE;
                sum = 0;

                for(int t = j; t >= 0; t--){
                    //第一步，先不加sum 是因为 dp[i][j] 加入 j 不加入进来 ，前一个人抄写到了j
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][t], sum));
                    //然后开始加上 j位置的值
                    if(t > 0){
                        sum += A[t - 1];
                    }
                }

            }
        }

        return dp[K][len];
    }
}
