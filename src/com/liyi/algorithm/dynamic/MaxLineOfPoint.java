package com.liyi.algorithm.dynamic;


import java.util.HashMap;
import java.util.Map;

/**
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 *
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */

public class MaxLineOfPoint {
    public static void main(String[] args) {

    }
    public static int getMaxLine(Point[] points){
        if(points == null || points.length < 3) return points.length;
        int max = 0;
        for(int i =0;i<points.length - 1; i++){
            Map<Integer,Integer> map = new HashMap<>();
            int sameLine = 1;//自己本身就像一条线
            int samPoint = 0;//是否含有重复的点

            for(int j = i+1;j<points.length;j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    samPoint++;
                    continue;
                }
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                int gcd = gcd(dx,dy);
                int commX = dx / gcd;
                int commY = dy / gcd;
                int hash = hash(commX,commY);
                Integer count = map.get(hash);
                if(count == null){
                    count = 2;
                    map.put(hash,count);
                }else{
                    map.put(hash,count+1);
                    count++;
                }
                sameLine = Math.max(sameLine,count);//判断这一回合(j的循环中) 是否有新节点加入了sameLine中
            }
            max = Math.max(max,sameLine+samPoint);
        }
        return max;
    }

    public static int gcd(int a,int b){
        if(b == 0) return a ;
        return gcd(b,a%b);
    }

    public static int hash(int a,int b){
        return (a << 32) ^ b;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}