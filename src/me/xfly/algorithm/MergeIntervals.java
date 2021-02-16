package me.xfly.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int n = intervals.length;
        int index = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] = intervals[i][1];
            } else {
                index = index + 1;
                intervals[index] = intervals[i];
            }
        }
        int[][] ans = new int[index + 1][2];

        for(int i = 0;i<= index;++i){
            ans[i] = intervals[i];
        }

        return ans;
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);
    }
}
