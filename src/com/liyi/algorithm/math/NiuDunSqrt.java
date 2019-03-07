package com.liyi.algorithm.math;

import java.text.DecimalFormat;
//牛顿迭代法
public class NiuDunSqrt {
    public static void main(String[] args) {
        System.out.println( sqrt(9));
    }



    //只要精度比预计的要大,重新定义k = 0.5 *(x/k + k)
    public static double sqrt(double x) {
        if(x<0) {
            return -1;
        }
        //格式化，保证输出位数
        DecimalFormat df = new DecimalFormat("#.00");
        double k = x;
        double precision = 0.000001;
        while((k*k-x)>precision) {
            k=0.5*(k+x/k);// k = (x/k + k) / 2;
        }
        return Double.valueOf(df.format(k));
    }

    public static double sqrt2(double num){
        if(num<0) {
            return -1;
        }

        double low = 0;
        double high = num/2;
        double precision = 0.000001;
        //格式化，保证输出位数
        DecimalFormat df = new DecimalFormat("#.00");

        double res = high;
        while(Math.abs(num-(res*res))>precision) {
            if(high*high > num) {
                double n= high - (high-low)/2;
                if(n*n>num) {
                    high = n;
                } else if(n*n<num){
                    low = n;
                }else {
                    return Double.valueOf(df.format(n));
                }
                res = n;

            } else if(high*high < num){
                double m = high + (high-low)/2;
                if(m*m>num) {
                    low = high;
                    high = m;
                } else if(m*m<num){
                    low = high;
                    high = m;
                }else {
                    return Double.valueOf(df.format(m));
                }
                res = m;
            } else {
                return Double.valueOf(df.format(high));
            }
        }
        return Double.valueOf(df.format(res));
    }
}
