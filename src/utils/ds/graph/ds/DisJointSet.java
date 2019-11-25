package utils.ds.graph.ds;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

class DisJointSetParent<T> {
    T parent;

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    int rank;

    public DisJointSetParent(T parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

public class DisJointSet<T> {
    private Map<T, DisJointSetParent> map = new HashMap<>();

    public void makeSet(Set<T> nodes) {
        for (T node : nodes) {
            map.put(node, new DisJointSetParent<>(node, 1));
        }
    }

    public T find(T node) {
        T parent = (T) map.getOrDefault(node, new DisJointSetParent<>(node, 1)).getParent();
        if (parent != node) {
            parent = find(parent);
        }
        return parent;
    }
}