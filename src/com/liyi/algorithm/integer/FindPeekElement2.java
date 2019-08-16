package com.liyi.algorithm.integer;

import java.util.ArrayList;
import java.util.List;

public class FindPeekElement2 {
    public static void main(String[] args) {

    }
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return list;
        }
        int start = 0, end = A.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int col = find(mid, A);
            if (A[mid - 1][col] > A[mid][col]) {
                end = mid;
            } else if (A[mid + 1][col] > A[mid][col]) {
                start = mid;
            } else {
                list.add(mid);
                list.add(col);
                break;
            }
        }
        return list;
    }

    private int find(int mid, int[][] A) {
        int max = Integer.MIN_VALUE;
        int col = 0;
        for (int i = 0; i < A[mid].length; i++) {
            if (A[mid][i] > max) {
                max = A[mid][i];
                col = i;
            }
        }
        return col;
    }
}
