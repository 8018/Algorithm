package me.xfly.algorithm.tree;

/**
 * 建堆有两种方式，分别是 insert 和 buildHeap
 * 具体原理看它们的注释
 * */
public class Heap {

	public static void main(String[] args) {
		int[] a = { 0, 19, 4, 6, 3, 9, 11, 5, 7, 10, 20, 33, 17, 16, 0, 0 };
		Heap heap = buildHeap(a, 15, 13);
		for (int i = 0; i < a.length; i++) {
			System.out.println(heap.removeMax());
		}
	}

	private int[] a; // 数组，从下标 1 开始存储数据
	private int n; // 堆可以存储的最大数据个数
	private int count; // 堆中已经存储的数据个数

	public Heap(int capacity) {
		a = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	/**
	 * 把数据插入到队尾，然后自下往上堆化
	 * */
	public void insert(int data) {
		if (count >= n)
			return; // 堆满了
		++count;
		a[count] = data;
		int i = count;
		while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
			swap(a, i, i / 2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
			i = i / 2;
		}
	}

	public int removeMax() {
		int max = -1;
		if (count == 0)
			return -1; // 堆中没有数据
		max = a[1];
		a[1] = a[count];
		--count;
		heapify(a, count, 1);
		return max;
	}

	/**
	 * 数组原地建堆
	 * 从 n/2 往前依次进行堆化
	 * 为什么是 n/2 ?
	 * 完全二叉树有 n/2 个叶子节点，从 n/2 往前就是所有带有子节点的树依次进行堆化
	 * */
	static Heap buildHeap(int[] a, int n, int count) {
		Heap heap = new Heap(n);
		for (int i = n / 2; i >= 1; --i) {
			heapify(a, n, i);
		}
		heap.a = a;
		heap.count = count;

		return heap;
	}

	/**
	 * 从上往下堆化
	 * 父亲节点和两个孩子节点对比
	 * 若有子节点比父节点值大，找到两个孩子中较大的和父节点交换
	 * 直至完全堆化
	 * */
	static void heapify(int[] a, int n, int i) {
		while (true) {
			int maxPos = i;
			if (i *2 <= n && a[i] < a[2*i]){
				maxPos = 2*i;
			}
			if (i*2+1 <= n && a[maxPos] <a[2*i+1]){
				maxPos = 2*i+1;
			}
			if (maxPos == i) {
				break;
			}
			swap(a,i,maxPos);
			i = maxPos;
		}
	}

	public static void swap(int[] a, int i, int m) {
		int temp = a[i];
		a[i] = a[m];
		a[m] = temp;
	}

}
