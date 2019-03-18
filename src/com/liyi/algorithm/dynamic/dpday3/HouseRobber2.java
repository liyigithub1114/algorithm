package com.liyi.algorithm.dynamic.dpday3;

/**
 * 小偷偷的房子组成了一个圈，头和尾相邻，求最多能偷多少金币
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(getMax(new int[]{1,7,9,2}));
    }
    public static int getMax(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        int res1;
        for(int i = 0;i<nums.length - 1;i++){
            if(i == 0){
                dp1[i] = nums[i];
            }else if(i == 1){
                dp1[i] = Math.max(nums[i],nums[i-1]);
            }else{
                dp1[i] = Math.max(dp1[i-1],dp1[i-2] + nums[i]);
            }
        }
        res1 = dp1[dp1.length - 1];
        int index = 0;
        for(int i =1;i<nums.length ;i++){
            if(i ==1 ){
                dp2[index++] = nums[i];
            }else if(i == 2){
                dp2[index++] = Math.max(nums[i],nums[i-1]);
            }else{
                dp2[index] = Math.max(dp2[index - 1],dp2[index - 2] + nums[i]);
                index++;
            }
        }
        return Math.max(res1,dp2[index- 1]);
    }
}
