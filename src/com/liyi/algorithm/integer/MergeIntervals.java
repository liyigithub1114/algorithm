package com.liyi.algorithm.integer;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并区间
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 *
 * 1，3，2，6 统一可以放在1-6里面 所以【1，6】
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 */
public class MergeIntervals {
    public static void main(String[] args) {
        //[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
    }

    public static List<Interval> getRes(List<Interval> list){
        if(list == null) return new ArrayList<>();
        if(list.isEmpty()) return new ArrayList<>();
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> intervals = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int len = list.size();

        for(int i =0;i<len;i++){
            intervals.add(list.get(i));
        }
        while(!intervals.isEmpty()){
            Interval newIn = intervals.poll();
            if(!queue.isEmpty()){
                Interval old = queue.peek();
                if(old.end >= newIn.start && old.end <= newIn.end){  //比如   old(1,3) newIn(2,6)
                    queue.poll();
                    queue.add(new Interval(old.start,newIn.end));
                }else if(old.end < newIn.start){
                    queue.add(newIn);
                }
            }else{
                queue.add(newIn);
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}