package com.liyi.algorithm.strings;

import java.util.Stack;

/**
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"], --> 3,1,3,2,2
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaxRectangle {
    public static void main(String[] args) {
        char temp = '0';
        System.out.println(temp+0);
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
                if(matrix[i][j] == '0'){
                    rectangle[j] = 0;
                }else{
                    rectangle[j] += matrix[i][j];
                }
            }
            res = Math.max(res,getMax(matrix));
        }
        return res;
    }

    public static int getMax(int[] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        return res;
    }
}
