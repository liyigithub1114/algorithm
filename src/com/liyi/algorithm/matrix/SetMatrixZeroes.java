package com.liyi.algorithm.matrix;

/**
 * [ 1,0,1
 *   1,1,1
 *   1,1,1
 *  ]
 *  [
 *  0,0,0
 *  1,0,1
 *  1,0,1
 *  ]
 *
 */


import java.util.Arrays;

/**
 * 二维数组 ，里面只有1和0  如果某个位置是0，则他的整行和整列设置为0
 *
 * [
 *     1,1,1
 *     1,0,1
 *     1,1,1
 * ]
 *
 * 变成
 *
 * [
 *      1,0,1
 *      0,0,0
 *      1,0,1
 * ]
 *
 *
 [
    0,1,2,0
    3,4,5,2
    1,3,1,5
 ]
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},
                                     {1,0,1},
                                     {1,1,1}};
        setMatrixZeroes(matrix);

        System.out.println(Arrays.toString(matrix));
    }

    public static void setMatrixZeroes(int[][] matrix){
        boolean fr = false,fc = false;
        //如果matrix[i][j] == 0 则把它这行的第一个 matrix[i][0]  和这列的 第一个 matrix[0][j]置0 ,代表。这行或者这列需要被置0
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
