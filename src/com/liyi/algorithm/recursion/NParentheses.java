package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号问题， 比如输入3 ，返回
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class NParentheses {
    public static void main(String[] args) {
        parentheses(3);
    }

    public static List<String> parentheses(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        get(res,0,0,"",n);

        System.out.println(res.toString());
        return res;
    }


    public static void get(List<String> res , int open ,int close,String str,int n){
        if(str.length() == n *2 ){
            res.add(str);
            return ;
        }

        if(open < n ){
            get(res,open+1,close,str+"(",n);
        }
        if(open > close){
            get(res,open,close+1,str+")",n);
        }
    }
}
