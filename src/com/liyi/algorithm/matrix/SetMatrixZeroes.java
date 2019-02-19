package com.liyi.algorithm.matrix;

/**
 * 二维数组
 * [
 *      1,1,1
 *      1,0,1
 *      1,1,1
 * ]
 *
 * 转换成
 * [
 *      1,0,1
 *      0,0,0
 *      1,0,1
 * ]
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {

    }
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;
        boolean flagX = false;
        boolean flagY = false;
        int lenX = matrix.length;
        int lenY = matrix[0].length;
        for(int i =0;i<lenX;i++){
            for(int j =0;j<lenY;j++){
                if(matrix[i][j] == 0){
                    if(i==0) flagX = true;
                    if(j==0) flagY = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i =1;i<lenX;i++){
            for(int j =1;j<lenY;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] =0;
                }
            }
        }
        if(flagX){
            for(int i=0;i<lenY;i++){
                matrix[0][i] = 0;
            }
        }
        if(flagY){
            for(int i =0;i<lenX;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
