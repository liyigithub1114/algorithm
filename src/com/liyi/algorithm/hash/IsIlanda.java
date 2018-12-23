package com.liyi.algorithm.hash;

public class IsIlanda {
    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(ilands(m1));
        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(ilands(m2));
    }

    public static int ilands(int[][] nums){
        if(nums.length == 0 && nums[0].length == 0) return 0;
        int res = 0;
        for(int i =0;i<nums.length;i++){
            for(int j =0;j<nums[0].length;j++){
                if(nums[i][j] == 1){
                    res ++;
                    infect(i,j,nums.length,nums[0].length,nums);
                }
            }
        }
        return res;
    }

    public static void infect(int i ,int j ,int N ,int M,int[][] nums){
        if((i< 0 || i>=N) || (j<0 || j>=M) || nums[i][j] != 1){
            return;
        }

        nums[i][j] = 2;
        infect(i+1,j,N,M,nums);
        infect(i,j+1,N,M,nums);
        infect(i-1,j,N,M,nums);
        infect(i,j-1,N,M,nums);
    }
}
