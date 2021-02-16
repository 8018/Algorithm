package me.xfly.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> queue  = new PriorityQueue<>();

        int maxCount = 0;
        for (int[] metting : intervals) {
            while(!queue.isEmpty() && metting[0] >= queue.peek()){
                queue.poll();
            }
            queue.offer(metting[1]);
            maxCount = Math.max(maxCount,queue.size());
        }
        return maxCount;
    }

    @Test
    public void test(){
        int[][] intervals = {{0,30},{5,10},{15,20}};
        Assert.assertEquals(minMeetingRooms(intervals),2);
    }
}
