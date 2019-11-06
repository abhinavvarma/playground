package utils;

import java.util.Arrays;


public class Display<T> {
    public static void print(int[] t) {
        System.out.println(Arrays.toString(t));
    }

    public void print(T[][] t) {
        for (T[] x : t)
        {
            for (T y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static void clear() {
        try {
            System.out.print("\033[H\033[2J");
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {

        }
    }

    public static void printLine() {
        System.out.println("---------------------------------");
    }
}
