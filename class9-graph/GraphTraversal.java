import java.util.*;

public class GraphTraversal {

    ListGraph graph;
    boolean[] visited;

    public GraphTraversal(ListGraph listGraph) {
        this.graph = listGraph;
        visited = new boolean[listGraph.graphs.size()];
    }

    public void DFSTraversal(int v) {
        if(visited[v]) return;
        visited[v] = true;
        System.out.print(v + " -> ");
        Iterator<Integer> neighbors = graph.graphs.get(v).listIterator();
        while (neighbors.hasNext()) {
            int nextNode = neighbors.next();
            if (!visited[nextNode]) {
                DFSTraversal(nextNode);
            }
        }
    }

    public void DFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                DFSTraversal(i);
            }
        }
    }

public void BFSTraversal(int v) {
    Deque<Integer> queue = new ArrayDeque<>();
    visited[v] = true;
    queue.offerFirst(v);
    while (queue.size() != 0) {
        Integer cur = queue.pollFirst();
        System.out.print(cur + " -> ");
        Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();
        while (neighbors.hasNext()) {
            int nextNode = neighbors.next();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                queue.offerLast(nextNode);
            }
        }
    }
}

public void BFS() {
    for (int i = 0; i < graph.graphs.size(); i++) {
        if (!visited[i]) {
            BFSTraversal(i);
        }
    }
}
}
