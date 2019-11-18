package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class AmazonNov2019_2 {
    void getOptimum(int capacity, int currentOptimalMem, int s, int e, List<List<Integer>> fApps, List<List<Integer>> bApps, List<List<Integer>> result) {
        if (s>=fApps.size() || e<0)
            return;
        int cMem = fApps.get(s).get(1) + bApps.get(e).get(1);
        if (cMem >= currentOptimalMem) {
            if (cMem<=capacity) {
                if (cMem > currentOptimalMem) {
                    currentOptimalMem = cMem;
                    result.clear();
                }
                result.add(Arrays.asList(fApps.get(s).get(0), bApps.get(e).get(0)));
                getOptimum(capacity, currentOptimalMem, s, e-1, fApps, bApps, result);
                getOptimum(capacity, currentOptimalMem, s+1, e, fApps, bApps, result);
            } else {
                getOptimum(capacity, currentOptimalMem, s, e-1, fApps, bApps, result);
            }
        }
    }

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList
            ) {
        List<List<Integer>> result = new ArrayList<>();
        foregroundAppList.sort(Comparator.comparingInt(o->o.get(1)));
        backgroundAppList.sort(Comparator.comparingInt(o->o.get(1)));
        getOptimum(
                deviceCapacity,
                0,
                0,
                backgroundAppList.size()-1,
                foregroundAppList,
                backgroundAppList,
                result
        );
        return result;
    }

    public static void main(String[] args) {
        AmazonNov2019_2 l = new AmazonNov2019_2();
        List<List<Integer>> foregroundAppList = Arrays.asList(Arrays.asList(1, 3),Arrays.asList(2, 4),Arrays.asList(3, 5),Arrays.asList(4, 10));
        List<List<Integer>> backgroundAppList = Arrays.asList(Arrays.asList(1, 2),Arrays.asList(2, 3),Arrays.asList(3, 4),Arrays.asList(4, 4));
        List<List<Integer>> result = l.optimalUtilization(10, foregroundAppList, backgroundAppList);
        System.out.println(result);
    }
}
