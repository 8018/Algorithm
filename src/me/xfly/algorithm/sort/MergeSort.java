package me.xfly.algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 6, 4, 8};
        new MergeSort().mergeSort(a, 0, a.length - 1);
        System.out.println(a);
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);

    }

    public void merge(int[] nums, int s, int m, int e) {
        int i = s, j = m + 1, index = 0;
        int temp[] = new int[e - s + 1];
        while (i <= m && j <= e) {
            if(nums[i] > nums[j]){
                temp[index++] = nums[j++];
            }else{
                temp[index++] = nums[i++];
            }
        }

        while(i <= m){
            temp[index++] = nums[i++];
        }
        while(j <= e){
            temp[index++] = nums[j++];
        }

        for( i = 0;i<= e-s;i++){
            nums[s+i] = temp[i];
        }
    }
}
