package me.xfly.algorithm;

public class Test {

    public static void main(String[] args) {
        fib(25);
        System.out.println(times+"");
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i:nums){
            sum += i;
            if (sum > result){
                result = sum;
            }

            if (sum <0) sum  = 0;
        }
        return result;
    }

    static int times = 0;

    static int fib(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[N+1];
        for (int i = 0;i<memo.length;i++){
            memo[i] = 0;
        }
        // 初始化最简情况
        memo[1] = memo[2] = 1;
        return helper(memo, N);
    }

    static int helper(int[] memo, int n) {
        System.out.println(times+"   "+n);
        // 未被计算过
        if (n > 0 && memo[n] == 0)
            memo[n] = helper(memo, n - 1) +
                    helper(memo, n - 2);
        times+=1;
        return memo[n];
    }
}
