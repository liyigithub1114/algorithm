package com.liyi.algorithm.matrix;

public class ZigZagPrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }

    private static void printMatrixZigZag(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int startX = 0;
        int startY = 0;
        int secondX = 0;
        int secondY = 0;
        int endX = matrix.length -1;
        int endY = matrix[0].length - 1;
        boolean flag = false;
        while(startX <= endX){
            printLevel(matrix,startX,startY,secondX,secondY,flag);
            startX = startY == endY ? startX+1:startX;
            startY = startY == endY ? startY : startY+1;
            secondY = secondX == endX ? secondY+1:secondY;
            secondX = secondX == endX ? secondX:secondX+1;
            flag = !flag;
        }
    }

    public static void printLevel(int[][] matrix,int startX,int startY,int secondX,int secondY,boolean flag){
        if(flag){
            while(startX <= secondX){
                System.out.print(matrix[startX++][startY--]+" ");
            }
        }else{
            while(secondX >= startX){
                System.out.print(matrix[secondX--][secondY++]+" ");
            }
        }
    }
}
