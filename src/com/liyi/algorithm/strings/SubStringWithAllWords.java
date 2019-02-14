package com.liyi.algorithm.strings;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出一个字符串s,给出一个字符串数组 words， word中所有得单词随机组合，检查s是否包含组合后得字符串，并且返回下标
 *
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 */
public class SubStringWithAllWords {
    public static void main(String[] args) {

        String s = "";
        String[] words = new String[]{};
        findIndexFromS(s,words);
        //解题报告地址
        //https://leetcode.windliang.cc/leetCode-30-Substring-with-Concatenation-of-All-Words.html
    }


    public static List<Integer> findIndexFromS(String s,String[] words){
        if(s == null || s.length() == 0) return  new ArrayList<>();
        if(words == null || words.length == 0) return new ArrayList<>();
        int wordNum = words.length;
        int wordLen = words[0].length();
        if(s.length() < wordLen * wordNum) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        //将words 中的单词放入 第一个map中，key = words[i] value = 单词出现的次数
        Map<String,Integer> wordsMap = new HashMap<>();
        for(int i =0;i<wordNum;i++){
            if(wordsMap.containsKey(words[i])){
                wordsMap.put(words[i],wordsMap.get(words[i])+1);
            }else{
                wordsMap.put(words[i],1);
            }
        }


        for(int i =0;i < s.length() - wordLen * wordNum + 1;i++){
            int num = 0;//统计匹配的单词
            Map<String,Integer> tempMap = new HashMap<>();
            while(num < wordNum){
                String tempString = s.substring(i+num * wordLen,i+(num+1)*wordLen);//截取字符串操作
                if(wordsMap.containsKey(tempString)){//如果是words中的单词，证明符合，继续处理
                    if(tempMap.containsKey(tempString)){//放入 temoString中
                        tempMap.put(tempString,tempMap.get(tempString) + 1);
                    }else{
                        tempMap.put(tempString,1);
                    }
                    if(tempMap.get(tempString) > wordsMap.get(tempString)){
                        break;
                    }
                }else {
                    break;
                }
                num++;
            }

            if(num == wordNum){
                res.add(i);
            }
        }
        System.out.println(res.toString());
        return res;
    }
}
