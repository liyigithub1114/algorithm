package com.liyi.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProfitMinCost {
    //给定两个数组profit[] cost[] 分别代表一个项目的收益与花费，
    //给定初始金钱 w, 可以做的项目次数 k，求在可做项目的次数k中，最大收获利润
    //一次只能做一个项目
    public static void main(String[] args) {
        int maxProfit = getMaxProfit(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 2, 3);
        //c 1 2 3
            //p 1 2 3
            //w 2
            //k 3
        System.out.println(maxProfit);
    }

    public static int getMaxProfit(int[] profit,int[] cost ,int w, int k){
        if(profit.length == 0 || cost.length == 0) return w;
        PriorityQueue<Data> costQueue = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.c-o2.c;
            }
        });
        PriorityQueue<Data> profitQueue = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.p-o1.p;
            }
        });
        for(int i = 0;i<profit.length;i++){
            Data data = new Data(profit[i],cost[i]);
            costQueue.add(data);
        }

        for(int i =0;i<k;i++){
            while(!costQueue.isEmpty() && costQueue.peek().c <= w){
                profitQueue.add(costQueue.poll());
            }
            w+=profitQueue.poll().p;
        }
        return w;
    }
}
class Data{
    int p ;
    int c;
    public Data(int p,int c){
        this.p = p;
        this.c = c;
    }
}