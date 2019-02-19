package com.liyi.algorithm.greedy;

public class maxMulSubArr {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,-2,-1,-4};
        System.out.println(multipy(arr));
    }

    public static int getMaxMultipy(int[] nums){
        if(nums == null || nums.length ==0) return 0;
        if(nums.length < 3) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int len = nums.length;
        for(int i =1;i<len;i++){
            max = max * nums[i];
            min = min * nums[i];

            max = Math.max(Math.max(max,min),nums[i]);
            min = Math.min(Math.min(max,min),nums[i]);

            res = Math.max(max,res);
        }
        return res;
    }


    public static int multipy(int[] nums){
        if(nums == null || nums.length == 0 || nums.length < 3) return 0;
        int res = 0;
        int len = nums.length;
        // max1 > max2 > max3
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        //min1 < min2
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i =0;i<len;i++){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }

            if(nums[i] < min1){
                //比 min1小，min1把值给min2,min1接收更小的
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                // 比min1 大，比min2小
                min2 = nums[i];
            }
        }

        return max1 * max2 * max3 > max1 * min1 * min2 ? max1*max2*max3 : min1*min2*max1;
    }
}
