package com.liyi.algorithm.dynamic.dpday2;

/***
 * • 题意：
 * • 给定a[0], …, a[n-1]
 * • 找到最长的连续子序列i, i+1, i+2, …, j,  使得a[i]<a[i+1]<…<a[j]，或者 a[i]>a[i+1]>…>a[j]，输出长度j-i+1
 * • 例子：
 * • 输入：[5, 1, 2, 3, 4]
 * • 输出：4  (子序列1, 2, 3, 4)
 */
public class LongestIncreasingContinuousSubsequence {
    public static void main(String[] args) {
        getLong(new int[]{1,3,5,4,7});
    }

    private static int res = Integer.MIN_VALUE;
    /**
     * 分析。
     * 比如例子中的4，要求4的长度，则判断 nums[i] > nums[i-1] ? f(i-1) + 1 : 1
     *
     * 不仅是递增，还有递减，反过来再求一次就行
     */
    public static int getLong(int nums[]){
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        getMaxLong(nums,dp);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        getMaxLong(nums,dp);
        return res;
    }

    public static void getMaxLong(int[] nums,int[] dp){
        for(int i = 0;i<nums.length;i++){
            if(i == 0){
                dp[i] = 1;
            }else{
                dp[i] = nums[i] > nums[i-1] ? dp[i-1] + 1 : 1;
            }
            if(dp[i] > res){
                res = dp[i];
            }
        }
    }
}
