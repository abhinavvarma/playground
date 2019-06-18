package lc;

public class LC70 {

    private int climbStairs(int i, int n) {
        if (n == i)
            return 1;
        if (i > n)
            return 0;
        return climbStairs(i+1, n) + climbStairs(i+2, n);
    }

    private int[] generateTable(int n) {
        int[] a = new int[n+2];
        a[n] = 1;
        a[n+1] = 0;
        for (int i = n-1; i >= 0; i--) {
            a[i] = a[i+1] + a[i+2];
        }
        return a;
    }

    public int climbStairs(int n) {
//        return climbStairs(0, n);
        return generateTable(n)[0];
    }

    public static void main(String[] args) {
        LC70 l = new LC70();
        System.out.println(l.climbStairs(5));
    }
}
