package com.liyi.algorithm.integer;

/**
 * 利用归并排序求数组小和
 *
 * 1，3，5 ，2，4，6
 *              （全排列）
 * 1和2比  1小 得到1
 * 3和2比  2小 无
 * 3和4比  3小 得到 6
 * 5和4比  4小 无
 * 5和6比  5小 得到5
 *
 */
public class SmallSum {

    public static void main(String[] args) {
//        int[] arr= new int[]{1,3,5,2,4,6};
//        int merge = getMerge(arr, 0, arr.length - 1);
//        System.out.println(merge);
    }

    public static int getMerge(int[] arr,int L,int R){
        if(arr == null || arr.length < 0) return 0;
        if(L!=R){
            int mid = L + ((R-L)>>1);
            return getMerge(arr,L,mid) + getMerge(arr,mid+1,R) +merge(arr,L,mid,R);
        }else{
            return 0;
        }
    }

    public static int merge(int[] arr,int L,int mid,int R){
        int[] res = new int[R-L+1];
        int leftIndex = L;
        int rightIndex = mid+1;
        int smallSum = 0;
        int resIndex = 0;
        while(leftIndex <= mid && rightIndex <= R){
            if(arr[leftIndex] < arr[rightIndex]){
                smallSum += arr[leftIndex] * (R-rightIndex +1);
                res[resIndex++] = arr[leftIndex++];
            }else{
                res[resIndex++] = arr[rightIndex++];
            }
        }
        while(leftIndex <= mid){
            res[resIndex++] = arr[leftIndex++];
        }
        while(rightIndex <= R){
            res[resIndex++] = arr[rightIndex++];
        }
        for(int i =0;i<resIndex;i++){
            arr[L+i] = res[i];
        }
        System.out.println(smallSum);
        return smallSum;
    }
}
