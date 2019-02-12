package com.liyi.algorithm.integer;

/**
 * 描述  求 子数组所有的值累加和=K的 最长子数组
 */
public class MaxLenOfChildEqualK {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,1,1,1,-2,1,1,1,3,2,1,1,1,1,1,-1,1};
        int k = 5;
        getMaxLenFormWindowSlide(arr,k);
    }

    public static void getMaxLenFormWindowSlide(int[] arr,int k){
        if(arr == null || arr.length < 0) return ;
        int left = 0;
        int right = 0;
        int len = 0;
        int sum = 0;
        int resLeft = 0;
        int resRight = 0;
        while(left < arr.length && left <= right){
            while(right < arr.length){
                if(sum + arr[right] <= k){
                    sum += arr[right++];
                }else{
                    break;
                }
            }
            if((right - left ) > len && sum == k){
                len = right-left;
                resLeft = left;
                resRight = right -1;
            }
            sum -= arr[left];
            left++;
        }
        System.out.println("len = " + len +" left = " + resLeft +" right = "+ resRight);
    }
}
