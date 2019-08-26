package me.xfly.algorithm.dynamicprogramming;

public class ZeroOneBag {
	private static int[] weight = { 2, 2, 4, 6, 3 };

	public static void main(String[] args) {
		/*
		 * System.out.println(new ZeroOneBag().knapsack(weight, weight.length,9));
		 * System.out.println(new ZeroOneBag().knapsack2(weight, weight.length,11));
		 */

		ZeroOneBag zeroOneBag = new ZeroOneBag();
		zeroOneBag.f(0, 0, 0);
		System.out.println(zeroOneBag.knapsack3(zeroOneBag.items, zeroOneBag.value, zeroOneBag.items.length, 9));
	}

	private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
	private int[] items = { 2, 2, 4, 6, 3 }; // 物品的重量
	private int[] value = { 3, 4, 8, 9, 6 }; // 物品的价值
	private int n = 5; // 物品个数
	private int w = 9; // 背包承受的最大重量

	public void f(int i, int cw, int cv) { // 调用 f(0, 0, 0)
		if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
			if (cv > maxV)
				maxV = cv;
			return;
		}
		f(i + 1, cw, cv); // 选择不装第 i 个物品
		if (cw + weight[i] <= w) {
			f(i + 1, cw + weight[i], cv + value[i]); // 选择装第 i 个物品
		}
	}

	public int knapsack3(int[] weight, int[] value, int n, int w) {
		int[][] states = new int[n][w + 1];
		for (int i = 0; i < n; ++i) { // 初始化 states
			for (int j = 0; j < w + 1; ++j) {
				states[i][j] = -1;
			}
		}
		states[0][0] = 0;
		if (weight[0] <= w) {
			states[0][weight[0]] = value[0];
		}
		for (int i = 1; i < n; ++i) { // 动态规划，状态转移
			for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
				if (states[i - 1][j] >= 0)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) { // 选择第 i 个物品
				if (states[i - 1][j] >= 0) {
					int v = states[i - 1][j] + value[i];
					if (v > states[i][j + weight[i]]) {
						states[i][j + weight[i]] = v;
					}
				}
			}
		}
		// 找出最大值
		int maxvalue = -1;
		for (int j = 0; j <= w; ++j) {
			if (states[n - 1][j] > maxvalue)
				maxvalue = states[n - 1][j];
		}
		return maxvalue;
	}

	

	// weight: 物品重量，n: 物品个数，w: 背包可承载重量
	public int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w + 1]; // 默认值 false
		states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		if (weight[0] <= w) {
			states[0][weight[0]] = true;
		}
		for (int i = 1; i < n; ++i) { // 动态规划状态转移
			for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) {// 把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j + weight[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
			if (states[n - 1][i] == true)
				return i;
		}
		return 0;
	}

	public int knapsack2(int[] items, int n, int w) {
		boolean[] states = new boolean[w + 1]; // 默认值 false
		states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		if (items[0] <= w) {
			states[items[0]] = true;
		}
		for (int i = 1; i < n; ++i) { // 动态规划
			for (int j = w - items[i]; j >= 0; --j) {// 把第 i 个物品放入背包
				if (states[j] == true)
					states[j + items[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
			if (states[i] == true)
				return i;
		}
		return 0;
	}

}
