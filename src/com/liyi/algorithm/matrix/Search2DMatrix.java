package com.liyi.algorithm.matrix;

/**
 * 在排好序的二维数组中 查看是否含有target
 */
public class Search2DMatrix {
    public static void main(String[] args) {

    }

    public static boolean search(int[][] matrix ,int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int x = 0;
        int y = matrix[0].length - 1;
        while(x < matrix.length && y > -1){
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] > target){
                y--;
            }else if(matrix[x][y] < target){
                x++;
            }
        }
        return false;
    }
}
