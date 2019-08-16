package com.liyi.algorithm.bitcalculate;

import java.util.List;

public class MajorityNumber2 {
    public static void main(String[] args) {

    }
    public int majorityNumber(List<Integer> nums) {
        if(nums == null || nums.isEmpty()){
            return -1;
        }

        int res1 = 0, res2 = 0;
        int count1 = 0, count2 = 0;
        //注意一下判断条件，先count1,res1 反过来也行，
        for(int i = 0; i < nums.size(); i++){
            if (count1 == 0) {
                res1 = nums.get(i);
                count1 = 1;
            } else if (res1 == nums.get(i)) {
                count1 ++;
            } else if (count2 == 0) {
                res2 = nums.get(i);
                count2 = 1;
            } else if (res2 == nums.get(i)) {
                count2 ++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for(int i = 0;i < nums.size(); i++){
            if(res1 == nums.get(i)){
                count1++;
            }else if(res2 == nums.get(i)){
                count2++;
            }
        }

        return count1 > count2 ? res1 : res2;
    }
}
