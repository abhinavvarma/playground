package lc;

public class LC75 {
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sortColors(int[] a) {
        if (a.length == 0)
            return;
        int oneStart = 0, cur = 0, twoStart = a.length - 1;

        while(cur <= twoStart) {
            if (a[cur]==0) {
                swap(a, cur, oneStart);
                oneStart++;
                cur++;
            } else if (a[cur] == 1) {
                cur++;
            } else {
                swap(a, cur, twoStart);
                twoStart--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 2, 0, 1 };
        LC75 l = new LC75();
        l.sortColors(a);
        System.out.println(a);
    }

}
