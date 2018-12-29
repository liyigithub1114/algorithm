package com.liyi.algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxMeeting {
    //一个会议室，给定开会时间和n个项目，求最多能做几个项目
    public static void main(String[] args) {
        Meet meet = new Meet(8,10);
        Meet meet1 = new Meet(9,10);
        Meet meet2 = new Meet(10,11);
        Meet meet3 = new Meet(11,12);
        Meet[] meets = new Meet[4];
        meets[0] = meet;
        meets[1] = meet1;
        meets[2] = meet2;
        meets[3] = meet3;
        int maxMeeting = getMaxMeeting(meets, 8);
        System.out.println(maxMeeting);
    }

    public static int getMaxMeeting(Meet[] meet,int start){
        if(meet.length == 0) return 0;
        int res = 0;
        PriorityQueue<Meet> queue = new PriorityQueue<>(new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                return o1.end-o2.end;
            }
        });
        for(int i =0;i<meet.length;i++){
            queue.add(meet[i]);
        }
        for(int i = 0;i<meet.length;i++){
            if(!queue.isEmpty() && start <= queue.peek().start){
                res++;
                start = queue.poll().end;
            }else{
                queue.poll();
            }
        }

        return res;

    }
}
class Meet{
    int start;//开始时间
    int end;//结束时间

    public Meet(int start,int end){
        this.start = start;
        this.end = end;
    }
}