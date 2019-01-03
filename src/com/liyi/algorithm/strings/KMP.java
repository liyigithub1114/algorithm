package com.liyi.algorithm.strings;

public class KMP {
    /**
     *  KMP 算法，匹配字符串计算出next数组
     *  根据next数组移动匹配字符串
     *  相对于传统暴力计算，不必移动主字符串
     */
    public static void main(String[] args) {
        String str1="aaa";
        String str2="aa";
        getIndex(str1,str2);
    }

    /**
     * 关键算法，计算出next数组
     * @param matcher  字符串转换成的char数组（子串）
     * @return
     */
    public static int[] getNextArray(char[] matcher){
        if(matcher.length==1){
            return new int[]{-1};
        }
        int[] nextArr = new int[matcher.length];
        nextArr[0] = -1;//标志位，nextArr初始化时永远为-1
        nextArr[1] = 0;
        int pos = 2;//next数组下标
        int nextIndex = 0;//next数组的值
        while(pos<nextArr.length){
            if(matcher[pos-1] == matcher[nextIndex]){
                nextArr[pos++] = ++ nextIndex;
            }else if(nextIndex > 0){
                nextIndex = nextArr[nextIndex];
            }else{
                nextArr[pos++] = 0;
            }
        }
        return nextArr;
    }

    public static void getIndex(String str1,String str2){
        if(str1 == null || str2 == null || str1.length() < str2.length() || str2.length() == 0){
            System.out.println(-1);
            return ;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] nextArr = getNextArray(c2);
        int c1Index = 0;
        int c2Index = 0;
        while(c1Index < c1.length && c2Index < c2.length){
            if(c1[c1Index] == c2[c2Index]){
                c1Index++;
                c2Index++;
            }else if(nextArr[c2Index] == -1){
                c1Index++;//如果c1Index不等于c2Index ，看next数组是不是-1，是，代表第一个就不匹配，主串后移一位
            }else{
                c2Index = nextArr[c2Index];//代表从最大相同前缀后缀 之后的一个字符开始同主串匹配（主串index是不动的）
            }
            if(c2Index == c2.length){
                //res.add(c1Index-c2Index);
                System.out.println(c1Index-c2Index);
                c2Index = 0;
                c1Index = c1Index-c2Index+1;
            }
        }
    }
}
