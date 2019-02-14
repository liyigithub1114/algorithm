package com.liyi.algorithm.strings;

import java.util.Stack;


/**
 * 求规则内 最长的括号长度
 *
 * 维护一个栈  遍历字符串   遇到 ) 比 ( 多， 将之前的结算，open = close = 0(清空栈操作) 这样操作后，剩下的肯定是 ( 多余 )
 *
 * 遍历栈 ，遇到 ( 比 ) 多，结算 open = close = 0(清空指针操作)  遇到 ) 多余 ( 不管，知道 open = close结算
 */
public class LongestParentheses {
    public static void main(String[] args) {

        String string = "(()"; // 2
        String string2 = ")(()))())";// 4
        String string3 = "()((())((";
        longest(string);
        longest(string2);
        longest(string3);
    }

    public static int longest(String s){
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        Stack<String> stack = new Stack<>();
        int open = 0;
        int close = 0;
        int len = s.length();
        for(int i =0;i<len;i++){
            if('(' == s.charAt(i)){
                open++;
            }else{
                close++;
            }

            if(open < close){
                close--;
                stack.clear();
                res = Math.max(res, open + close);
                open = 0;
                close = 0;
            }else if(open >= close){
                stack.push(s.charAt(i)+"");
            }
        }
        open = 0;
        close = 0;
        while(!stack.isEmpty()){
            String pop = stack.pop();
            if("(".equals(pop)){
                open++;
            }else{
                close++;
            }

            if(open>close){
                open--;
                res = Math.max(res, open+close);
                open = 0;
                close =0;
            }else if(open == close){
                res = Math.max(res, open+close);
            }
        }
        System.out.println(res);
        return res;
    }
}
