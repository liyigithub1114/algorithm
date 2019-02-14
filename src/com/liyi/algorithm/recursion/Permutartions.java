package com.liyi.algorithm.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutartions {
    public static void main(String[] args) {
        permutation(new int[]{1,2,3},0);
        System.out.println("----------------");
        permutations2(new int[]{1,1,3},0);
    }

    public static void permutation(int[] nums ,int i){
        if(i == nums.length){
            System.out.println(Arrays.toString(nums));
        }
        for(int j = i;j<nums.length;j++){
            swap(nums,i,j);
            permutation(nums,i+1);
            swap(nums,i,j);
        }
    }

    public static void swap(int[] nums, int i,int j){
        if(i == j || nums[i] == nums[j]) return ;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void swap1(int[] nums,int i, int j ){
        if(i==j || nums[i] == nums[j]) return ;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void permutations2(int[] nums,int i ){
        if(i == nums.length){
            System.out.println(Arrays.toString(nums));
        }
        Set<Integer> set = new HashSet<>();
        for(int j = i;j<nums.length;j++){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
                swap1(nums,i,j);
                permutations2(nums,i+1);
                swap1(nums,i,j);
            }
        }
    }
}
