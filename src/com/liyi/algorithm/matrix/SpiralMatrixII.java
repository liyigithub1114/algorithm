package com.liyi.algorithm.matrix;

public class SpiralMatrixII {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
        if(n == 0) return new int[][]{};
        int[][] res = new int[n][n];
        int startX = 0;
        int startY = 0;
        int endX = n-1;
        int endY = n-1;
        int index = 1;
        while(startX <= endX && startY <= endY){
            if(startX == endX){
                while(startY <= endY){
                    res[startX][startY++] = index++;
                }
            }
            if(startY == endY){
                while(startX <= endX){
                    res[startX++][startY] = index++;
                }
            }
            int curX = startX;
            int curY = startY;
            while(curY < endY){
                res[curX][curY++] = index++;
            }
            while(curX < endX){
                res[curX++][curY]  = index++;
            }
            while(curY > startY){
                res[curX][curY--] = index++;
            }
            while(curX > startX){
                res[curX--][curY] = index++;
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return res;
    }
}
