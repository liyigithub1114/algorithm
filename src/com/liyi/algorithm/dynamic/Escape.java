package com.liyi.algorithm.dynamic;

import java.util.ArrayList;
import java.util.Scanner;

public class Escape {
    static int max = -1;
    static ArrayList<String> resList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = scanner.nextInt();
            }
        }
        dfs(n, m, 0, 0, p, new ArrayList<>(), d);
        if (resList != null) {
            for (int i = 0; i < resList.size(); i++) {
                System.out.print(resList.get(i) + ",");
            }
            System.out.println("[0," + (m - 1) + "]");
        } else {
            System.out.println("Can not escape!");
        }
        System.out.println(max);
    }

    static void dfs(int n, int m, int i, int j, int p, ArrayList<String> list, int[][] d) {
        if (i < 0 || j < 0 || i >= n || j >= m || p < 0 || d[i][j] != 1) return;
        if (i == 0 && j == m - 1) {
            if (p > max) {
                resList = new ArrayList<>(list);
                max = p;
            }
        } else {
            list.add("[" + i + "," + j + "]");
            d[i][j] = 0;
            dfs(n, m, i, j - 1, p - 1, list, d);
            dfs(n, m, i, j + 1, p - 1, list, d);
            dfs(n, m, i + 1, j, p - 3, list, d);
            dfs(n, m, i - 1, j, p, list, d);
            list.remove(list.size() - 1);
        }
    }
}