package me.xfly.algorithm.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 6, 4, 8};
        new MergeSort().mergeSort(a, 0, a.length - 1);

        for (int i : a) {
            System.out.print(i + " ");
        }
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

    /**
     *  注意边界条件
     *  1、申请一个临时数组
     *  2、已经排好序的两部分对比大小放入临时数组
     *  3、临时数组数据放入原数组
     * @param nums
     * @param l
     * @param m
     * @param r
     */
    private void merge(int[] nums, int l, int m, int r) {
        int i = l, j = m + 1, index = 0;
        int temp[] = new int[r - l + 1];

        while (i <= m && j <= r) {
            if(nums[i] > nums[j]){
                temp[index++] = nums[j++];
            }else{
                temp[index++] = nums[i++];
            }
        }

        while(i <= m){
            temp[index++] = nums[i++];
        }
        while(j <= r){
            temp[index++] = nums[j++];
        }

        for( i = 0;i<= r-l;i++){
            nums[l+i] = temp[i];
        }
    }


}
