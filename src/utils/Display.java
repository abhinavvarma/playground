package utils;

import java.util.Arrays;


public class Display {
    public static void print1dArray(int[] t) {
        System.out.println(Arrays.toString(t));
    }

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
