package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueues {

    public static void main(String[] args) {
        NQueues nQueues = new NQueues();
       /* List<List<String>> lists = nQueues.solveNQueens(5);
        System.out.println(lists.size());
        for(List<String> strs : lists){
            for(String str : strs){
                System.out.println(str);
            }
            System.out.println();
        }*/
        System.out.println(nQueues.solveNQueens(5).size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n == 0){
            return res;
        }

        List<String> temp = new ArrayList<>();

        int[] flags = new int[n * n];
        String[] strs = new String[n];
        for(int i = 0; i < strs.length; i++){
            String str = "";
            for(int j = 0; j < strs.length; j++){
                if(j == i){
                    str = str + "Q";
                }else{
                    str = str + ".";
                }
            }
            strs[i] = str;
        }

        helper(n, res, temp, 0, flags, strs);

        return res;
    }

    public void helper(int n, List<List<String>> res, List<String> temp, int index, int[] flags, String[] strs){
        if(index == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        int curIndex;
        int size = n * n;
        for(int i = 0; i < n; i++){
            curIndex = index * n + i;
            if(flags[curIndex] == 0){
                temp.add(strs[curIndex % n]);

                changeFlags(curIndex, n, flags, size, 1);
                helper(n, res, temp, index + 1, flags, strs);

                changeFlags(curIndex, n, flags, size, -1);
                temp.remove(temp.size() - 1);
            }else{
                continue;
            }
        }
    }

    public void changeFlags(int curIndex, int n, int[] flags, int size, int flag){
        int next = curIndex + n;
        int nextNext = next + 1;
        int nextPre = next - 1;
        while(next < size){
            if(next < size){
                flags[next] += flag;
            }
            if(nextNext < size && nextNext / n == next / n){
                flags[nextNext] += flag;
            }

            if(nextPre < size && nextPre / n == next / n){
                flags[nextPre] += flag;
            }
            next = next + n;
            nextNext = nextNext + n + 1;
            nextPre = nextPre + n - 1;
        }
    }
}
