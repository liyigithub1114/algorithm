package com.liyi.algorithm.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 将二维矩阵以螺旋方式打印
 *
 * 1 2 3            1 2 3 6 9 8 7 4 5
 * 4 5 6
 * 7 8 9
 *
 * 1  2  3  4        1 2 3 4 8 12 11 10 9 5 6 7
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 *
 */
public class PrintRotateMatrix {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6}};

        print(nums);
    }

    public static List<Integer> print(int[][] nums){
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int startX = 0;
        int startY = 0;
        int endX = nums.length -1;
        int endY = nums[0].length -1;

        while(startX <= endX && startY <= endY){
            if(startX == endX){
                while(startY <= endY){
                    res.add(nums[startX][startY++]);
                }
            }
            if(startY == endY){
                while(startX <= endX){
                    res.add(nums[startX++][startY]);
                }
            }
            int curX = startX;
            int curY = startY;
            while(curY < endY){
                res.add(nums[curX][curY++]);
            }
            while(curX < endX){
                res.add(nums[curX++][endY]);
            }
            while(curY > startY){
                res.add(nums[endX][curY--]);
            }
            while(curX > startX){
                res.add(nums[curX--][startY]);
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        System.out.println(res);
        return res;
    }
}
