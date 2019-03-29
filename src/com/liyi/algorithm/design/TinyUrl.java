package com.liyi.algorithm.design;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

    private static int size = 0 ;

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        String encode = tinyUrl.generateUrl(1);
        System.out.println(encode);
    }
    private Map<String,String> shortToLong = new HashMap<>();
    private Map<String,String> longToShort = new HashMap<>();
    private char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = "";
        if(longToShort.containsKey(longUrl)){
            shortUrl = longToShort.get(longUrl);
        }else{
            shortUrl = generateUrl(longToShort.size());
            shortToLong.put(shortUrl,longUrl);
        }
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return shortToLong.get(shortUrl);
    }

    private String generateUrl(int size){
        String res = "";
        while(size > 0){
            res = chars[size % chars.length] + res;//不可以写成 res += chars[size % chars.lenght];

            size = size / chars.length;
        }
        while(res.length() < 6){
            res = "0" + res;
        }
        return res;
    }
}
