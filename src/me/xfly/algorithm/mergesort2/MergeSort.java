package me.xfly.algorithm.mergesort2;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {2,3,1,6,4,8};
        new MergeSort().mergeSort(a,0,a.length-1);
        System.out.println(a);
    }

    public void mergeSort(int[] a,int start,int end){
        if (start >= end){
            return;
        }
        int middle = (start+end)/2;
        mergeSort(a,start,middle);
        mergeSort(a,middle+1,end);
        merge(a,start,middle,end);
    }

    public void merge(int[] a,int p,int q,int r){
        int i = p, j = q+1, k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) { // 处理剩下的
            tmp[k++] = a[i++];
        }
        while (j <= r) { // 处理剩下的
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r-p; ++i) { // 从 tmp 拷贝回 a
            a[p+i] = tmp[i];
        }
    }
}
