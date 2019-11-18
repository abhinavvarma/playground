package test;

import java.util.*;

public class A2 {
    int time = 0;
    static final int NIL = -1;
    void add(Map<Integer, Set<Integer>> adj, int e1, int e2) {
        --e1;--e2;
        if (!adj.containsKey(e1)) {
            adj.put(e1, new HashSet<>());
        }
        adj.get(e1).add(e2);
    }

    Map<Integer, Set<Integer>> getAdjacencyMatrix(int numRouters, List<List<Integer>> links) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for(List<Integer> link:links){
            add(adj, link.get(0), link.get(1));
            add(adj, link.get(1), link.get(0));
        }
        return adj;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  List<List<Integer>> links)
    {
        // WRITE YOUR CODE HERE
        boolean visited[] = new boolean[numRouters];
        int discoveryTimes[] = new int[numRouters];
        int low[] = new int[numRouters];
        int parent[] = new int[numRouters];
        boolean ap[] = new boolean[numRouters];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numRouters; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }
        Map<Integer, Set<Integer>> adjacencyMatrix = getAdjacencyMatrix(numRouters, links);
        for (int i = 0; i < numRouters; i++) {
            if (!visited[i]) {
                dfs(adjacencyMatrix, i, visited, discoveryTimes, low, parent, ap);
            }
        }

        for (int i = 0; i < numRouters; i++)
            if (ap[i])
                result.add(i+1);
        return result;
    }

    private void dfs(Map<Integer, Set<Integer>> adjacencyMatrix, int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        if (adjacencyMatrix.containsKey(u))
        {
            Iterator<Integer> i = adjacencyMatrix.get(u).iterator();
            while (i.hasNext())
            {
                int v = i.next();
                if (!visited[v])
                {
                    children++;
                    parent[v] = u;
                    dfs(adjacencyMatrix, v, visited, disc, low, parent, ap);

                    low[u]  = Math.min(low[u], low[v]);

                    if (parent[u] == 0 && children > 1)
                        ap[u] = true;

                    if (parent[u] != NIL && low[v] >= disc[u])
                        ap[u] = true;
                }
                else if (v != parent[u])
                    low[u]  = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        A2 l = new A2();
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(1, 2),
                Arrays.asList(4, 3),
                Arrays.asList(3, 2),
                Arrays.asList(3, 5),
                Arrays.asList(3, 6),
                Arrays.asList(5, 6)
        );
        List<Integer> integers = l.criticalRouters(6, 7, graph);
        System.out.println(integers);
    }
}
