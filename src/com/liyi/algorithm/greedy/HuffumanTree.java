package com.liyi.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffumanTree {
    //问题，给定人数，分金块，每分一次，金块数量*2 ，n个人分完金块后，金块的最小值
    //比如 10，20，30   一共60个金块，分下去，分成30和30 ，30分成10和20 ，最小值为60+30 = 90
    public static void main(String[] args) {
        int minGold = getMinGold(new int[]{10, 20, 30});
        System.out.println(minGold);
    }

    public static int getMinGold(int[] gold){
        if(gold.length == 0 ) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i =0;i<gold.length;i++){
            queue.add(gold[i]);
        }
        int res = 0;
        while(!queue.isEmpty() && queue.size()>1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            res+=num1+num2;
            queue.add(res);
        }

        return res;
    }

}
