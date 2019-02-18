package com.liyi.algorithm.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval interval1= new Interval(2,3);
        Interval interval2= new Interval(2,2);
        Interval interval3= new Interval(3,3);
        Interval interval4= new Interval(1,3);
        Interval interval5= new Interval(5,7);
        Interval interval6= new Interval(2,2);
        Interval interval7= new Interval(4,6);

        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);
        intervals.add(interval6);
        intervals.add(interval7);

        System.out.println(merge(intervals));

    }

    public static List<Interval> merge(List<Interval> intervals){
        if(intervals == null || intervals.isEmpty()) return new ArrayList<>();
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start){
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });
        int len = intervals.size();
        for(int i =0;i<len;i++){
            queue.add(intervals.get(i));
        }

        while(!queue.isEmpty()){
            if(!res.isEmpty()){
                Interval oldIn = res.get(res.size() - 1);//(1,3)  或者 (2,3)
                Interval newIn = queue.poll();//(2,6)  或者 (2,2)
                if(oldIn.end < newIn.start){
                    res.add(newIn);
                }else if(oldIn.end == newIn.start){
                    res.remove(res.size() - 1);
                    res.add(new Interval(oldIn.start,newIn.end));
                }else{
                    res.remove(res.size() - 1);
                    res.add(new Interval(oldIn.start,Math.max(oldIn.end,newIn.end)));
                }
            }else{
                res.add(queue.poll());
            }
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}