package lc;

public class LC70 {

    private int climbStairs(int i, int n) {
        if (n == i)
            return 1;
        if (i > n)
            return 0;
        return climbStairs(i+1, n) + climbStairs(i+2, n);
    }

    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public static void main(String[] args) {
        LC70 l = new LC70();
        System.out.println(l.climbStairs(44));
    }
}
