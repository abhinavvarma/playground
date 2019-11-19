package lc;

import utils.Display;
import utils.Input;


public class LC57 {
    private int getInsertPosition(int[][] a, int t, int x) {
        int l = 0, h = a.length - 1, m = 0, p = a.length;

        while (l<=h) {
            m = l + (h-l)/2;
            if (a[m][x]>=t) {
                p = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return p;
    }

    private boolean isInRange(int[] range, int x) {
        return (range[0] <= x && range[1]>= x);
    }

    private int[][] merge(int[][] intervals, int s, int e, int[] newInterval) {
        int nMerged = e-s;

        if (s>= 0 && s<intervals.length && intervals[s][1] >= newInterval[0]) {
            newInterval[0] = Math.min(intervals[s][0], newInterval[0]);
        }
        if (e>= 0 && e<intervals.length && intervals[e][0] <= newInterval[1]) {
            newInterval[1] = Math.max(intervals[e][1], newInterval[1]);
        }
        int newLength = intervals.length-nMerged+1;
        int[][] newIntervals = new int[newLength][2];
        System.out.println(newIntervals.length);
        int[] mergeIndices = new int[] {s, e};

        for (int i = 0, j = 0; j < newIntervals.length; i++, j++) {
            if (isInRange(mergeIndices, i)) {
                newIntervals[j] = newInterval;
                i = e;
            } else {
                newIntervals[j] = intervals[i];
            }
        }

        return newIntervals;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int s = getInsertPosition(intervals, newInterval[0], 0);
        if (s>0 && s<=intervals.length && isInRange(intervals[s-1], newInterval[0])) {
            s--;
        }
        int e = getInsertPosition(intervals, newInterval[1], 1);
        if (e>=0 && e<intervals.length && !isInRange(intervals[e], newInterval[1])) {
            e--;
        }
        e = Math.max(s, e);
        System.out.println(String.format("s:%s", s));
        System.out.println(String.format("e:%s", e));
        return merge(intervals, s, e, newInterval);
    }

    public static void main(String[] args) {
        LC57 l = new LC57();
//        Display.print(l.insert(Input.read2DArray("[[1,5]]"), Input.read1DArray("[2,7]")));
    }
}
