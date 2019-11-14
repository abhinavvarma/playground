package lc;

import java.util.List;

class Count {
    int c;
    int v;

    public Count(int val) {
        this.c = 0;
        this.v = val;
    }
}

class LC315 {
    private boolean isOutOfBounds(Count[] cnts, int s, int e) {
        return (s < 0  || s >= cnts.length || e < 1 || e > cnts.length);
    }

    private void move() {

    }

    private void merge(Count[] cnts, int s1, int e1, int s2, int e2) {
        if (isOutOfBounds(cnts, s1, e1) || isOutOfBounds(cnts, s2, e2)) {
            return;
        }
        Count[] op = new Count[e1-s1+e2-s2];
        int i = s1, j = s2, k =0;
        while (i < e1 && j < e2) {
            if (cnts[i].v < cnts[j].v) {
                op[k++] = cnts[i++];
            } else {
                op[k++] = cnts[j++];
            }
        }
        while (i<e1) {
            op[k++] = cnts[i++];
        }
        while (j<e2) {
            op[k++] = cnts[j++];
        }
        for (i=0;i<op.length;i++)
            cnts[s1++] = op[i];
    }

    private void mergeSort(Count[] cnts, int s, int e) {
        if (isOutOfBounds(cnts, s, e) || e-s<2) {
            return;
        }

        int m = s + (e - s) / 2;
        mergeSort(cnts, s, m);
        mergeSort(cnts, m, e);
        merge(cnts, s, m, m, e);
    }

    public List<Integer> countSmaller(int[] nums) {
        Count[] counts = new Count[nums.length];
        for (int i = 0; i<nums.length; i++) {
            counts[i] = new Count(nums[i]);
        }

        mergeSort(counts, 0, counts.length);
        return null;
    }

    public static void main(String[] args) {
        LC315 l = new LC315();
        l.countSmaller(new int[]{5,2,6,1});
    }
}