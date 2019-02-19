package com.liyi.algorithm.strings;


/**
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinimumWindowSubString {
    public static void main(String[] args) {

    }
    public static String  getWindow(String s,String t){
        if(s == null || t == null || s.length() < t.length()) return "";
        int lenS = s.length();
        int lenT = t.length();
        int left = 0;
        int right = 0;
        while(left < lenS && right < lenS){

        }
        return "";
    }
}
