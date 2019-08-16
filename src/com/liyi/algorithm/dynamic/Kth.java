package com.liyi.algorithm.dynamic;

public class Kth {
    public static void main(String[] args) {

        int[] A = new int[] { 1, 2, 3, 4, 5 };
        int[] B = new int[] { 6, 7, 8, 9, 10};
        //System.out.println(findMedianSortedArrays(A, B));
        // 输入 5th 要让他找A[4]；
        System.out.println(kth(A, 0, B, 0, 7));
    }


    //找两有序数组排好序后的第K个数
    public static int kth(int[] A,int indexA, int[] B, int indexB, int k){

        if(indexA >= A.length){
            return B[indexB + k - 1];//第k个数 A【k - 1】
        }

        if(indexB >= B.length){
            return A[indexA + k - 1];
        }

        if(k == 1){
             return Math.min(A[indexA], B[indexB]);//第k个数，最小的那个就是
        }
        //获取第k个数的一半的前一个数
        int halfA = indexA + k / 2 - 1 >= A.length ? Integer.MAX_VALUE : A[indexA + k / 2 - 1];

        int halfB = indexB + k / 2 - 1 >= B.length ? Integer.MAX_VALUE : B[indexB + k / 2 - 1];

        if(halfA > halfB){
            //A大，丢弃B
            return kth(A, indexA, B, indexB + k / 2 , k - k / 2);
        }else{
            return kth(A, indexA + k / 2, B, indexB, k - k / 2);
        }
    }
}
