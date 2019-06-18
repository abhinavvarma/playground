package utils;

public class Display {
    public static void print2dArray(int[][] t) {
        for (int[] x : t)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
