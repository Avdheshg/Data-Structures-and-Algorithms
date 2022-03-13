import java.util.*;

public class KosarajusAlgo {   // O(V+E)
    // https://www.geeksforgeeks.org/strongly-connected-components/
    /*
        Used to solve for strongly connected components (every pair is reachable from each other)
        In this algo, visit all the sink nodes 1st and then move towrds the source
        Source: Everything is reachable from this vtx
        Sink: Everything is not reachable

        In  DFS:
            Start time: when V make a recursive call for a vtx
            Finish time: When all the connections for root are finished 
            
        Algo:
            1. Order the vtx in decreasing order of finish time in DFS (think about topological sort, In topological sort, in the stack V get the elements in the decreasing order of their finish time)
            2. Reverse all edges
            3. Do DFS of reversed graph in the order obtained in step 1. For every vtx, all of ti's connections will be strongly connected components
    */

    private int v;
    private LinkedList<Integer> adj[];    // adjacency matrix. Array of type LL

    // Constructor
    KosarajusAlgo(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    // add an adge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);     
        // add() This method Appends the specified element to the end of this list
    }

    // A recursive function to print DFS starting from V
    void DFSUntil(int v, boolean vis[]) {
        vis[v] = true;
        System.out.print(v + " ");

        int n;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            n = i.next();
            if (!vis[n]) {
                DFSUntil(n, vis);
            }
        }
    }

    // function for reverse or transpose the graph
    KosarajusAlgo getTranspose() {
        KosarajusAlgo graph = new KosarajusAlgo(v);

        for (int i = 0; i < v; i++) {

            // recur for all the connections of this vtx
            Iterator<Integer> j = adj[i].listIterator();
            while (j.hasNext()) {
                graph.adj[j.next()].add(i);
            }
        }

        return graph;
    }

    // this is the DFS function in topological sort
    void fillOrder(int v, boolean vis[], Stack stack) {
        vis[v] = true;

        // recur for all the connections of this vtx
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!vis[n]) {
                fillOrder(n, vis, stack);
            }
        }

        stack.push(new Integer(v));
    }

    // The main function that finds and prints all strongly connected components
    void printSCCs() {
        Stack stack = new Stack();

        boolean vis[] = new boolean[v];
        // Mark all the vertices as not visited (For first DFS)
        Arrays.fill(vis, false);

        // Fill the vtx in stack according to their finish time
        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                fillOrder(i, vis, stack);
            }
        }

        // Create a reversed graph
        KosarajusAlgo graph = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        Arrays.fill(vis, false);

        // Now process all vtx in order defined by the stack
        while (!stack.isEmpty()) {
            int v = (int) stack.pop();

            // Print all the connections of the popped vtx => these will be now SCC
            if (vis[v] == false) {
                graph.DFSUntil(v, vis);
                System.out.println();
            } 
        }

    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        KosarajusAlgo graph = new KosarajusAlgo (5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
  
        System.out.println("Following are strongly connected components "+
                           "in given graph ");
        graph.printSCCs();
    }
}
