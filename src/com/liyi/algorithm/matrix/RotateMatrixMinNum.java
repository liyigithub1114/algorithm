package com.liyi.algorithm.matrix;

/**
 * 一个有序的一维数组 可能旋转可能不旋转，里面的值有可能重复 ，找出最小值
 *
 * 使用二分查找 log(n)，最差情况  arr[i] = num  O(n)
 */
public class RotateMatrixMinNum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1};
        getMin(nums);
    }

    /**
     * 1. nums[low] < nums[high]  证明 断点在 low上
     *
     * 2. nums[low] > nums[mid]  4 >2 断点在low - mid上 high = mid;
     *    nums[high] < nums[mid]  4 < 2 断点在 mid - high上 low = mid
     *
     */
    public static void getMin(int[] nums){
        if(nums == null && nums.length == 0) return ;
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            if(low == high-1){
                break;
            }
            if(nums[low] < nums[high]){
                System.out.println(nums[low]);
                break;
            }
            int mid = low + (high-low)/2;
            if(nums[low] > nums[mid]){
                high = mid;
                continue;
            }
            if(nums[high] < nums[mid]){
                low = mid;
                continue;
            }
            //如以上三条都没有命中，只有一种可能 nums[low] = nums[high] = nums[mid]
            while(low < mid){
                if(nums[low] == nums[mid]){
                    low++;
                    continue;
                }else if(nums[low] > nums[mid]){
                    high = mid;
                    break;
                }else{
                    //nums[low] < nums[mid]
                    System.out.println(nums[low]);
                    return;
                }
            }
        }
        System.out.println(Math.min(nums[low],nums[high]));
    }
}
