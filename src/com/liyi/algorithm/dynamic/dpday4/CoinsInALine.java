package com.liyi.algorithm.dynamic.dpday4;

public class CoinsInALine {
    public static void main(String[] args) {
        //coins in a line

        System.out.println(coinsInALine(8));

    }


    //博弈dp 要从前往后看 f(0) = false; f(1) = true; f(2) = true; f(3) = false;
     public static boolean coinsInALine(int n){
        if(n == 0){
            return false;
        }

        if(n <= 2){
            return true;
        }

        boolean[] dp = new boolean[n + 1];
        for(int i = 0; i <= n; i++){
            if(i == 0){
                dp[i] = false;
            }else if(i == 1){
                dp[i] = true;
            }else if(i == 2){
                dp[i] = true;
            }else{
                //看拿一个石子后对方能不能赢，对方不能赢 f(x - 1) = false,我就能赢
                //看那两个石子后对方能不能赢，f(x - 2)

                dp[i] = dp[i - 1] == false || dp[i - 2] == false;
            }
         }

         return dp[n];
    }
}
