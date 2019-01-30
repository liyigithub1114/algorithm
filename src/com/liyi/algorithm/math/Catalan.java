package com.liyi.algorithm.math;

public class Catalan {
    /**
     * 令h(0)=1,h(1)=1，catalan数满足递推式 [2]  ：
     * h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)*h(0) (n>=2)
     * 例如：h(2)=h(0)*h(1)+h(1)*h(0)=1*1+1*1=2
     * h(3)=h(0)*h(2)+h(1)*h(1)+h(2)*h(0)=1*2+1*1+2*1=5
     * 另类递推式 [3]  ：
     * h(n)=h(n-1)*(4*n-2)/(n+1);
     * 递推关系的解为：
     * h(n)=C(2n,n)/(n+1) (n=0,1,2,...)
     * 递推关系的另类解为：
     * h(n)=c(2n,n)-c(2n,n-1)(n=0,1,2,...)
     */

    public static void main(String[] args) {

    }
}
