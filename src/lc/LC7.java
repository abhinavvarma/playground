package lc;

public class LC7 {
    public static int reverseInt(int x) {
        int lastDigit;
        int reversed = 0;
        boolean isNegative = x < 0;
        while (x > 0) {
            lastDigit = x % 10;
            reversed = 10 * reversed + lastDigit;
            if (isOverflowing(reversed, lastDigit, isNegative)) {
                return 0;
            }
            x = x / 10;
        }
        return reversed;
    }

    private static boolean isOverflowing(final int reversed, final int lastDigit, final boolean isNegative) {
        int max;
        if (isNegative)
            max = Integer.MAX_VALUE;
        else
            max = Integer.MIN_VALUE;
        return (reversed > max/10) || (reversed == max / 10 && lastDigit > max % 10);
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(123));
    }
}


