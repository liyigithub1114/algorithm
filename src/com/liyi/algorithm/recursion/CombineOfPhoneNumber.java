package com.liyi.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 手机九键键盘，输入 数字，能组成的多少对
 */
public class CombineOfPhoneNumber {
    private static String[] phone = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        public static void main(String[] args) {
            String digits = "23";
            get(digits);

        //String[] res = new String[]{"ajp","ajq","ajr","ajs","akp","akq","akr","aks","alp","alq","alr","als","bjp","bjq","bjr","bjs","bkp","bkq","bkr","bks","blp","blq","blr","bls","cjp","cjq","cjr","cjs","ckp","ckq","ckr","cks","clp","clq","clr","cls"};
    }
    public static List<String> get(String digits){
        List<String> strings = get1(digits, new ArrayList<>(), 0);
        return strings;
    }

    public static List<String> get1(String digits,List<String> list,int index){
        if(digits == null || digits.length() == 0) return list;
        if(digits.length()  == index) return list;
        List<String> res = new ArrayList<>();

        String temp = phone[Integer.parseInt(digits.charAt(index)+"") ];
        if(list != null && !list.isEmpty()){
            int len = list.size();
            int len2 = temp.length();
            for(int i =0;i<len;i++){
                String combine = list.get(i);
                for(int j=0;j<len2;j++){
                    res.add(combine+temp.charAt(j));
                }
            }
        }else{
            int len = temp.length();
            for(int i = 0;i<len;i++){
                res.add(temp.charAt(i)+"");
            }
        }
        return get1(digits,res,++index);
    }
}
