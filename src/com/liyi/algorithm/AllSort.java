package com.liyi.algorithm;

public class AllSort {
    public static void main(String[] args) {
        print(bubbleSort(new int[]{5,1,2,4,7,8,9,0,2,2}));
        print(selectionSort(new int[]{5,1,2,4,7,8,9,0,2,2}));
        print(insertSort(new int[]{5,1,2,4,7,8,9,0,2,2}));
        print(mergeSort(new int[]{5,1,2,4,7,8,9,0,2,2},0,9));
        print(quickSort(new int[]{5,1,2,4,7,8,9,0,2,2},0,9));
        print(heapSort(new int[]{5,1,2,4,7,8,9,0,2,2}));
    }
    public static void print(int[] array){
        for(Integer i : array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void swap(int[] array,int L,int R){
        if(L==R) return ;
        array[L] = array[L] ^ array[R];
        array[R] = array[L] ^ array[R];
        array[L] = array[L] ^ array[R];
    }
    public static void swap1(int[] array,int L ,int R){
        int temp =array[L];
        array[L] =array[R];
        array[R] =temp;
    }
    //冒泡
    public static int[] bubbleSort(int[] array){
        for(int i=array.length-1;i>=0;i--){
            for(int j =0;j<i;j++){
                if(array[j] > array[j+1]){
                    swap1(array,j,j+1);
                }
            }
        }
        return array;
    }
    //选择
    public static int[] selectionSort(int[] array){
        for(int i =0;i<array.length-1;i++){
            int index = i;
            for(int j=i+1;j<array.length;j++){
                if(array[index]>array[j]){
                    index = j;
                }
            }
            swap(array,i,index);
        }
        return array;
    }
    //插入
    public static int[] insertSort(int[] array){
        for(int i =1;i<array.length;i++){
            for(int j =i-1;j>=0;j--){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
        return array;
    }
    //归并排序
    public static int[] mergeSort(int[] array ,int L, int R){
        if(L == R) return array;
        int middle = L + ((R-L) >> 1);
        mergeSort(array,L,middle);
        mergeSort(array,middle+1,R);
        return merge(array,L ,middle,R);
    }
    public static int[] merge(int[] array,int L ,int middle,int R){
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2=middle+1;
        int index = 0;
        while(p1<=middle && p2<=R){
            help[index++] = array[p1] > array[p2] ? array[p2++] :array[p1++];
        }
        while(p1<=middle){
            help[index++] = array[p1++];
        }
        while(p2<=R){
            help[index++] =array[p2++];
        }
        for(int i =0;i<help.length;i++){
            array[L+i]=help[i];
        }
        return help;
    }
    //快排，随机取值
    public static int[] quickSort(int[] array,int L ,int R){
        if(array == null || array.length<2) return array;
        if(L<R){
            swap(array,L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(array,L,R);
            quickSort(array,L,p[0]-1);
            quickSort(array,p[1]+1,R);
        }
        return array;
    }
    public static int[] partition(int[] array,int L ,int R){
        int less = L-1;
        int more = R;
        while(L<more){
            if(array[L] <array[R] ){
                swap(array,++less,L++);
            }else if(array[L] >array[R]){
                swap(array,--more,L);
            }else{
                L++;
            }
        }
        swap(array, more, R);
        return new int[]{less+1,more};
    }
    //堆排序
    public static int[] heapSort(int[] array){
        if(array == null || array.length < 2) return array;
        //1.构建大根堆
        for(int i =0;i<array.length;i++){
            heapBig(array,i);
        }
        //大根堆顶 ，一定是最大数，不需要参与排序了
        int len = array.length;
        //第一个位置(最大数)与最后一个数交换，继续调整大根堆
        swap(array,0,--len);
        //调整大根堆 len=0没必要排序
        while(len>0){
            heapify(array,len);        //控制数组长度，array最后一个是最大，不参与
            swap(array,0,--len);
        }
        return array;
    }

    public static void heapBig(int[] array,int i){
        int index = (i-1)/2;//父节点
        while(array[i] > array[index]){
            swap(array,index,i);
            i = index;
            index = (i-1)/2;
        }
    }
    public static void heapify(int[] array,int heapSize ){
        int index = 0;//每次进入，array[0] 都是 最小的
        int left = 2*index+1;
        while(left<heapSize){
            int largest = left+1 < heapSize && array[left+1] > array[left] ? left+1:left;//左右孩子谁最大

            largest = array[largest] > array[index] ? largest:index;//左右孩子的最大值是否大于父节点，获取谁大的下标

            if(largest == index){
                break; //父节点最大，不需要操作
            }
            swap(array,index,largest);//父节点被换上最大值
            index = largest;
            left = 2*index+1;
        }
    }
}
