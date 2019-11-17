package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AmazonNov2019_2 {
    List<List<Integer>> getOptimum(int capacity, List<List<Integer>> fApps, List<List<Integer>> bApps) {
        List<List<Integer>> result = new ArrayList<>();
        int optimalMem = 0, s = 0, e = bApps.size() - 1;
        while (true) {
            int cMem = fApps.get(s).get(1) + bApps.get(e).get(1);
            if (cMem > optimalMem) {
                if (cMem<=capacity) {
                    optimalMem = cMem;
                    result = new ArrayList<>();
                    result.add(Arrays.asList(fApps.get(s).get(0), bApps.get(e).get(0)));
                    s++;
                } else {
                    e--;
                }
            } else if (cMem == optimalMem) {
                result.add(Arrays.asList(fApps.get(s).get(0), bApps.get(e).get(0)));
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AmazonNov2019_2 l = new AmazonNov2019_2();
        l.getOptimum(
                10,
                Arrays.asList(Arrays.asList(1, 3),Arrays.asList(2, 5),Arrays.asList(3, 7),Arrays.asList(4, 10)),
                Arrays.asList(Arrays.asList(1, 2),Arrays.asList(2, 3),Arrays.asList(3, 4),Arrays.asList(4, 5))
        );
    }
}
