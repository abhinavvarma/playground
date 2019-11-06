package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Input {
    private static String unwrap(String s) {
        return s.substring(1, s.length() - 1);
    }

    public static int[] read1DArray(String array) {
        String unwrapped = unwrap(array);
        String[] splits = unwrapped.split(",");
        int[] ints = new int[splits.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(splits[i]);
        }
        return ints;
    }

    public static int[][] read2DArray(String array2d) {
        String unwrapped = unwrap(array2d);
        Pattern p = Pattern.compile("(\\[\\d+,\\d+])");
        Matcher m = p.matcher(unwrapped);
        List<int[]> intsList = new ArrayList<>();
        while (m.find()) {
            intsList.add(read1DArray(m.group()));
        }
        int[][] ints1d = new int[intsList.size()][];
        intsList.toArray(ints1d);
        return ints1d;
    }
}
