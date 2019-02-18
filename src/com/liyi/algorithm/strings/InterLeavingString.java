package com.liyi.algorithm.strings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定s1，s2，s3，找出s3是否由s1和s2的交织形成。
 */
public class InterLeavingString {

    public static void main(String[] args) {
        String s1 = "aabc";
        String s2 = "abad";
        String s3 = "aabcabad";
        String s4 = "";
        String s5 = "";
        System.out.println(s4.equals("2"));
        System.out.println(isInterLeaving(s1,s2,s3,0,0,0));

        System.out.println(17 % 3);
    }
    //
    public static boolean isInterLeaving(String s1,String s2,String s3,int s1Index,int s2Index,int s3Index){
        if(s1Index + s2Index == s3.length()) return true;
        char c3 = s3.charAt(s3Index);
        if(s1Index < s1.length() && s2Index < s2.length() && s1.charAt(s1Index) == s2.charAt(s2Index) && s1.charAt(s1Index) == c3){
            boolean flag = isInterLeaving(s1,s2,s3,s1Index+1,s2Index,s3Index+1);
            if(flag){
                return true;
            }else{
                flag = isInterLeaving(s1,s2,s3,s1Index,s2Index+1,s3Index+1);
                if(flag){
                    return true;
                }
            }
        }else if(s1Index < s1.length() && s1.charAt(s1Index) == c3){
            return isInterLeaving(s1,s2,s3,s1Index+1,s2Index,s3Index+1);
        }else if(s2Index < s2.length() & s2.charAt(s2Index) == c3){
            return isInterLeaving(s1,s2,s3,s1Index,s2Index+1,s3Index+1);
        }
        return false;
    }
}

