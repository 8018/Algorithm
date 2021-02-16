package me.xfly.algorithm.sort;


public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 0, 2,6};
        quickSort1(nums, 0, nums.length - 1);
        //quickSort2(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }

    }


    static void quickSort1(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = quickSortHelper(nums, l, r);
        quickSort1(nums, l, p - 1);
        quickSort1(nums, p + 1, r);
    }

    static int quickSortHelper(int[] nums, int l, int r) {
        int flag = nums[r];
        int index = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < flag) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, r);
        return index;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void quickSort2(int[] nums, int l, int r) {
        /*if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        int x = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= x) {
                j--;
            }

            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] < x) {
                i++;
            }

            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = x;
        quickSort2(nums,l,i-1);
        quickSort2(nums,i+1,r);*/

        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        int x = nums[l];

        while (i < j) {
            while (i < j && nums[j] >= x) {
                j--;
            }

            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] < x) {
                i++;
            }

            if (i < j) {
                nums[j] = nums[i];
                j--;
            }

        }
        nums[i] = x;
        quickSort2(nums, l, i - 1);
        quickSort1(nums, i + 1, r);
    }
}