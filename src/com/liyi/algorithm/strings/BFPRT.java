package com.liyi.algorithm.strings;

//TOP K
//描述，在不遍历整个数组的情况下，获取第K大或者第K小的值

/**
 *TOP K （ 如 ：第10 大的数）
 *描述，在数组中获取第K大或者第K小的值  （找中位数）
 *1,2,3,4,5,    6,7,8,9,10,    11,12,13,14,15      16，17，18，19，20
 *   3             8                 13                    18
 *                      10
 */
public class BFPRT {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] bigHeap = getBigHeap(arr, 4);
        for(int i = 0;i<bigHeap.length;i++){
            System.out.println(bigHeap[i]+" ");
        }
    }

    //两种解法，时间复杂度为O(n) * lgK的 使用堆排序
  public static int[] getBigHeap(int[] arr,int k){
        if(k < 1 || k >arr.length) return arr;
        int[] heapK = new int[k];
        //开始维护 大小为k的大根堆
        for(int i = 0;i<k;i++){
            heapInsert(heapK,arr[i],i);
        }

        for(int i = k;i<arr.length;i++){
            heapK[0] = arr[i] < heapK[0] ? arr[i] : heapK[0];
            heapify(heapK,0,k);
        }
        return heapK;
  }

  //2*index+1 = parent
    public static void heapInsert(int[] heapK,int value,int index){
        heapK[index] = value;
        while(index != 0){
            int parent = (index-1)/2;
            if(heapK[parent] < heapK[index]){
                swap(heapK,parent,index);
                index = parent;
            }else{
                break;
            }
        }

    }

    public static void heapify(int[] heapK,int index,int size){
        int left = 2*index + 1;
        int largest = 0;
        while(left < size){
            largest = left+1 < size && heapK[left+1] > heapK[left] ? left+1:left;

            largest = heapK[index] < heapK[largest] ? largest:index;

            if(largest == index){
                break;
            }
            swap(heapK,largest,index);
            index = largest;
            left = 2*index+1;
        }
    }


    public static void swap(int[] arr ,int i ,int j){
        if(i == j) return ;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
