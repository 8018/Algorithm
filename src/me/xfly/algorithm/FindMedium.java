package me.xfly.algorithm;

public class FindMedium {
    public static void main(String[] args) {
        int[][] nums = {{0,2},{4,6},{8,10},{2,9},{1,5},{5,9}};
        int T = 10;
        System.out.println(videoStitching(nums,T));
    }

    public static int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
}
