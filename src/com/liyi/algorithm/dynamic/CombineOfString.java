package com.liyi.algorithm.dynamic;


public class CombineOfString {
    //一个字符串能分成多少个字串,递归
    public static void main(String[] args) {
        String srt="abc";
        getCombine(srt.toCharArray(),0,"");
    }

    public static void getCombine(char[] chars,int i,String res ){
        if(i == chars.length){
            System.out.println(res);
            return ;
        }
        getCombine(chars,i+1,res);
        getCombine(chars,i+1,res+=String.valueOf(chars[i]));
    }
}
