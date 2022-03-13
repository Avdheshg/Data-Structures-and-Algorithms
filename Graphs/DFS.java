import java.util.*;

public class DFS {

    public void dfsRec(ArrayList<ArrayList<Integer>> graph, boolean vis[], int s) {
        vis[s] = true;
        System.out.print(s + " ");

        for (int x : graph.get(s)) {
            if (vis[x] == false) {
                dfsRec(graph, vis, x);
            }
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int v, int s) {
        boolean vis[] = new boolean[v];
        dfsRec(graph, vis, s);

        /*
            // for disconnnexted graph
            for (int i = 0; i < v; i++) {
                if (vis[i] == false) {
                    dfsRec(graph, i, vis);
                }
            }
        */
    }

    public static void main(String[] args) {
        DFS obj = new DFS();
        int v = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        obj.addEdge(graph,0,1); 
    	obj.addEdge(graph,0,2); 
    	obj.addEdge(graph,1,0); 
    	obj.addEdge(graph,1,3); 
    	obj.addEdge(graph,1,4);
    	obj.addEdge(graph,2,0);
    	obj.addEdge(graph,2,3);
    	obj.addEdge(graph,4,1);
    	obj.addEdge(graph,4,3);
    
        // obj.print(graph);

        obj.dfs(graph, v, 0);
    }

    
    public void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public void print(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            for (int x : graph.get(i) ) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

}
