package utils.arrays;

import java.util.HashMap;

public class Counter {
    private HashMap<Integer, Integer> counts = new HashMap<>();
    public Counter() {}
    public Counter(int[] nums) {
        for (int v : nums) {
            add(v);
        }
    }

    public int getCount(int v) {
        return counts.getOrDefault(v, 0);
    }

    public int add(int v) {
        int c = getCount(v) + 1;
        counts.put(v, c);
        return c;
    }
}
