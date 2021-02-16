package me.xfly.algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {

    @Test
    public void test() {
        int[] heights = {2, 1, 5, 5, 5, 6, 3};
        largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int length = heights.length;
        if (length == 1) {
            return heights[0];
        }

        int ans = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[length + 1];
        newHeights[0] = 0;
        newHeights[newHeights.length-1] = 0;

        System.arraycopy(heights,0,newHeights,1,length);

        length += 2;
        heights = newHeights;

        stack.offer(0);

        for(int i = 1;i<length;i++){
            while(heights[i] < heights[stack.peekLast()]){
                int currHeight = heights[stack.pollLast()];
                int currWidth = i - stack.peekLast() -1;

                ans = Math.max(ans,currHeight * currWidth);
            }
            stack.addLast(i);
        }


        return ans;
    }
}
