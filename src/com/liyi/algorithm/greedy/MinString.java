package com.liyi.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinString {
    //要求，给定一个数组，获取数组拼接字符串的最小值
    public static void main(String[] args) {
        String minString = getMinString(new String[]{"b","ba"});
        System.out.println(minString);
    }

    public static String getMinString(String[] strs){
        if(strs.length == 0) return "";
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for( int i =0;i<strs.length;i++){
            queue.add(strs[i]);
        }
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}
