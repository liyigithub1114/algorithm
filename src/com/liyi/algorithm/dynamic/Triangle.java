package com.liyi.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 三角形从上到下最短路径
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(6);
        list2.add(5);
        list2.add(7);
        list3.add(4);
        list3.add(3);
        list3.add(8);
        list3.add(1);
        triangle.add(list);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);

        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
