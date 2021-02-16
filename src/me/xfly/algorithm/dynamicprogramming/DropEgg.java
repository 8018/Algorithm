package me.xfly.algorithm.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DropEgg {

    Map<Integer, Integer> memo = new HashMap<>();
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int k, int n) {
        if (!memo.containsKey(n * 100 + k)) {
            int ans = 0;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int left = 1;
                int right = n;

                while (left + 1 < right) {
                    int mid = (left + right) / 2;
                    int t1 = dp(k - 1, mid - 1);
                    int t2 = dp(k, n - mid);

                    if (t1 > t2) {
                        right = mid;
                    } else if (t2 > t1) {
                        left = mid;
                    } else {
                        left = right = mid;
                    }
                    ans = Math.min(Math.max(dp(k - 1, left - 1), dp(k, n - left)),
                            Math.max(dp(k - 1, right - 1), dp(k, n - right)))+1;
                }
            }

            memo.put(n * 100 + k, ans);
        }
        return memo.get(n * 100 + k);
    }

    @Test
    public void testNZero(){
        Assert.assertEquals(superEggDrop(3,0),0);
    }

    @Test
    public void testKOne(){
        Assert.assertEquals(superEggDrop(1,9),9);
    }
    @Test
    public void test(){
        Assert.assertEquals(superEggDrop(2,100),14);
    }
}