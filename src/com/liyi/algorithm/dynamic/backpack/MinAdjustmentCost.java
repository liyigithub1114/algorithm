package com.liyi.algorithm.dynamic.backpack;

import java.util.List;

public class MinAdjustmentCost {
    public static void main(String[] args) {

    }
    public int MinAdjustmentCost(List<Integer> A, int target) {
        if(A == null || A.isEmpty()){
            return 0;
        }

        int[][] dp = new int[A.size() + 1][101];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                for(int k = j - target; k <= j + target; k++){
                    if(k < 0 || k > 100){
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i - 1)));
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < 101; i++){
            res = Math.min(res, dp[dp.length - 1][i]);
        }

        return res;
    }
}
