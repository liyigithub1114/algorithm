package com.liyi.algorithm.bitcalculate;

import java.util.ArrayList;
import java.util.List;

//给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
public class MajorityNumber {
    public static void main(String[] args) {

    }

    public int majorityNumber(List<Integer> nums) {
        if(nums == null){
            return -1;
        }

        int size = nums.size() / 2 + 1;
        int res = 0;
        int[] bit = new int[32];
        int sum = 0;
        for(int i = 0; i < bit.length; i++){
            sum = 0;
            for(int j = 0; j < nums.size(); j++){
                if(((nums.get(j) >> i) & 1) == 1){
                    sum++;
                }
            }

            if(sum >= size){
                res |= (sum / size) << i;
            }
        }

        return res;
    }

    public int majorityNumber(ArrayList<Integer> nums) {
        //由于主元素在数组中个数严格大于1/2，所以假设当前元素就是主元素，用count记录当前元素个数与其他元素个数的差值，
        //candidate记录当前元素是什么，最后count一定为正数并且candidate就是主元素
        int count = 0, candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
