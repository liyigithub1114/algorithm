package com.liyi.algorithm.dynamic.dpday4;

/**
 * 给定一个字符串S[0.....N-1]
 * 要求将这个字符串划分成若干段，每一段都是一个回文串
 * 求最少可以划分几次
 *
 * 例子
 * 输入 aab
 * 输出 1  （aa,b）
 *
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        minCut("aab");
    }

    /**
     * 分析
     * 假定最后一个回文串，下标是  s[j] ... s[N-1]
     * 那么dp[last]  = s[j]...s[N-1] isTrue dp[last-1] + 1;
     *
     */
    private static boolean[][] CalcPalin(String s, int n) {
        boolean[][] isPalin = new boolean[n][n];
        int i, j, p;
        for (p = 0; p < n; ++p) {
            i = j = p;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                isPalin[i][j] = true;
                --i;
                ++j;
            }
        }

        for (p = 0; p < n-1; ++p) {
            i = p;
            j = p + 1;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                isPalin[i][j] = true;
                --i;
                ++j;
            }
        }

        return isPalin;
    }
    public static int minCut(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] f = new int[n+1];
        //int[] pi = new int[n + 1];
        int i, j, p;
        boolean[][] isPalin = CalcPalin(s, n);

        f[0] = 0;
        for (i=1; i<=n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; ++j) {
                if (isPalin[j][i-1] && f[j] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[j] + 1,f[i]);
                }
            }
        }
        return f[n] - 1;
    }
}
