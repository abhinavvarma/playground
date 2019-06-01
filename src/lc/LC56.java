package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Interval {
    int s, e;
    public Interval(int[] a) {
        this.s = a[0];
        this.e = a[1];
    }

    public boolean contains(int a) {
        return (s<=a && a<=e);
    }

    public boolean intersects(int[] a) {
        return (contains(a[0]) || contains(a[1])) || inside(a);
    }

    public boolean inside(int[] a) {
        return a[0] < s && e < a[1];
    }

    public void expand(int[] a) {
        if (a[0] < s)
            s = a[0];
        if (a[1] > e)
            e = a[1];
    }

    @Override public String toString() {
        return String.format("(%s, %s)", s, e);
    }

    public int[] toArray() {
        return new int[]{s, e};
    }
}

public class LC56 {
    public int greatestSmallerElementIndex(List<Interval> a, int l, int h, int v) {
        if (!(a.size()>0 && l>= 0 && l<a.size() && h>=0 && h<a.size()))
            return -1;
        if (a.get(l).s > v) {
            return l;
        } else if (a.get(h).s < v) {
            return h;
        }
        int p = -1;
        while (l<=h) {
            int m = (l+h)/2;
            if (a.get(m).s<=v) {
                l = m+1;
                p = m;
            } else if (a.get(m).s>v) {
                h = m-1;
            }
        }

        return p;
    }

    public List<Interval> mergeOverlaps(int[][] intervals) {
        List<Interval> sortedIntervals = new ArrayList<>();
        for (int[] in : intervals) {
            int p = greatestSmallerElementIndex(sortedIntervals, 0, sortedIntervals.size()-1, in[0]);
            if (p==-1 || !sortedIntervals.get(p).intersects(in))
                sortedIntervals.add(new Interval(in));
            else
                sortedIntervals.get(p).expand(in);
        }
        return sortedIntervals;
    }


    public int[][] merge(int[][] intervals) {
        List<Interval> iv = mergeOverlaps(intervals);
        int[][] merged = new int[iv.size()][2];
        for (int i = 0; i < iv.size(); i++) {
            merged[i] = iv.get(i).toArray();
        }
        return merged;
    }

    public static void main(String[] args) {
        LC56 l = new LC56();
        int[][] a = {{1,10},{2,3},{4,5},{6,7},{8,9}};
        System.out.println(l.mergeOverlaps(a));
    }
}
