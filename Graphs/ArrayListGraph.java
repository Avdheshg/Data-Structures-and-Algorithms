import java.util.*;

public class ArrayListGraph {

    public void addEdge(ArrayList<ArrayList<Integer>> graph, int i, int j) {
        graph.get(i).add(j);
        graph.get(j).add(i);
    }

    public void print(ArrayList<ArrayList<Integer>> graph) {
        // for (ArrayList<Integer> x : graph) {
        //     for (int y : x) {
        //         System.out.print(x + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        int v = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(v);

        // defining an AL at each pos
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ArrayListGraph obj = new ArrayListGraph();
        obj.addEdge(graph, 0, 1);
        obj.addEdge(graph, 0, 2);
        obj.addEdge(graph, 1, 2);
        obj.addEdge(graph, 1, 3);

        obj.print(graph);
    }

}
