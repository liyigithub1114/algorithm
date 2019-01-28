package com.liyi.algorithm.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RotateMatrix {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    return o2-o1;
                }
            });
            int len = in.nextInt();
            for(int i = 0;i<len;i++){
                queue.add(in.nextInt());
            }

            int m = 0;
            int n = 0;
            int res = Integer.MAX_VALUE;
            for(int i =1;i<=Math.sqrt(len);i++){
                if(len % i == 0){
                    if(res > len / i - i){
                        res = len / i - i;
                        m = len / i ;
                        n = i;
                    }
                }
            }

            int[][] arr = new int[m][n];
            int startX = 0;
            int startY = 0;
            int endX = m-1;
            int endY = n-1;
            while(!queue.isEmpty()){
                while(startX <= endX && startY <= endY){
                    if(startX == endX){
                        for(int i =startY;i<=endY;i++){
                            arr[startX][i] = queue.poll();
                        }
                    }else if(startY == endY){
                        for(int i = startX;i<=endX;i++){
                            arr[i][startY] = queue.poll();
                        }
                    }else{
                        int curX = startX;
                        int curY = startY;

                        while(curY != endY){
                            arr[startX][curY] = queue.poll();
                            curY++;
                        }
                        while(curX != endX){
                            arr[curX][endY] = queue.poll();
                            curX++;
                        }
                        while(curY != startY){
                            arr[endX][curY] = queue.poll();
                            curY--;
                        }
                        while(curX != startX){
                            arr[curX][startY] = queue.poll();
                            curX--;
                        }
                    }
                    startX ++;
                    startY ++;
                    endX --;
                    endY --;
                }
            }

            for(int i =0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if(j== n-1){
                        System.out.println(arr[i][j]);
                    }else{
                        System.out.print(arr[i][j]+" ");
                    }
                }
            }
            in.close();
        }
}
