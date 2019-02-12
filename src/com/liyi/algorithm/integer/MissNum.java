package com.liyi.algorithm.integer;

/**
 *
 */
public class MissNum {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        //无序 含有0，正数，负数等 寻找缺失的最小正整数
        //missNum(arr);

        //无序正整数 0-N
        missNum2(arr);
    }

    public static void missNum(int[] arr) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            if (arr[start] == start + 1) {//合法数据，已经排好序的1，2，3等等
                start++;
            } else if (arr[start] <= start || arr[start] > end || arr[arr[start] - 1] == arr[start]) {//不合法数据  arr[arr[start] - 1] == arr[start] 这个代表是否出现重复值
                arr[start] = arr[--end];//将最后的数往start上放 ，抛弃start上不合法的数
            } else {
                swap(arr, start, arr[start] - 1);//合法的数但是位置不对
            }
        }
        System.out.println(start+1);
    }

    public static int missNum2(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int len = arr.length;
        int start = 0;
        while(start < len){
            if(arr[start] == start ){
                start ++;
            } else if(arr[start] >= len || arr[arr[start]] == arr[start]){
                arr[start] = arr[--len];
            }else{
                swap(arr,start,arr[start]);
            }
        }
        System.out.println(start);
        return start;
    }

    public static void swap(int[] arr,int i ,int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
