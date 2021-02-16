package me.xfly.algorithm.sort;

public class HeapII {
    private int[] nums;
    private int size;
    private int count;

    public HeapII(int size) {
        nums = new int[size + 1];
        this.size = size;
        count = 0;
    }

    public void insert(int x) {
        if (count >= size) {
            return;
        }

        ++count;
        nums[count] = x;
        int i = count;
        while (i / 2 > 0 && nums[i] < nums[i / 2]) {
            swap(nums, i, i / 2);
            i = i / 2;
        }
    }

    public int removeMin(){
        int min = Integer.MAX_VALUE;
        if(count == 0){
            return min;
        }
        min = nums[1];
        nums[1] = nums[count];
        --count;
        heapify(nums,count,1);
        return min;
    }

    static HeapII buildHeap(int[] nums, int n, int count) {
        HeapII heap = new HeapII(n);

        for (int i = n / 2; i >= 1; --i) {
            heapify(nums, n, i);
        }
        return heap;
    }

    static void heapify(int[] nums, int n, int i) {
        while (true) {
            int minPos = i;
            if (2 * i <= n && nums[i] > nums[2 * i]) {
                minPos = 2 * i;
            }
            if (2 * i + 1 <= n && nums[i] > nums[2 * i + 1]) {
                minPos = 2 * i + 1;
            }
            if (minPos == i) {
                break;
            }
            swap(nums, i, minPos);
            i = minPos;
        }
    }

    private static void swap(int[] nums, int i, int minPos) {
        int temp = nums[i];
        nums[i] = nums[minPos];
        nums[minPos] = temp;
    }
}
