package me.xfly.algorithm.dynamicprogramming;

public class FourKeyBoard {
    public static void main(String[] args) {
        System.out.println(maxA(8));
    }

    public static int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 全选 & 复制 dp[j-2]，连续粘贴 i - j 次
                // 屏幕上共 dp[j - 2] * (i - j + 1) 个 A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N 次按键之后最多有几个 A？
        return dp[N];
    }
}
