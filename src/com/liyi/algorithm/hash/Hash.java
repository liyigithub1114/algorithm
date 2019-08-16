package com.liyi.algorithm.hash;

public class Hash {
    public static void main(String[] args) {
        //基于理论的

        /*
            1.100亿数据，给定指定的数据，如何分流
                比如100台机器，100亿个字符串
                将每一个字符串读出来，通过计算hash值，并且mod 100 ，放到每台机器上
                如果要查询，计算hash值后去某台机器上找即可

            2.布隆过滤器
                在数据量极大的情况下，给定指定的内存，允许有误差时使用
                通过位运算来判定

                比如 100亿URL ,一个64字节，通过计算hash值，放到一个长度为m(bit) 的数组中
                int[] = new int[100] int = 4byte = 32bit,100也就是有3200个

                设计hash函数，计算多次，放在bit数组里面，位运算^起来

                这里面的公式为
                布隆过滤器
                m(bit) = - n*lnp/(ln2)2    n样本量，p误差值，（ln2）2是ln2的平方
                m算出来后，是bit，转成字节，是 m/8 ，装成int 型，m/8/4

                k = ln2 * m/n = 0.7*m/n    m（bit） n（样本量） k（hash函数的个数） 经典hash函数个数13个

                实际计算出来，m,和k可能是小数，向上取整后，失误率会变
                实际失误率
                P=（1-e的（-n*k/m））的k次方

                3.一致性哈希

                在经典中，哈希表满了，需要重新计算，这是一个很大的工作量，
                所有的数据，将重新mod新的长度，重新放入哈希表中

                因此，设计环状的数据结构，将机器打成虚拟节点，计算机器哈希值，比如ip,散列分布在环上，
                某一段范围的归某一段管，比如定义规则，顺时针最近的虚拟机管理这个数据，因此，扩容哈希表时工作量会非常小，
                并且每个虚拟节点的数据都很平均
            */
     }

     //神奇的33进制数，APR底层
     private static int HASH_TABLE_SIZE = 10;
     public static int hashFunction(String key){
        int sum = 0;
        for(int i = 0; i < key.length(); i++){
            sum = sum * 33 + (int)(key.charAt(i));
            sum = sum % HASH_TABLE_SIZE;
        }
        return sum;
     }
}