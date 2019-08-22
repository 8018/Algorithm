package me.xfly.algorithm.findchar;

public class FindChar {
	private static final int SIZE = 256; // 全局变量或成员变量

	public static void main(String[] args) {
		String string = "dddabcacunbabcabcumcde";
		String charsToFindString = "abcabc";

		System.out.println(bm(string, charsToFindString));
	}

	/*
	 * 存储模式串每个字母出现的位置 Q:如果一个字母在串中出现两次 这种方法只存储了最后一次的位置，为什么
	 * A:坏字符规则在模式串中寻找匹配的字符时，如果有多个匹配以最后一个为准。
	 */
	private static void generateBadChar(char[] b, int m, int[] bc) {
		for (int i = 0; i < SIZE; ++i) {
			bc[i] = -1; // 初始化 bc
		}
		for (int i = 0; i < m; ++i) {
			int ascii = (int) b[i]; // 计算 b[i] 的 ASCII 值
			bc[ascii] = i;
		}
	}

	// b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
	private static void generateGreatSub(char[] b, int m, int[] suffix, boolean[] prefix) {
		for (int i = 0; i < m; ++i) { // 初始化
			suffix[i] = -1;
			prefix[i] = false;
		}
		for (int i = 0; i < m - 1; ++i) { // b[0, i]
			int j = i;
			int k = 0; // 公共后缀子串长度
			while (j >= 0 && b[j] == b[m - 1 - k]) { // 与 b[0, m-1] 求公共后缀子串
				--j;
				++k;
				suffix[k] = j + 1; // j+1 表示公共后缀子串在 b[0, i] 中的起始下标
			}
			// i
			if (j == -1)
				prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
		}
	}

	// a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
	public static int bm(String origin, String toBeFind) {

		char[] a = origin.toCharArray();
		int n = a.length;
		char[] b = toBeFind.toCharArray();
		int m = b.length;
		int[] badChars = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
		generateBadChar(b, m, badChars); // 构建坏字符哈希表
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGreatSub(b, m, suffix, prefix);
		int i = 0; // j 表示主串与模式串匹配的第一个字符
		while (i <= n - m) {
			int j;
			for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
				if (a[i + j] != b[j])
					break; // 坏字符对应模式串中的下标是 j
			}
			if (j < 0) {
				return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
			}
			int x = j - badChars[(int) a[i + j]];
			int y = 0;
			if (j < m - 1) { // 如果有好后缀的话
				y = moveByGreatSub(j, m, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	// j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
	private static int moveByGreatSub(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j; // 好后缀长度
		if (suffix[k] != -1)
			return j - suffix[k] + 1;
		for (int r = j + 2; r <= m - 1; ++r) {
			if (prefix[m - r] == true) {
				return r;
			}
		}
		return m;
	}

}
