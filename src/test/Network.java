package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Network {
    int time = 0;
    Map<Integer, Set<Integer>> adjacencyMatrix;

    public Network(List<List<Integer>> links) {
        adjacencyMatrix = getAdjacencyMatrix(links);
    }


    void add(Map<Integer, Set<Integer>> adj, int e1, int e2) {
        if (!adj.containsKey(e1)) {
            adj.put(e1, new HashSet<>());
        }
        adj.get(e1).add(e2);
    }

    Map<Integer, Set<Integer>> getAdjacencyMatrix(List<List<Integer>> links) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for(List<Integer> link:links){
            add(adj, link.get(0), link.get(1));
            add(adj, link.get(1), link.get(0));
        }
        return adj;
    }

    List<Integer> findCriticalRouters(List<List<Integer>> links)
    {
        Map<Integer, Integer> discoveryTimes = new HashMap<>();
        Map<Integer, Integer> lowestParents = new HashMap<>();
        List<Integer> routers = new ArrayList<>(adjacencyMatrix.keySet());
        Set<Integer> unvisited = new HashSet<>(routers);
        List<Integer> result = new ArrayList<>();
        lowestParents.put(routers.get(0), routers.get(0));
        for (int id : routers) {
            traverse(id, -1, unvisited, discoveryTimes, lowestParents);
        }
        return result;
    }

    private int traverse(Integer id, Integer parent, final Set<Integer> unvisited,
            final Map<Integer, Integer> discoveryTimes,
            final Map<Integer, Integer> lowestParents) {
        int lowestParent = Integer.MAX_VALUE;
        if (unvisited.contains(id)) {
            unvisited.remove(id);
            discoveryTimes.put(id, ++time);
            Set<Integer> children = adjacencyMatrix.get(id);
            for (int child : children) {
                if (child != parent)
                    lowestParent = Math.min(
                            traverse(child, id, unvisited, discoveryTimes, lowestParents),
                            lowestParent
                    );
            }
            lowestParents.put(id, lowestParent);
        } else {
            if (lowestParents.containsKey(id))
                lowestParent = lowestParents.get(id);
            else
                lowestParent = id;
        }
        return lowestParent;
    }

    public static void main(String[] args) {
        List<List<Integer>> links = Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(1, 2),
                Arrays.asList(4, 3),
                Arrays.asList(3, 2),
                Arrays.asList(3, 5),
                Arrays.asList(3, 6),
                Arrays.asList(5, 6)
        );
        Network l = new Network(links);
        List<Integer> integers = l.findCriticalRouters(links);
        System.out.println(integers);
    }
}
