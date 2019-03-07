package com.liyi.algorithm.bitcalculate;

/**
 * 在数组中找到两个出现了奇数次的数
 * 2，2，1，4，4，3
 *
 * 打印1，3
 */
public class FindOdd2 {

    public static void main(String[] args) {
        System.out.println(printOddTimesNum2(new int[]{2,1,3,3,1,4}));
    }
    public static String printOddTimesNum2(int[] arr){
        int eO = 0, eOhasOne = 0;
        for (int cur:arr){
            eO = eO ^ cur;
        }
        int rightOne = eO & (~eO + 1);
        for (int cur:arr){
            if((cur & rightOne) != 0){
                eOhasOne = eOhasOne ^ cur;
            }
        }
        return eOhasOne + " " + (eO ^ eOhasOne);
    }
}
