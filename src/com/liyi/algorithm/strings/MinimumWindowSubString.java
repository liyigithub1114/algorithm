package com.liyi.algorithm.strings;


import java.util.HashMap;
import java.util.Map;

/**
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * map 存储 T中所有字符串出现的次数
 * mapS 当且仅当map中存在
 */
public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s= "aa";
        String t = "aa";
        System.out.println(getWindow(s+1,t));
    }
    public static String  getWindow(String s,String t){
        if(s == null || t == null || s.length() < t.length()) return "";
        int lenS = s.length();
        int lenT = t.length();
        int left = 0;
        int right = 0;
        String res = s + "1";
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> mapS = new HashMap<>();
        for(int i =0;i<lenT;i++){
            if(map.containsKey(charT[i])){
                map.put(charT[i],map.get(charT[i])+1);
            }else{
                map.put(charT[i],1);
            }
        }
        int count =0;
        while(left < lenS && right < lenS){
            //到第一个合法字串的时候right的值
            while(count < lenT && right < lenS){
                char temp = charS[right];
                if(mapS.containsKey(temp)){
                    mapS.put(temp,mapS.get(temp)+1);
                }else{
                    mapS.put(temp,1);
                }
                if(map.containsKey(temp) && mapS.get(temp) <= map.get(temp)){
                    count++;
                }
                right++;
            }
            //当第一次不合法时left的值
            while(count == lenT && left < lenS){
                char temp = charS[left];
                if(map.containsKey(temp)){
                    mapS.put(temp,mapS.get(temp) - 1);
                    if(mapS.get(temp) < map.get(temp)){
                        count--;
                    }
                }
                left++;
            }
            res = res.length() > right - left && left-1 >= 0 ? s.substring(left-1,right) : res;
        }
        return  res.length() == s.length()+1 ? "":res;
    }
}
