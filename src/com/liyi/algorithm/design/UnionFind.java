package com.liyi.algorithm.design;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public static void main(String[] args) {

    }
    public HashMap<String, String> fatherMap;
    public HashMap<String, Integer> sizeMap;

    public UnionFind() {
        fatherMap = new HashMap<String, String>();
        sizeMap = new HashMap<String, Integer>();
    }

    public void makeSets(List<String> Strings) {
        fatherMap.clear();
        sizeMap.clear();
        for (String String : Strings) {
            fatherMap.put(String, String);
            sizeMap.put(String, 1);
        }
    }

    private String findHead(String String) {
        String father = fatherMap.get(String);
        if (father != String) {
            father = findHead(father);
        }
        fatherMap.put(String, father);
        return father;
    }

    public boolean isSameSet(String a, String b) {
        return findHead(a) == findHead(b);
    }

    public void union(String a, String b) {
        if (a == null || b == null) {
            return;
        }
        String aHead = findHead(a);
        String bHead = findHead(b);
        if (aHead != bHead) {
            int aSetSize= sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            if (aSetSize <= bSetSize) {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSetSize + bSetSize);
            } else {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSetSize + bSetSize);
            }
        }
    }
}
