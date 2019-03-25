package com.liyi.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 *  Example
 * createCustom("http://www.lintcode.com/", "lccode")
 * >> http://tiny.url/lccode
 * createCustom("http://www.lintcode.com/", "lc")
 * >> error
 * longToShort("http://www.lintcode.com/problem/")
 * >> http://tiny.url/1Ab38c   // this is just an example, you can have you own 6 characters.
 * shortToLong("http://tiny.url/lccode")
 * >> http://www.lintcode.com/
 * shortToLong("http://tiny.url/1Ab38c")
 * >> http://www.lintcode.com/problem/
 * shortToLong("http://tiny.url/1Ab38d")
 * >> null
 */
public class TinyUrl2 {

    public static void main(String[] args) {
        TinyUrl2 tinyUrl2 = new TinyUrl2();
        String lcccode = tinyUrl2.createCustom("http://www.lintcode.com/", "lccode");
        System.out.println(lcccode);
        String lc = tinyUrl2.createCustom("http://www.lintcode.com/", "lc");
        System.out.println(lc);
        String en = tinyUrl2.encode("http://www.lintcode.com/problem/");
        System.out.println(en);
        System.out.println(tinyUrl2.decode("http://tiny.url/lccode"));
        System.out.println(tinyUrl2.decode(en));
        System.out.println(tinyUrl2.decode("123"));

    }
    Map<String,String> longToShort = new HashMap<>();
    Map<String,String> shortToLong = new HashMap<>();
    String prefix = "http://tiny.url/";

    private char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public String createCustom(String longUrl,String shortUrl){
        if(longToShort.containsKey(longUrl)){
            return "error";
        }else{
            shortUrl = prefix + shortUrl;
            longToShort.put(longUrl,shortUrl);
            shortToLong.put(shortUrl,longUrl);
        }
        return longToShort.get(longUrl);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)){
            return "error";
        }else{
            String shortUrl = prefix + generateUrl(longToShort.size());
            longToShort.put(longUrl,shortUrl);
            shortToLong.put(shortUrl,longUrl);
        }
        return longToShort.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortToLong.containsKey(shortUrl)){
            return shortToLong.get(shortUrl);
        }else{
            return null;
        }
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
