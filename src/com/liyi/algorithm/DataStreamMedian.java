package com.liyi.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {
    public static void main(String[] args) {

    }

    public int[] medianII(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        //大根堆，返回较小一部分中大的那个
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){

            if(maxHeap.isEmpty() || nums[i] <= maxHeap.peek()){
                maxHeap.offer(nums[i]);
            }else{
                minHeap.offer(nums[i]);
            }

            balance(maxHeap, minHeap);

            res[i] = maxHeap.peek();
        }

        return res;
    }

    public void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap){
        while(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

        while(minHeap.size() < maxHeap.size() - 1){
            minHeap.offer(maxHeap.poll());
        }
    }
}
