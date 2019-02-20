package com.liyi.algorithm.strings;

import java.util.Stack;

/**
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"], --> 3,1,3,2,2----> 单调栈  栈底到栈顶，由小到大
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * [[],["],[],[],["]]
 */
public class MaxRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','1','1'}, // 10111
                                       {'0','1','0','1','0'}, // 01020
                                       {'1','1','0','1','1'}, //
                                       {'1','1','0','1','1'},
                                       {'0','1','1','1','1'}};
        System.out.println(getMax(matrix));
    }

    /**
     *单调栈问题
     *
     */
    public static int getMax(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int lenX = matrix.length;
        int lenY = matrix[0].length;
        int[] rectangle = new int[lenY];
        for(int i =0;i<lenX;i++){
            for(int j =0;j< lenY;j++){
                rectangle[j] = matrix[i][j] == '0' ? 0 : rectangle[j] + 1;
            }
            res = Math.max(res,getMax(rectangle));
        }
        return res;
    }

    /**
     *
     * \    \
     * \  5  \  4 要进入，弹出，5，4 计算5和4   向左  向右能扩容的最大距离
     * \  4  \    5：向左能扩的最大距离肯定等于 即将要进入的4的最大距离,其实只要求最后一个弹出到 index的距离 nums[index] = 4（要进入的）
     * \__3__\
     */
    public static int getMax(int[] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i =0;i<matrix.length;i++){
            while(!stack.isEmpty() && matrix[i] <= matrix[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1:stack.peek() ;
                int temp = (i-k-1) * matrix[j];
                res = Math.max(res,temp);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1:stack.peek() ;
            int temp =(matrix.length-k-1) * matrix[j];
            res = Math.max(res,temp);
        }
        return res;
    }
}
