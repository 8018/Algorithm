package me.xfly.algorithm.dynamicprogramming;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SuperEggDrop {
    Map<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop(int n, int k) {

        if (k < 0 || n < 0) {
            return -1;
        }
        return dp(k, n);
    }

    public int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans = 0;
            if (n == 0) {
                return 0;
            } else if (k == 1) {
                return n;
            } else {
                int low = 1;
                int high = n;
                while (low + 1 < high) {
                    int mid = (low + high) / 2;
                    int t1 = dp(k - 1, mid - 1);
                    int t2 = dp(k, n - mid);

                    if (t1 > t2) {
                        high = mid;
                    } else if (t2 > t1) {
                        low = mid;
                    } else {
                        low = high = mid;
                    }
                    ans = Math.min(Math.max(dp(k - 1, low - 1), dp(k, n - low)),
                            Math.max(dp(k - 1, high - 1), dp(k, n - high)));
                }
            }
            memo.put(n * 100 + k, ans);
        }

        return memo.get(n * 100 + k);
    }

    public int superEggDropMath(int k, int n) {
        if (k < 0 || n < 0) {
            return -1;
        }
        //dp[i][j] i 表示操作次数，j 表示鸡蛋数，value 值为可达到的楼层高度
        //逆推思想
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= k; ++i) {
            dp[1][i] = 1;
        }
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
            }
            if(dp[i][k] >= n){
                ans = i;
                break;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        superEggDrop(100, 2);
    }
}
