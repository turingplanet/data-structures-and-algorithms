import java.util.*;

public class ListGraph {

    ArrayList<ArrayList<Integer>> graphs;

    public static void main(String[] args) {
        ListGraph graph = new ListGraph(5);
        graph.addEdge(0, 5);
        graph.addEdge(0, 4);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.print();
        graph.removeEdge(0, 2);
        graph.print();
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
