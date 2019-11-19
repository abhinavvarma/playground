package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GraphArticulationPoints {
    private int time = 0;
    private Map<Integer, Set<Integer>> adjacencyMatrix;

    public GraphArticulationPoints(List<List<Integer>> links) {
        adjacencyMatrix = getAdjacencyMatrix(links);
    }


    private void addEdge(Map<Integer, Set<Integer>> adj, int e1, int e2) {
        if (!adj.containsKey(e1)) {
            adj.put(e1, new HashSet<>());
        }
        adj.get(e1).add(e2);
    }

    Map<Integer, Set<Integer>> getAdjacencyMatrix(List<List<Integer>> links) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(List<Integer> link:links){
            addEdge(adj, link.get(0), link.get(1));
            addEdge(adj, link.get(1), link.get(0));
        }
        return adj;
    }

    Set<Integer> findCriticalRouters(List<List<Integer>> links, int root)
    {
        List<Integer> routers = new ArrayList<>(adjacencyMatrix.keySet());
        Set<Integer> unvisited = new HashSet<>(routers);
        Set<Integer> result = new HashSet<>();
        traverse(root, -1, unvisited, result);
        return result;
    }

    private int traverse(Integer id, Integer parent, final Set<Integer> unvisited, Set<Integer> result) {
        int lowestParent = Integer.MAX_VALUE;
        if (unvisited.contains(id)) {
            unvisited.remove(id);
            int discoveryTime = ++time;
            Set<Integer> children = adjacencyMatrix.get(id);
            int noOfChildrenInDFSTree = 0;
            for (int child : children) {
                if (child != parent) {
                    if (unvisited.contains(child))
                        noOfChildrenInDFSTree++;
                    int lowestParentOfChild = traverse(child, id, unvisited, result);
                    lowestParent = Math.min(lowestParentOfChild, lowestParent);
                    if (lowestParentOfChild >= discoveryTime) {
                        result.add(id);
                    }
                }
            }
            if (parent == -1) {
                if (noOfChildrenInDFSTree > 1)
                    result.add(id);
                else
                    result.remove(id);
            }
        } else {
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
        GraphArticulationPoints l = new GraphArticulationPoints(links);
        Set<Integer> integers = l.findCriticalRouters(links, 3);
        System.out.println(integers);
    }
}
