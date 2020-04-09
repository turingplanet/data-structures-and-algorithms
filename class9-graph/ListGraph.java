import java.util.*;

public class ListGraph {

    ArrayList<ArrayList<Integer>> graphs;

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
//        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
//        graph.addEdge(4, 5);
        graph.print();
        new GraphTraversal(graph).DFS();
        System.out.println();
        new GraphTraversal(graph).BFSTraversal(0);
    }

    public ListGraph(int v) {
        graphs = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public void addEdge(int start, int end) {
        graphs.get(start).add(end);
    }

    public void removeEdge(int start, int end) {
        graphs.get(start).remove((Integer)end);
    }

    public void print() {
        for (int i = 0; i < graphs.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < graphs.get(i).size(); j++) {
                System.out.print(" -> " + graphs.get(i).get(j));
            }
            System.out.println();
        }
    }
}
