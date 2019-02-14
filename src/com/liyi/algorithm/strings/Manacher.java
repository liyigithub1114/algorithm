package com.liyi.algorithm.strings;


public class Manacher {
    //获取最大回文数下标
    public static void main(String[] args) {
        String str = "12321";
        String str2 = "12344321";
        String str3 = "122";

        manacherIndex(str);
        manacherIndex(str2);
        manacherIndex(str3);

        System.out.println(longest(str));
        System.out.println(longest(str2));
        System.out.println(longest(str3));
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
        System.out.println(max - 1);
    }

    public static String longest(String s){
        if(s == null || s.length() == 0) return "";
        char[] charArray = getManacherString(s);
        int len = charArray.length;
        int[] curLen = new int[len];
        int R = -1;
        int index = 0;
        int max = 0;
        int maxIndex = 0;
        for(int i =0;i<len;i++){
            curLen[i] = R > i ? Math.min(R-i, curLen[2 * index -i]) : 1;
            while(i+curLen[i] < len && i -curLen[i] > -1){
                if(charArray[i+curLen[i]] == charArray[i-curLen[i]]){
                    curLen[i]++;

                }else{
                    break;
                }
            }

            if(R < i + curLen[i]){
                R = i + curLen[i];
                index = i;
            }
            if(max < curLen[i]){
                max = curLen[i];
                maxIndex = i;
            }
        }
        max = max - 1;
        int left = maxIndex - max;
        StringBuffer sb = new StringBuffer();
        for(int i =left;i<=left + 2*max;i++){
            if('#' != charArray[i]){
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
}
