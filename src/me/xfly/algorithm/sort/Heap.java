package me.xfly.algorithm.sort;

public class Heap {
    private int[] nums;
    private int size;
    public int count;

    public Heap(int size) {
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

    public int removeMin() {
        int min = Integer.MAX_VALUE;
        if (count == 0) {
            return Integer.MAX_VALUE;
        }
        min = nums[1];
        nums[1] = nums[count];
        --count;
        heapify(nums, count, 1);

        return min;
    }

    static Heap buildHeap(int[] a, int n, int count) {
        Heap heap = new Heap(n);

        for(int i = n/2;i>=1;--i){
            heapify(a,n,i);
        }

        heap.nums = a;
        heap.count = count;
        return heap;
    }

    static void heapify(int[] nums, int n, int i) {
        while (true) {
            int minPos = i;
            if (i * 2 <= n && nums[i] > nums[2 * i]) {
                minPos = i * 2;
            }
            if (i * 2 + 1 <= n && nums[minPos] > nums[2 * i + 1]) {
                minPos = i * 2 + 1;
            }
            if (minPos == i) {
                break;
            }
            swap(nums, i, minPos);
            i = minPos;
        }
    }

    public static void swap(int[] a, int i, int m) {
        int temp = a[i];
        a[i] = a[m];
        a[m] = temp;
    }
}
