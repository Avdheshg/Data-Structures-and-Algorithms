// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/

/*
    V use this algo to find the strongly connected components
    V have Kosaraju's algo also but it requires 2 TR of the graph
    This algo is related to Kosaraju, Articulation point and bridges in a graph

     Tarjan’s algorithm requires only one DFS traversal.

        Tarjan Algorithm is based on following facts: 
            1. DFS search produces a DFS tree/forest 
            2. Strongly Connected Components form subtrees of the DFS tree. 
            3. If we can find the head of such subtrees, we can print/store all the nodes in that subtree (including head) and that will be one SCC. 
            4. There is no back edge from one SCC to another (There can be cross edges, but cross edges will not be used while processing the graph).

            To find head of a SCC, we calculate disc and low array (as done for articulation point, bridge, biconnected component). As discussed in the previous posts, low[u] indicates earliest visited vertex (the vertex with minimum discovery time) that can be reached from subtree rooted with u. A node u is head if disc[u] = low[u].

        Disc: This is the time when a node is visited 1st time while DFS traversal. For nodes A, B, C, .., J in DFS tree, Disc values are 1, 2, 3, .., 10. 
Low: In DFS tree, Tree edges take us forward, from ancestor node to one of its descendants. For example, from node C, tree edges can take us to node node G, node I etc. Back edges take us backward, from a descendant node to one of its ancestors. For example, from node G, Back edges take us to E or C. If we look at both Tree and Back edge together, then we can see that if we start traversal from one node, we may go down the tree via Tree edges and then go up via back edges. For example, from node E, we can go down to G and then go up to C. Similarly from E, we can go down to I or J and then go up to F. “Low” value of a node tells the topmost reachable ancestor (with minimum possible Disc value) via the subtree of that node. So for any node, Low value equal to its Disc value anyway (A node is ancestor of itself). Then we look into its subtree and see if there is any node which can take us to any of its ancestor. If there are multiple back edges in subtree which take us to different ancestors, then we take the one with minimum Disc value (i.e. the topmost one). If we look at node F, it has two subtrees. Subtree with node G, takes us to E and C. The other subtree takes us back to F only. Here topmost ancestor is C where F can reach and so Low value of F is 3 (The Disc value of C). 

For any node u, when DFS starts, Low will be set to its Disc 1st. 

Then later on DFS will be performed on each of its children v one by one, Low value of u can change it two case: 
Case1 (Tree Edge): If node v is not visited already, then after DFS of v is complete, then minimum of low[u] and low[v] will be updated to low[u]. 
low[u] = min(low[u], low[v]); 
Case 2 (Back Edge): When child v is already visited, then minimum of low[u] and Disc[v] will be updated to low[u]. 
low[u] = min(low[u], disc[v]); 

In case two, can we take low[v] instead of disc[v] ?? . Answer is NO. If you can think why answer is NO, you probably understood the Low and Disc concept.
*/

// Java program to find strongly connected
// components in a given directed graph
// using Tarjan's algorithm (single DFS)
import java.io.*;
import java.util.*;

// This class represents a directed graph
// using adjacency list representation
class Graph {

    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<Integer> adj[];
    private int Time;

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

        Time = 0;
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // A recursive function that finds and prints strongly
    // connected components using DFS traversal
    // u --> The vertex to be visited next
    // disc[] --> Stores discovery times of visited vertices
    // low[] -- >> earliest visited vertex (the vertex with
    // minimum discovery time) that can be reached
    // from subtree rooted with current vertex
    // st -- >> To store all the connected ancestors (could be part
    // of SCC)
    // stackMember[] --> bit/index array for faster check
    // whether a node is in stack
    void SCCUtil(int u, int low[], int disc[],
            boolean stackMember[],
            Stack<Integer> st) {

        // Initialize discovery time and low value
        disc[u] = Time;
        low[u] = Time;
        Time += 1;
        stackMember[u] = true;
        st.push(u);

        int n;

        // Go through all vertices adjacent to this
        Iterator<Integer> i = adj[u].iterator();

        while (i.hasNext()) {
            n = i.next();

            if (disc[n] == -1) {
                SCCUtil(n, low, disc, stackMember, st);

                // Check if the subtree rooted with v
                // has a connection to one of the
                // ancestors of u
                // Case 1 (per above discussion on
                // Disc and Low value)
                low[u] = Math.min(low[u], low[n]);
            } else if (stackMember[n] == true) {

                // Update low value of 'u' only if 'v' is
                // still in stack (i.e. it's a back edge,
                // not cross edge).
                // Case 2 (per above discussion on Disc
                // and Low value)
                low[u] = Math.min(low[u], disc[n]);
            }
        }

        // head node found, pop the stack and print an SCC
        // To store stack extracted vertices
        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = (int) st.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            }
            System.out.println();
        }
    }

    // The function to do DFS traversal.
    // It uses SCCUtil()
    void SCC() {

        // Mark all the vertices as not visited
        // and Initialize parent and visited,
        // and ap(articulation point) arrays
        int disc[] = new int[V];
        int low[] = new int[V];
        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
        }

        boolean stackMember[] = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();

        // Call the recursive helper function
        // to find articulation points
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                SCCUtil(i, low, disc,
                        stackMember, st);
        }
    }

    // Driver code
    public static void main(String args[]) {

        // Create a graph given in the above diagram
        Graph g1 = new Graph(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println("SSC in first graph ");
        g1.SCC();

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        System.out.println("\nSSC in second graph ");
        g2.SCC();

        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        System.out.println("\nSSC in third graph ");
        g3.SCC();

        Graph g4 = new Graph(11);
        g4.addEdge(0, 1);
        g4.addEdge(0, 3);
        g4.addEdge(1, 2);
        g4.addEdge(1, 4);
        g4.addEdge(2, 0);
        g4.addEdge(2, 6);
        g4.addEdge(3, 2);
        g4.addEdge(4, 5);
        g4.addEdge(4, 6);
        g4.addEdge(5, 6);
        g4.addEdge(5, 7);
        g4.addEdge(5, 8);
        g4.addEdge(5, 9);
        g4.addEdge(6, 4);
        g4.addEdge(7, 9);
        g4.addEdge(8, 9);
        g4.addEdge(9, 8);
        System.out.println("\nSSC in fourth graph ");
        g4.SCC();

        Graph g5 = new Graph(5);
        g5.addEdge(0, 1);
        g5.addEdge(1, 2);
        g5.addEdge(2, 3);
        g5.addEdge(2, 4);
        g5.addEdge(3, 0);
        g5.addEdge(4, 2);
        System.out.println("\nSSC in fifth graph ");
        g5.SCC();
    }
}

// This code is contributed by
// Prateek Gupta (@prateekgupta10)
