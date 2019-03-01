package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 112
 * 假设1->A
 *     2->B
 *     26->Z
 *
 *    那么给定一个字符串，将符合的所有输出打印
 *    如112
 *    可以[1,12]  [1,1,2]  [11,2]
 */
public class CombineNumber {

    public static void main(String[] args) {
        String s= "112";
        List<String> list = new ArrayList<>();
        int index = 0;
        get(s,list,index,0);
    }

    public static void get(String s,List<String> list,int index,int flag){
        if(flag >= s.length()){
            System.out.println(new ArrayList<>(list));
            return;
        }
        for(int i =1;i<=2 && (index+i) <= s.length();i++){
            String tempStr = s.substring(index,index+i);
            int tempInt = Integer.parseInt(tempStr);
            if(tempInt > 0 && tempInt <=26){
                list.add(tempStr);
                get(s,list,index+1,index+i);
                list.remove(list.size()-1);
            }
        }
    }
}
