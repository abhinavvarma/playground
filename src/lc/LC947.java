package lc;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


class Stone {
    int x, y;

    Stone(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public boolean visited = false;
}

public class LC947 {
    HashMap<Integer, Set<Stone>> rowMap = new HashMap<>();
    HashMap<Integer, Set<Stone>> colMap = new HashMap<>();


    void add(int key, Stone stone, final HashMap<Integer, Set<Stone>> map) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<>());
        }
        map.get(key).add(stone);
    }

    void createGraph(int[][] list) {
        for (int[] cord: list){
            Stone stone = new Stone(cord[0], cord[1]);
            add(stone.x, stone, rowMap);
            add(stone.y, stone, colMap);
        }
    }

    Set<Stone> getDirectlyConnected(Stone stone) {
        Set<Stone> stonesInSameRow = rowMap.getOrDefault(stone.x, Collections.emptySet());
        Set<Stone> stonesInSameCol = colMap.getOrDefault(stone.y, Collections.emptySet());
        HashSet<Stone> connected = new HashSet<>(stonesInSameRow);
        connected.addAll(stonesInSameCol);
        connected.remove(stone);
        return connected;
    }

    int countNodesInConnectedComponent(Stone stone) {
        if (stone.visited)
            return 0;
        stone.visited = true;
        Set<Stone> directlyConnected = getDirectlyConnected(stone);
        int totalConnectedNodes = 1;
        for (Stone connectedStone : directlyConnected) {
            totalConnectedNodes += countNodesInConnectedComponent(connectedStone);
        }
        return totalConnectedNodes;
    }

    public int removeStones(int[][] stones) {
        createGraph(stones);
        int totalRemovable = 0;
        for (Set<Stone> stonesInRow : rowMap.values()) {
            for (Stone stone : stonesInRow) {
                if (!stone.visited) {
                    totalRemovable += countNodesInConnectedComponent(stone) - 1;
                }
            }
        }
        return totalRemovable;
    }
}
