package lc;

import java.util.*;

enum Slope {
    Horizontal,
    Vertical
}

class Side {
    public Side(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Side(int[][] sortedPoints, int s) {
        this(sortedPoints[s][0], sortedPoints[s][1], sortedPoints[s+1][0], sortedPoints[s+1][1]);
    }

    public int x1, y1, x2, y2;

}

public class LC939 {
    public int minAreaRect(int[][] points) {
        int minArea = Integer.MAX_VALUE;
        int[][] sortedByX = points;
        int[][] sortedByY = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedByX, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(sortedByY, Comparator.comparingInt(o -> o[1]));
        HashMap<Integer, Set<Integer>> yCordMap = new HashMap<>();
        int outerVertLineIndex = getNextLine(sortedByX, sortedByX.length, Slope.Vertical);
        Side leftSide = new Side(sortedByX, outerVertLineIndex);
        Set<Integer> pointsOnY1 = yCordMap.get(leftSide.y1);
        for (Integer x2 : pointsOnY1) {
            if (yCordMap.get(leftSide.y2).contains(x2)){
//                minArea = Math.min(minArea, getArea(leftSide.x1, leftSide.y1, x2, ))
            }
        }

        return minArea;
    }

    private int getArea(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }

    private int getNextLine(int[][] sortedPoints, int prvIndex, Slope slope) {
        int constCoord;
        if (slope == Slope.Horizontal)
            constCoord = 1;
        else
            constCoord = 0;
        if (prvIndex >= sortedPoints.length) {
            prvIndex = sortedPoints.length;
        }
        while (prvIndex>=2) {
            if (sortedPoints[prvIndex-1][constCoord] == sortedPoints[prvIndex-2][constCoord]) {
                return prvIndex - 2;
            }
            --prvIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC939 l = new LC939();
        int area = l.minAreaRect(new int[][]{
                {1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}
        });
        System.out.println(area);
    }
}
