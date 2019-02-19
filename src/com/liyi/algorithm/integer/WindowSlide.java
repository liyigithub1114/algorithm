package com.liyi.algorithm.integer;

import java.util.Arrays;
import java.util.LinkedList;

public class WindowSlide {
    public static void main(String[] args) {
        getMax(new int[]{1,2,3,4,3,3,6,7},3);
    }

    public static void getMax(int[] arr,int size){
        if(arr == null || arr.length == 0 || arr.length < size || size < 1) return ;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new  int[arr.length - size + 1];
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            while(!list.isEmpty() && arr[list.peekLast()] <= arr[i]){
                list.pollLast();
            }
            list.add(i);
            if(list.peekFirst() == i-size ){
                list.pollFirst();
            }
            if(i >= size - 1){
                res[index++] = arr[list.peekFirst()];
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
