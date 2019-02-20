package com.liyi.algorithm.matrix;

/**
 * 输入有序的数组，删除重复的元素直到此元素还剩两个，输出最后对的长度以及长度内的元素
 * [1,1,1,1,1,2,2,3,3,3,4,5,5]
 * 输出
 * [1,1,2,2,3,3,4,5,5] len = 9
 */
public class RemoveDupFromSortArr2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,5,5,5,5,6,6};
        System.out.println(remove(nums));
    }

    public static int remove(int[] nums){
        if(nums == null || nums.length == 0 )return 0;
        int count = 1;
        boolean isTwo = false;
        int len = nums.length;
        int index = 1;
        for(int i = 1;i<len;i++){
            if(nums[i] == nums[index-1]){
                if(!isTwo){
                    count++;
                    nums[index++] = nums[i];
                    isTwo = true;
                }
            }else{
                count++;
                nums[index++] = nums[i];
                isTwo = false;
            }
        }
        return count;
    }
}
