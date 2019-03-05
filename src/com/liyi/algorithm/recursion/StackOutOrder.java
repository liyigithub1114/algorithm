package com.liyi.algorithm.recursion;

import java.util.Stack;

/**
 * 给定一个数组，求可能出栈顺序
 * stack.push(i)过后
 * 两种操作，1。stack.push(i+1)
 *           2。stack.pop()     ==  stack弹出 i
 */
public class StackOutOrder {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        order(nums,new Stack<>(),0,"");
    }

    public static void order(int[] nums, Stack<Integer> stack,int index,String res){
        Stack<Integer> temp = (Stack<Integer>) stack.clone();
        temp.push(nums[index]);
        if(index + 1 == nums.length){
            while(!temp.isEmpty()){
                res += temp.pop() +"";
            }
            System.out.println(res);
        }else{
            order(nums,temp,index+1,res);
            while(!temp.isEmpty()){
                res += temp.pop()+"";
                order(nums,temp,index+1,res);
            }
        }
    }
}
