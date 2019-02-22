package com.liyi.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 餐厅内有a个桌子，每个桌子可以坐b个人
 * 现在来了m波人，每波人的人数 x,和消费数y已告知，求不拼桌情况下，餐厅能获得的最大收益
 */
public class Restaurant {

    public static void main(String[] args) {
        int a = 3;
        int[] b = new int[]{2,4,2};
        Arrays.sort(b);
        Group group = new Group(1,3);//假设就是这5波人
        Group group1 = new Group(3,5);//假设就是这5波人
        Group group2 = new Group(3,7);//假设就是这5波人
        Group group3 = new Group(5,9);//假设就是这5波人
        Group group4 = new Group(1,10);//假设就是这5波人

        PriorityQueue<Group> numbers = new PriorityQueue<>(new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                return o1.number - o2.number;
            }
        });
        numbers.add(group);
        numbers.add(group1);
        numbers.add(group2);
        numbers.add(group3);
        numbers.add(group4);

        PriorityQueue<Group> moneys = new PriorityQueue<>(new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                return o2.money-o1.money;
            }
        });

        int index = 0;
        int res = 0;
        while(index < b.length){
            int temp = b[index];
            while(!numbers.isEmpty() && numbers.peek().number <= temp){
                Group groupTemp = numbers.poll();
                moneys.add(groupTemp);
            }
            if(!moneys.isEmpty()){
                res += moneys.poll().money;
            }
            index++;
        }
        System.out.println(res);
    }

}
class Group{
    int number;
    int money;

    public Group(int number,int money){
        this.number = number;
        this.money = money;
    }
}