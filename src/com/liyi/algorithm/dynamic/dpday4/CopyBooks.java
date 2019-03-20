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

    }

    /**
     * 分析
     * 假设最后一个抄写员抄写的 j ... i -1本书
     * 所用的时间f(last) = min(f(last - 1),f(last))
     */
    public static int minTime(int[] A,int K){
        if(A == null || A.length == 0 || K == 0) return 0;
        int res = 0;


        return res;
    }
}
