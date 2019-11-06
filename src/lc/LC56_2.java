package lc;

import java.util.Arrays;
import java.util.Comparator;


public class LC56_2 {

//    public int[][] merge(int[][] intervals) {
////        sort based on the first ele
//        Arrays.sort(intervals, Comparator.comparingInt(ele -> ele[0]));
////        iterate and merge with the next ele
//        int filledTill = 0, compareWith = 1;
//        while (compareWith<intervals.length) {
//            if (mergeIfOverlapping(intervals[filledTill], intervals[compareWith])) {
//
//            }
//        }
//    }
//
//    private boolean mergeIfOverlapping(final int[] interval1, final int[] interval2, int[] mergedEle) {
//        int left, right;
//        boolean merged = false;
//        if (interval1[0]<interval2[0]) {
//            left = interval1[0];
//            merged = true;
//        }
//        if (interval1[1]interval2[0]) {
//            left = interval1[0];
//            merged = true;
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        LC56_2 l = new LC56_2();
//        int[][] a = {{10,10},{2,3},{4,5},{6,7},{8,9}};
//        l.merge(a);
//    }
}
