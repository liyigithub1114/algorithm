package com.liyi.algorithm.bitcalculate;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(-1);
        list.add(2);
        list.add(-1);
        list.add(2);
        int[] nums = new int[]{1,3,-1,2,-1,2};
        System.out.println(maxSubArray(nums,2));
    }

    /*
     localMax[n][k] 定义了局部最优, 表示对于前n个数来说，分成k组必须将第n个元素包含
     globalMax[n][k] 定义了全局最优, 表示对于前n个数来说，分成k组有可能不包含第n个元素

     localMax[n][k] 在更新的过程中,由于第n个数必须被包含，则会出现两种情况：
     1. 第n个元素单独为一组，意味着前 n-1个数分成 k-1组，当下全局最优解 globalMax[n-1][k-1]
     2. 第n个元素与其他元素一起被分为k组，意味着其他n-1个元素已经构成了k组，且由于子数组下标位置连续，第(n-1)个元素一定出现在k组，当下局部最优解 localMax[n-1][k]
     - 递推公式 localMax[n][k] = max(globalMax[n-1][k-1], local[n-1][k]) + 第n个元素

     globalMax[n][k] 在更新的过程中,由于第n个数不确定是否包含，也会出现两种情况：
     1. 第n个元素不被包含，意味着其他 n-1个元素需要构成k组，全局最优解是 globalMax[n-1][k]
     2. 第n个元素被包含，意味着n个元素构成k组，当下局部最优解 localMax[n][k]
     - 递推公式 globalMax[n][k] = max(globalMax[n-1][k], local[n][k])
     */
    public static int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] localMax = new int[len + 1][k + 1];
        int[][] globalMax = new int[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                localMax[j - 1][j] = Integer.MIN_VALUE;
                globalMax[j - 1][j] = Integer.MIN_VALUE;
                localMax[i][j] = Math.max(localMax[i - 1][j], globalMax[i - 1][j - 1]) + nums[i - 1];
                globalMax[i][j] = Math.max(localMax[i][j], globalMax[i - 1][j]);
            }
        }
        return globalMax[len][k];
    }
}
