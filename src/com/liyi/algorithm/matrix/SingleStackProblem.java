package com.liyi.algorithm.matrix;

import java.util.Stack;

/**
 * 单调栈问题，在一个递增或者递减的栈中，可以找到任意一个数 左边比他小，右边比他大的第一个数
 */
public class SingleStackProblem {
    public static void main(String[] args) {


        //问题1 ，对于这样的一个数组，求1组成的最大面积
        int[][] matrix = new int[][]{{1,0,1,1},
                                     {1,1,1,1},
                                     {1,1,1,0}};
        problem1(matrix);

    }

    /**
     *    1  0  1  1
     *    1  1  1  1
     *    1  1  1  0
     *
     *    将以上数组改成  3，2，3，0  matrix[i][j]==0 ? 0 : height[j]+1
     */
    public static void problem1(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;
//        int[] height = new int[matrix[0].length];
        int maxArea = 0;
//        for(int i =0;i<matrix.length;i++){
//            for(int j = 0;j<matrix[0].length;j++){
//                height[j] = matrix[i][j] == 0 ? 0:height[j]+1;
//            }
//        }
        Stack<Integer> stack = new Stack<>();//3,4,5,4,3,6
        int[] height = new int[]{3,4,5,4,3,6};
        for(int i = 0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1:stack.peek();
                maxArea = Math.max((i-k-1 )* height[j],maxArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max((height.length - k - 1) * height[j] ,maxArea);
        }
        System.out.println(maxArea);
    }
}
