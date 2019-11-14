package lc;

import utils.Display;
import utils.arrays.Boxing;

import java.util.PriorityQueue;
//class ShortestNode

public class LC743 {
    private static final int IGNORE = 7000;
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
            else if(timeFromK < shortestTimes[K][c])
                timeFromK = shortestTimes[K][c];
        }
        return timeFromK;
    }

    public int networkDelayTimeDijsktra(int[][] times, int N, int K) {
        times = getRoutes(times, N);
        PriorityQueue<int[]> queue = new PriorityQueue(((o1, o2) -> {o1}));
        queue.add()
        initialize(shortestTimes, IGNORE);
        for (int r = 1; r < times.length; r++) {
            traverse(times, shortestTimes, r);
        }
        int timeFromK = 0;
        for (int c = 1; c < times[K].length; c++) {
            if (shortestTimes[K][c] == IGNORE)
                return -1;
            else if(timeFromK < shortestTimes[K][c])
                timeFromK = shortestTimes[K][c];
        }
        return timeFromK;
    }

    public static void main(String[] args) {
        LC743 l = new LC743();
        int t = l.networkDelayTime(new int[][]
                {{10,9,79},{15,10,58},{14,4,99},{14,12,29},{12,15,26},{1,15,78},{2,11,88},{7,3,4},{3,1,52},{11,3,91},{11,12,11},{5,10,81},{1,7,44},{12,13,52},{3,14,83},{10,4,26},{5,9,72},{5,14,32},{13,10,32},{15,6,2},{3,9,18},{1,11,45},{5,8,98},{7,13,33},{1,2,59},{4,11,79},{11,1,12},{8,5,79},{2,14,93},{3,6,53},{11,10,40},{14,2,33},{4,9,61},{3,8,10},{10,7,1},{8,3,58},{1,12,20},{5,1,51},{7,1,37},{9,7,34},{9,10,48},{8,4,90},{12,1,92},{6,4,99},{2,15,3},{2,3,80},{2,4,60},{15,14,75},{2,7,20},{15,8,20},{5,12,19},{13,3,74},{7,5,6},{9,6,73},{9,14,49},{15,1,56},{8,2,10},{7,9,9},{12,5,67},{6,3,29},{9,4,38},{6,9,42},{5,3,57},{3,2,48},{12,6,77},{10,15,15},{12,4,68},{14,1,52},{13,4,80},{4,1,84},{14,10,68},{2,12,81},{2,1,31},{6,14,52},{7,8,68},{4,12,73},{8,14,88},{13,5,92},{6,1,3},{9,11,80},{3,15,23},{15,4,84},{5,11,41},{7,11,42},{11,7,86},{9,15,63},{1,4,36},{3,13,82},{6,15,91},{13,6,64},{14,11,32},{11,5,68},{6,5,55},{4,5,35},{13,1,1},{4,10,47},{12,9,1},{7,10,44},{3,7,23},{8,12,68},{8,6,13},{2,9,19},{10,6,91},{7,12,80},{8,7,12},{4,7,4},{9,2,67},{14,9,29},{15,13,80},{6,8,62},{15,12,36},{1,3,48},{2,10,67},{9,13,55},{11,6,62},{8,11,92},{13,15,30},{4,13,97},{5,4,25},{4,2,9},{15,5,5},{15,2,45},{10,8,23},{14,5,43},{5,13,98},{14,13,73},{4,8,29},{10,5,0},{11,13,68},{9,12,91},{12,2,56},{9,1,23},{14,6,80},{9,5,10},{12,11,89},{5,15,94},{7,2,20},{3,12,89},{2,13,9},{11,2,1},{10,13,85},{6,10,76},{1,10,2},{14,15,20},{3,11,15},{11,8,62},{12,7,63},{8,15,91},{8,10,30},{12,3,80},{5,7,94},{13,2,60},{14,8,77},{10,12,67},{13,8,9},{13,11,48},{5,6,77},{10,3,51},{4,15,84},{13,12,10},{13,14,28},{4,6,46},{3,10,53},{14,7,48},{10,11,21},{15,11,99},{12,10,93},{11,14,73},{15,3,81},{2,5,22},{12,8,20},{6,13,24},{8,13,41},{8,9,98},{2,6,98},{7,15,27},{6,11,15},{7,14,72},{10,14,96},{1,8,18},{1,6,2},{3,4,78},{4,3,10},{11,4,54},{12,14,40},{3,5,63},{10,2,94},{1,9,57},{6,12,12},{9,8,37},{8,1,77},{13,7,80},{10,1,25},{9,3,37},{4,14,28},{1,13,88},{1,5,45},{7,4,65},{6,2,19},{11,15,37},{7,6,90},{2,8,1},{1,14,63},{5,2,47},{15,9,34},{11,9,41},{15,7,90},{13,9,45},{14,3,34},{6,7,44}}
        , 15, 9);
        System.out.println(t);
    }
}
