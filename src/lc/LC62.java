package lc;

import java.util.HashMap;
import java.util.Map;


public class LC62 {
    HashMap<String, Integer> cache = new HashMap<String, Integer>();

    public int uniquePaths(int m, int n) {
        String key = String.format("%s-%s", m, n);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        if (m==1 && n ==1)
            return 1;
        if (m<1 || n <1)
            return 0;
        int val = uniquePaths(m-1, n) + uniquePaths(m, n - 1);
        cache.put(key, val);
        return val;
    }

    public static void main(String[] args) {
        LC62 l = new LC62();
        System.out.println(l.uniquePaths(7, 3));
    }
}
