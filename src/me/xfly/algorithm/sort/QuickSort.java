package me.xfly.algorithm.sort;


public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 0, 2, 6};
        //quickSort1(nums, 0, nums.length - 1);
        quickSort2(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num+" ");
        }

    }

    static void quickSort1(int[] nums, int l, int r) {
        if (l >= r) return;

        int p = quickSortHelper(nums, l, r);
        quickSort1(nums, l, p - 1);
        quickSort1(nums, p + 1, r);
    }

    /**
     * 注意边界条件
     * 单边遍历，从左到右
     * 寻找一个目标数把数组分成两个分区
     * 比这个目标数小的放到它的前面
     * 比这个目标数大的放到它的后面
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int quickSortHelper(int[] nums, int l, int r) {
        //最后一个数是目标数
        int flag = nums[r];
        int index = l;

        //遍历到最后一个数之前
        //index 前的表示比目标数小的数
        for (int i = l;i < r;i++){
            if(nums[i] < flag){
                swap(nums,i,index);
                index ++;
            }
        }
        //最后把目标数放到 index
        //前面是已经换过去的比目标数小的数
        //后面的都是比目标数大的数
        swap(nums,index,r);
        return index;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 双边遍历
     * 两边向中间
     * 目标数拿出来，右边找到小的放到目标数的位置
     * 左边拿到大的放到上一步空出位置
     * 递归
     * @param nums
     * @param l
     * @param r
     */
    static void quickSort2(int[] nums, int l, int r) {
        if(l >= r){
            return;
        }

        int left = l;
        int right = r;
        int flag = nums[l];

        while (left < right){
            while (left < right && nums[right] >= flag){
                right--;
            }

            if(left < right){
                nums[left] = nums[right];
                left++;
            }

            while (left < right && nums[left] <= flag){
                left++;
            }

            if(left < right){
                nums[right] = nums[left];
                right--;
            }

            nums[left] = flag;
            quickSort2(nums,l,left-1);
            quickSort2(nums,left+1,r);
        }
    }
}