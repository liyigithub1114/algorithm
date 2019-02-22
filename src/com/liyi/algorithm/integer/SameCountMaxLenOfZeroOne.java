package com.liyi.algorithm.integer;

/**
 * 获得最大子数组长度，要求子数组中0和1数量相等
 */
public class SameCountMaxLenOfZeroOne {
    public static void main(String[] args) {
        //[0,1,0,1,1,0,0,1],0,0
        int[] arr =new int[]{0,1,0,1,1,0,0,1,0,0,0,0,0,0,0};
        getMaxLen(arr);
    }

    public static void getMaxLen(int[] arr){
        if(arr == null || arr.length <0) return ;
        int left = 0;
        int right = 0;
        int len = 0;
        int countZero = 0;
        int countOne = 0;
        int resLeft = 0;
        int resRight = 0;
        while(left < arr.length){
            while(right < arr.length){
                if(arr[right++] == 0){
                    countZero++;
                }else{
                    countOne++;
                }
                if(countOne == countZero && len<=(right-left)){
                    len = right  - left;
                    resLeft = left;
                    resRight = right-1;
                }
            }
            if(arr[left++] == 0){
                countZero--;
            }else{
                countOne--;
            }
            right = resRight+1;
            for(int i =right;i<arr.length;i++){
                if(arr[i] == 0) {
                    countZero --;
                }else{
                    countOne --;
                }
            }
        }
        System.out.println("len = "+ len+" left =" + "left =" +resLeft + " right = "+ resRight);
    }
}
