package com.liyi.algorithm.dynamic.backpack;

/*题意:
        • 给定N个正整数：A0,A1, …, AN-1
        • 一个正整数Target
        • 求有多少种组合加起来是Target
        • 每个Ai
        可以用多次
*/
public class BackPack6 {
    public static void main(String[] args) {
        //A = [1, 2, 4], Target = 4

        System.out.println(backpack6(new int[]{1,2,4},4));
        //6（1+1+1+1=4,
        //   2+2=4,
        //   1+1+2=4,
        //   1+2+1=4,
        //   2+1+1=4,
        //   4=4）

        //f(4) =  6, f(1) = 1, f(2) = 2,f(3) = 3(1,1,1),(1,2),(2,1) f(4) = f(1) + f(2) + f(3)

    }

    //可以无限多次使用，参考 coins change 2，5，7硬币， 凑成 27块有几种方法
    public static int backpack6(int[] A, int target){
        if(A == null || A.length == 0){
            return 0;
        }

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int i = 1; i <= target; i++){
            for(int j = 0; j < A.length; j++){
                if(i - A[j] >= 0){
                    dp[i] += dp[i - A[j]];
                }
            }
        }

        return dp[target];
    }
}
