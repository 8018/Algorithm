package me.xfly.algorithm.findchar;

public class CharacterIndex {

	private static final int BAD_CHARACTER_SIZE = 256;

	public static void main(String[] args) {
		String originStr = "abddabcabcabc";
		String toBeFindString = "abcabc";
		System.out.println(findStrIndex(originStr, toBeFindString));

		/*
		 * int i = 0; System.out.println(i++); System.out.println(i);
		 * 
		 * i = 0; System.out.println(++i); System.out.println(i);
		 */
	}

	private static int findStrIndex(String origin, String toBeFind) {

		int[] badCharacters = new int[BAD_CHARACTER_SIZE];

		char[] originChar = origin.toCharArray();
		int originLength = originChar.length;

		char[] toBeFindChars = toBeFind.toCharArray();
		int toBeFindLength = toBeFindChars.length;

		int[] suffix = new int[toBeFindLength];
		boolean[] prefix = new boolean[toBeFindLength];

		generateBadCharacters(toBeFindChars, toBeFindLength, badCharacters);
		generateGoodSub(toBeFindChars, toBeFindLength, suffix, prefix);

		int i = 0; // j 表示主串与模式串匹配的第一个字符
		while (i <= originLength - toBeFindLength) {
			int j;
			for (j = toBeFindLength - 1; j >= 0; --j) { // 模式串从后往前匹配
				System.out.println(j);
				if (originChar[i + j] != toBeFindChars[j])
					break; // 坏字符对应模式串中的下标是 j
			}
			if (j < 0) {
				return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
			}
			int x = j - badCharacters[(int) originChar[i + j]];
			int y = 0;
			if (j < toBeFindLength - 1) { // 如果有 好后缀的话
				y = moveByGoodSub(j, toBeFindLength, suffix, prefix);
			}
			i = i + Math.max(x, y);
		}
		return -1;
	}

	// j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
	private static int moveByGoodSub(int j, int m, int[] suffix, boolean[] prefix) {
		int k = m - 1 - j; // 好后缀长度
		if (suffix[k] != -1)
			return j - suffix[k] + 1;
		//为什么是 j+2 ？
		//如果是 j+1 刚好等于上面的好后缀长度上面已经做过判断 
		for (int r = j + 2; r <= m - 1; ++r) {
			if (prefix[m - r] == true) {
				return r;
			}
		}
		return m;
	}

	private static void generateBadCharacters(char[] b, int m, int[] bc) {
		for (int i = 0; i < BAD_CHARACTER_SIZE; i++) {
			bc[i] = -1;
		}

		for (int i = 0; i < b.length; i++) {
			bc[b[i]] = i;
		}
	}

	private static void generateGoodSub(char[] toBeFindChars, int m, int[] suffix, boolean[] prefix) {
		for (int i = 0; i < prefix.length; i++) {
			suffix[i] = -1;
			prefix[i] = false;
		}

		for (int i = 0; i < m - 1; ++i) {
			int j = i;
			int k = 0; // 公共后缀子串长度

			while (j >= 0 && toBeFindChars[j] == toBeFindChars[m - 1 - k]) {
				--j;
				++k;
				suffix[k] = j + 1; // j+1 表示公共后缀...
			}

			if (j == -1) {
				prefix[k] = true;
			}
		}
	}
}
