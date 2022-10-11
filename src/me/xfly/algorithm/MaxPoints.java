package me.xfly.algorithm;

import org.junit.Test;

import java.util.HashMap;

public class MaxPoints {


    /*int[][] points;
    HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
    int horisontal_lines;

    Pair<Integer, Integer> addPointToLine(int i, int j, int count, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        if (x1 == x2 && y1 == y2) {
            duplicates++;
        } else if (y1 == y2) {
            horisontal_lines += 1;
            count = Math.max(horisontal_lines, count);
        } else {
            double slop = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;

            lines.put(slop, lines.getOrDefault(slop, 1) + 1);
            count = Math.max(count, lines.get(slop));
        }

        return new Pair<>(count, duplicates);
    }

    public int maxCountAtPoint(int index) {
        lines.clear();
        horisontal_lines = 1;
        int duplicates = 0;
        int count = 1;

        for (int i = index + 1; i < points.length; i++) {
            Pair<Integer, Integer> p = addPointToLine(index, i, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }

        return count + duplicates;
    }


    public int maxPoints(int[][] points) {

        this.points = points;
        // If the number of points is less than 3
        // they are all on the same line.
        if (points.length < 3)
            return points.length;

        int maxCount = 1;

        for (int i = 0; i < points.length; i++) {
            maxCount = Math.max(maxCount, maxCountAtPoint(i));
        }

        return maxCount;
    }

    @Test
    public void test() {
        int[][] points = {{0,0},{94911150,94911151},{94911151,94911152}};
        maxPoints(points);
    }*/
}