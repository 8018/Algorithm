package me.xfly.algorithm;

import me.xfly.algorithm.sort.QuickSort;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int p = quickSortHelper(nums,left,right);
        quickSort(nums,left,p-1);
        quickSort(nums,p+1,right);
    }

    private int quickSortHelper(int[] nums, int left, int right) {
        int flag = nums[right];
        int index = left;

        for (int i = left; i < right; i++) {
            if(nums[i] < flag){
                swap(nums,index,i);
                index++;
            }
        }

        swap(nums,index,right);
        return index;
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}