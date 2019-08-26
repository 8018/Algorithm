package me.xfly.algorithm.dynamicprogramming;

public class StringDistance {

	public static void main(String[] args) {
		String a = "hello";
		String b = "Hell0";
		System.out.println(new StringDistance().getLowestStringDistance(a, b));
	}

	private int getLowestStringDistance(String a, String b) {
		char[] charsa = a.toCharArray();
		int m = charsa.length;
		char[] charsb = b.toCharArray();
		int n = charsb.length;
		int[][] minDST = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (charsa[i] == charsb[0]) {
				minDST[i][0] = i;
			} else if (i != 0) {
				minDST[i][0] = minDST[i - 1][0] + 1;
			} else {
				minDST[i][0] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			if (charsb[i] == charsa[0]) {
				minDST[0][i] = i;
			} else if (i != 0) {
				minDST[0][i] = minDST[0][i - 1] + 1;
			} else {
				minDST[0][i] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (charsa[i] == charsb[j]) {
					minDST[i][j] = min(minDST[i][j - 1] + 1, minDST[i - 1][j] + 1, minDST[i - 1][j - 1]);
				} else {
					minDST[i][j] = min(minDST[i][j - 1] + 1, minDST[i - 1][j] + 1, minDST[i - 1][j - 1] + 1);
				}
			}
		}

		return minDST[m - 1][n - 1];
	}

	private int min(int x, int y, int z) {
		int min = Integer.MAX_VALUE;
		if (x < min) {
			min = x;
		}
		if (y < min) {
			min = y;
		}
		if (z < min) {
			min = z;
		}

		return min;
	}

	public int lcs(String aStr, String bStr) {

		char[] a = aStr.toCharArray();
		int n = a.length;
		char[] b = bStr.toCharArray();
		int m = b.length;
		int[][] maxlcs = new int[n][m];
		for (int j = 0; j < m; ++j) {// 初始化第 0 行：a[0..0] 与 b[0..j] 的 maxlcs
			if (a[0] == b[j])
				maxlcs[0][j] = 1;
			else if (j != 0)
				maxlcs[0][j] = maxlcs[0][j - 1];
			else
				maxlcs[0][j] = 0;
		}
		for (int i = 0; i < n; ++i) {// 初始化第 0 列：a[0..i] 与 b[0..0] 的 maxlcs
			if (a[i] == b[0])
				maxlcs[i][0] = 1;
			else if (i != 0)
				maxlcs[i][0] = maxlcs[i - 1][0];
			else
				maxlcs[i][0] = 0;
		}
		for (int i = 1; i < n; ++i) { // 填表
			for (int j = 1; j < m; ++j) {
				if (a[i] == b[j])
					maxlcs[i][j] = max(maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1] + 1);
				else
					maxlcs[i][j] = max(maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1]);
			}
		}
		return maxlcs[n - 1][m - 1];
	}

	private int max(int x, int y, int z) {
		int maxv = Integer.MIN_VALUE;
		if (x > maxv)
			maxv = x;
		if (y > maxv)
			maxv = y;
		if (z > maxv)
			maxv = z;
		return maxv;
	}

}
