package com.liyi.algorithm.tree;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 前缀树 a-z  97 -122
 *
 * //问题描述
 * 给定一个字符串列表words，找到words最长的word，使得这个word可用words中的其他word（一次一个字符）地构建。
 * 如果有多个可选答案，则返回最长的且具有最小字典序的word。
 */
public class TrieTree {

    private TrieTree[] next;
    private int count;

    public TrieTree(){
        next = new TrieTree[26];
    }

    public static void main(String[] args)
    {
        String[] strings = new String[]{"a","pp","app","appl","apple","apply","y","banana","applb","appla"};
        TrieTree trieTree = new TrieTree();
        for(int i =0;i<strings.length;i++){
            trieTree = parseStringToTrieTree(strings[i],trieTree);
        }


        int len = Integer.MIN_VALUE;
        String string = "";
        //先用贪心算法搞一波  算了，麻烦死了，一步到位(两个优先队列，按照长度先排，长度相等的取出来，放入按照字母序排的队列)
        for(int i =0;i<strings.length;i++){
            if(searchString(strings[i],trieTree) ){
                if(len == strings[i].length()){
                    string = string.compareTo(strings[i]) < 0 ? string:strings[i];
                }else if(len < strings[i].length()){
                    string = strings[i];
                    len = strings[i].length();
                }
            }
        }

        System.out.println(string);
    }

    //将所有字符串全部加入trieTree中
    public static TrieTree parseStringToTrieTree(String string,TrieTree trieTree){
        if(string == null | string.length() < 1) return trieTree;
        if(trieTree == null ) return new TrieTree();
        char[] chars = string.toCharArray();
        TrieTree temp = trieTree;
        for(int i =0;i<chars.length;i++){
               if(temp.next[chars[i] - 97] == null){
                   temp.next[chars[i] - 97] = new TrieTree();
               }else{
                   temp.count++;
               }
            temp = temp.next[chars[i] - 97];
        }
        return trieTree;
    }

    //单独搜索某一个是否存在
    public static boolean searchString(String string ,TrieTree trieTree){
        if(string == null || string.length() < 0 ) return false;
        if(trieTree == null) return false;
        char[] chars = string.toCharArray();
        TrieTree temp = trieTree;
        for(int i =0;i<chars.length;i++){
            if(temp.next[chars[i] - 97] == null || temp.count ==0){
                if(temp.count == 0 && i == chars.length -1){
                    return true;
                }
                return false;
            }
            temp = temp.next[chars[i] - 97];
        }
        return true;
    }
}
