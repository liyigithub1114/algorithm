package com.liyi.algorithm.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3
 * 原问题已AC ，用时39ms  学完窗口滑动用双指针+map刚一波 24ms
 */
public class MaxDifferenceString {
    public static void main(String[] args) {
        String str ="pwwkew";
        System.out.println(getMaxString(str));
    }
    public static int getMaxString(String s){
        if(s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int len = s.length();
        Map<Character,Integer> map = new HashMap<>();
        while(left < len && right < len){
            char temp = s.charAt(right);
            if(map.containsKey(temp) && map.get(temp) >= left){
                left = map.get(temp)+1;
                map.put(temp,right);
                right++;
                maxLen = Math.max(maxLen,right-left);
            }else{
                map.put(temp,right);
                right++;
                maxLen = Math.max(maxLen,right-left);
            }
        }
        return maxLen;
    }
}
