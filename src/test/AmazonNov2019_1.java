package test;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonNov2019_1 {
    int minimumTime(int n, List<Integer> parts) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(parts);
        int totalTime = 0;
        while (queue.size()>=2) {
            int time = queue.poll() + queue.poll();
            totalTime += time;
            queue.add(time);
        }
        return totalTime;
    }

    public static void main(String[] args) {
        AmazonNov2019_1 l = new AmazonNov2019_1();
        List<Integer> parts = Arrays.asList(8, 4, 6, 12);
        l.minimumTime(parts.size(), parts);
    }
}
