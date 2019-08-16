package com.liyi.algorithm;

import java.util.*;

public class TestQuick {
    public static void main(String[] args) {
        System.out.println( new TestQuick().anagrams(new String[]{"ute","fey","toe","lob","pet","ted","old","bye","car","peg","maw","toe","has","dot","tam"}));
    }
    private PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>(){
        public int compare(Character c1, Character c2){
            return c1 - c2;
        }
    });

    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }

        HashMap<String, String> maps = new HashMap<>();
        String temp = "";

        for(int i = 0; i < strs.length; i++){
            temp = sortStrs(strs[i]);

            if(maps.containsKey(temp)){
                String value = maps.get(temp);
                maps.put(temp, value + i +" ");
            }else{
                maps.put(temp, i + " ");
            }
        }

        temp = "";
        for(Map.Entry<String, String> entry : maps.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getValue().length() > 1){
                temp += entry.getValue();
            }
        }
        int len = temp.length();
        String[] split = temp.split(" ");
        
        for(int i = 0; i < len; i++){
            if(temp.charAt(i) != ' '){
                res.add(strs[temp.charAt(i) - '0']);
            }
        }

        return res;
    }

    public String sortStrs(String s){
        if(s == null || s.length() == 0){
            return "";
        }

        char[] strs = s.toCharArray();

        for(int i = 0; i < strs.length; i++){
            queue.add(strs[i]);
        }

        StringBuffer sb = new StringBuffer();

        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }

        return sb.toString();

    }
}
