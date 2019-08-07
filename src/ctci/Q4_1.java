package ctci;

import utils.graph.Node;

import java.util.LinkedList;

public class Q4_1 {

    public boolean search(Node s, Node e) {
        LinkedList<Node> q = new LinkedList<>();
        s.visited = true;
        q.add(s);
        while(!q.isEmpty()) {
            Node n = q.removeFirst();
            if (n == e)
                return true;
            for(Node a : n.getAdjacents()) {
                if (!a.visited)
                    q.add(a);
                a.visited = true;
            }
        }

        return false;
    }
}
