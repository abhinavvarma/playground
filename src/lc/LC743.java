package lc;

import utils.Display;
import utils.arrays.Boxing;

public class LC743 {
    private static final int IGNORE = -1;
    private void initialize(int[][] arr, int val) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr.length; c++) {
                if (r==c) {
                    arr[r][c] = 0;
                } else {
                    arr[r][c] = val;
                }
            }
        }
    }

    private void traverse(int[][] times, int[][] shortestTimes, int src) {
        System.out.println("\n----------------------------------------\n");
        System.out.println("Traversing from src = "+ src);
        for (int i = 1; i < times[src].length; i++) {
            if (times[src][i]!=IGNORE && times[src][i] < shortestTimes[src][i]) {
                shortestTimes[src][i] = times[src][i];
                System.out.println(String.format("%s->%s = %s", src, i, shortestTimes[src][i]));
                traverse(times, shortestTimes, i);
                for (int j = 1; j < shortestTimes[i].length; j++) {
                    if (shortestTimes[i][j]==IGNORE)
                        continue;
                    int timeFromSrcToJViaI = shortestTimes[src][i] + shortestTimes[i][j];
                    if (shortestTimes[src][j] > timeFromSrcToJViaI) {
                        shortestTimes[src][j] = timeFromSrcToJViaI;
                    }
                }
                new Display<Integer>().print2dArray(Boxing.toInteger2DArray(shortestTimes));
            }
        }
    }

    private int[][] getRoutes(int[][] times, int N) {
        int[][] routes = new int[N+1][N+1];
        initialize(routes, IGNORE);
        for (int[] time : times) {
            routes[time[0]][time[1]] = time[2];
        }
        return routes;
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        times = getRoutes(times, N);
        int[][] shortestTimes = new int[N+1][N+1];
        initialize(shortestTimes, IGNORE);
        for (int r = 1; r < times.length; r++) {
            traverse(times, shortestTimes, r);
        }
        int timeFromK = 0;
        for (int c = 1; c < times[K].length; c++) {
            if (shortestTimes[K][c] == IGNORE)
                return -1;
            else
                timeFromK += shortestTimes[K][c];
        }
        return timeFromK;
    }

    public static void main(String[] args) {
        LC743 l = new LC743();
        l.networkDelayTime(new int[][]{
                {1,4,1},
                {2,1,1},
                {2,3,7},
                {2,4,10},
                {4,3,2}
        }, 4, 2);
    }
}
