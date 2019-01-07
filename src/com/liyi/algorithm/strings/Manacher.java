package com.liyi.algorithm.strings;


public class Manacher {
    //获取最大回文数下标
    public static void main(String[] args) {
        String str = "12321";
        String str2 = "12344321";

        manacherIndex(str);
        manacherIndex(str2);
    }

    //getManacherString 加#
    public static char[] getManacherString(String str){
        if(str!=null && str.length()<=0){
            return null;
        }
        char[] chars = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for(int i =0;i<res.length;i++){
            res[i] = (i&1) == 0 ? '#':chars[index++];
        }
        return res;
    }

    //Manacher
    public static void manacherIndex(String str){
        char[] manacherString = getManacherString(str);
        if(manacherString.length == 0 || manacherString == null ) return;
        int R = -1;
        int[] arr = new int[manacherString.length];
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<manacherString.length;i++){
            arr[i] = R > i ? Math.min(R-i,arr[2*index-i]) : 1;
            while(i + arr[i] < manacherString.length && i - arr[i] > -1){
                if(manacherString[i + arr[i]] == manacherString[i-arr[i]]){
                    arr[i]++;
                }else{
                    break;
                }
                if(R < i+arr[i]){
                    index = i;
                    R = i+arr[i];
                }
                max = Math.max(max,arr[i]);
            }
        }
        System.out.println(max/2 - 1);
    }
}
