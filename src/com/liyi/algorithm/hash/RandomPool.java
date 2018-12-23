package com.liyi.algorithm.hash;

import java.util.HashMap;

public class RandomPool {

    private HashMap<String,Integer> map1;
    private HashMap<Integer,String> map2;
    private int size;
    public static void main(String[] args) {

    }

    public void insert(String str,Integer num){

    }

    public RandomPool(){
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        size = 0;
    }

    public void insert(String str){
        if(!this.map1.containsKey(str)){
            this.map1.put(str,size);
            this.map2.put(size++,str);
        }
    }

    public String getRandom(){
        if(size == 0){
            return null;
        }
        return map2.get((int)Math.random()*size);
    }

    public void delete(String str){
        if(!this.map1.containsKey(str)) return;

        int strIndex = map1.get(str);
        int lastIndex = --this.size;

        String lastStr = map2.get(lastIndex);
        map1.put(lastStr,strIndex);
        map2.put(strIndex,lastStr);
        map1.remove(lastStr);
        map2.remove(strIndex);
    }
}
