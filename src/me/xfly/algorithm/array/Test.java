package me.xfly.algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		int[] ints = { 7, 8, 9, 11, 12, 2, 6, 1 };
		// System.out.println(firstMissingPositive(ints));

		// System.out.println(twoSum(ints, 23).toString());

		// lengthOfLongestSubstring("abccbadab");
		// System.out.println(longestPalindrome("abccbadab"));

		// System.out.println(String.valueOf(isValid("()")));
		// System.out.println(reverse(-1234));

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		reverseMatrix(matrix);

		for (int i = 0;i <matrix.length;i++) {
			int[] ints1 = matrix[i];
			for (int j = 0;j<ints1.length;j++){
				System.out.println(ints1[j]);
			}
		}

	}

	static void reverseMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}

	static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	private static boolean isValid(String str) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		char[] characters = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < characters.length; i++) {
			if (map.containsKey(characters[i])) {
				char topElement = stack.isEmpty() ? '#' : stack.pop();
				if (topElement != map.get(characters[i])) {
					return false;
				}
			} else {
				stack.push(characters[i]);
			}
		}
		return stack.isEmpty();
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	

	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {

				return new int[] { map.get(target - nums[i]), i };
			}

			map.put(nums[i], i);
		}

		return null;
	}

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;

		// 基本情况
		int contains = 0;
		for (int i = 0; i < n; i++)
			if (nums[i] == 1) {
				contains++;
				break;
			}

		if (contains == 0)
			return 1;

		// nums = [1]
		if (n == 1)
			return 2;

		// 用 1 替换负数，0，
		// 和大于 n 的数
		// 在转换以后，nums 只会包含
		// 正数
		for (int i = 0; i < n; i++)
			if ((nums[i] <= 0) || (nums[i] > n))
				nums[i] = 1;

		// 使用索引和数字符号作为检查器
		// 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
		// 如果 nums[2] 是正数 表示数字 2 没有出现
		for (int i = 0; i < n; i++) {
			int a = Math.abs(nums[i]);
			// 如果发现了一个数字 a - 改变第 a 个元素的符号
			// 注意重复元素只需操作一次
			if (a == n)
				nums[0] = -Math.abs(nums[0]);
			else
				nums[a] = -Math.abs(nums[a]);
		}

		// 现在第一个正数的下标
		// 就是第一个缺失的数
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0)
				return i;
		}

		if (nums[0] > 0)
			return n;

		return n + 1;

	}
}


