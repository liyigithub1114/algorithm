package com.liyi.algorithm.bitcalculate;

/**
 *一个数组中有 k个数出现了n次，只有一个数出现了1次，找出只出现了一次的数
 *
 * 101
 * 101
 * 101
 * 110
 * 无进位相加 % 3
 * 110
 *
 */
public class FindOdd3 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555}));
    }
    public static int onceNum(int[] arr,int k){
        int[] eO = new int[32];
        for(int i =0;i<arr.length;i++){
            setExecusiveOr(eO,arr[i],k);
        }
        int res = getKNumFromSysNum(eO,k);

        return res;
    }

    public static void setExecusiveOr(int[] eO,int value,int k){
        int[] curKSysNum = getKSysNumFormNum(value,k);
        for(int i=0;i<eO.length;i++){
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    public static int[] getKSysNumFormNum(int value,int k){
        int[] res = new int[32];
        int index = 0;
        while (value != 0){
            res[index++] = value % k;
            value = value/k;
        }
        return res;
    }

    public static int getKNumFromSysNum(int[] eO,int k){
        int res = 0;
        for(int i = eO.length - 1;i>=0;i--){
            res = res * k + eO[i];
        }
        return  res;
    }

    public static int singleNumber(int[] nums)
    {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }

    public int singleNumberII(int[] A) {
        if(A == null || A.length == 0){
            return -1;
        }

        int[] bit = new int[32];

        int sum = 0;
        int res = 0;
        for(int i = 0; i < bit.length; i++){
            sum = 0;
            for(int j = 0; j < A.length; j++){
                if(((A[j] >> i) & 1) == 1){
                    sum++;
                    sum %= 3;
                }
            }
            res |= sum << i;
        }

        return res;
    }
}
