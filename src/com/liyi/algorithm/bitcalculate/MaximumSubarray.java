package com.liyi.algorithm.bitcalculate;

public class MaximumSubarray {
    public static void main(String[] args) {

    }
    public static int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录区间和，如果当前sum>0，那么可以继续和后面的数求和，否则就从0开始
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}
