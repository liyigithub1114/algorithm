package com.liyi.algorithm.matrix;

/**
 * 从排序数组中获取非重复元素的总长度
 * [0,0,0,0,0,1,1,1,1,2,2,2]
 * return 3 [0,1,2],前三位必须是0，1，2后面随意
 */
public class RemoveDupFromSortArr {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,1,1,1,1,2,2,2};
        //1,2,1,3,3,4,4,5
        System.out.println(remove(nums));
    }

    public static int remove(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        int len = nums.length ;
        int index = 1;
        count++;
        for(int i =1;i<len;i++){
            if(nums[i] == nums[i-1]){
                continue;
            }else{
                count++;
                nums[index++] = nums[i];
            }
        }
        return count;
    }

    public static void swap(int[] nums,int i,int j){
        if(i!=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
