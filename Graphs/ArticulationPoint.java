/*
    Articulation point: removal of which create multiple components in the graph
    V will be having connected and undirected graph

    Naive: O( (V+E) * (V+E) )
        Remove every vtx one by one and count number of connected components after the removal. If the count is more than one, then the removed vtx is an articulation point
        After this call a function which will count the connected components(Kosaraju/Tarjans)

    Efficient: O(V+E)   
        It has 2 main ideas
        1st: If the root of DFS tree has 2 or more children, then the root is an articulation point => By using this point only V can solve the question but it will take O(V*(V+E)) bcoz for every node V R using DFS considering it as 1st node
        2nd: If a non-root node u in DFS tree has a child "v" such that no ancestors are reachable from the subtree rooted with "v", then "u" is an Articulation point  

        How do V find out the non root node wheather they are AP or not for this V will use discovery time[] of the time at which DFS for u is called. Discovery values are simply the order in which V have done DFS traversal
        low value[]: smallest discovery time reachable from u considering both types of edges or lowest reachable discovery time. In undirected graph if u is connected with v the v is also connected with u but while calculating the low val we will consider only that u is connected with v means V consider them as directed graph and that's why V will not update the low val going back to the parent vtx

        Implementation details:
            A non root node u is an AP if there exists a child v such thta low[v] >= disc[u]
*/

// A Java program to find articulation
// points in an undirected graph
import java.util.*;

class Graph {

	static int time;

	static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static void APUtil(ArrayList<ArrayList<Integer> > adj, int u,
					boolean visited[], int disc[], int low[],
					int parent, boolean isAP[])
	{
		// Count of children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices adjacent to this
		for (Integer v : adj.get(u)) {
			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!visited[v]) {
				children++;
				APUtil(adj, v, visited, disc, low, u, isAP);

				// Check if the subtree rooted with v has
				// a connection to one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// If u is not root and low value of one of
				// its child is more than discovery value of u.
				if (parent != -1 && low[v] >= disc[u])
					isAP[u] = true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent)
				low[u] = Math.min(low[u], disc[v]);
		}

		// If u is root of DFS tree and has two or more children.
		if (parent == -1 && children > 1)
			isAP[u] = true;
	}

	static void AP(ArrayList<ArrayList<Integer> > adj, int V)
	{
		boolean[] visited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		boolean[] isAP = new boolean[V];
		int time = 0, par = -1;

		// Adding this loop so that the
		// code works even if we are given
		// disconnected graph
		for (int u = 0; u < V; u++)
			if (visited[u] == false)
				APUtil(adj, u, visited, disc, low, par, isAP);

		for (int u = 0; u < V; u++)
			if (isAP[u] == true)
				System.out.print(u + " ");
		System.out.println();
	}

	public static void main(String[] args)
	{

		// Creating first example graph
		int V = 5;
		ArrayList<ArrayList<Integer> > adj1 =
						new ArrayList<ArrayList<Integer> >(V);
		for (int i = 0; i < V; i++)
			adj1.add(new ArrayList<Integer>());
		addEdge(adj1, 1, 0);
		addEdge(adj1, 0, 2);
		addEdge(adj1, 2, 1);
		addEdge(adj1, 0, 3);
		addEdge(adj1, 3, 4);
		System.out.println("Articulation points in first graph");
		AP(adj1, V);

		// Creating second example graph
		V = 4;
		ArrayList<ArrayList<Integer> > adj2 =
						new ArrayList<ArrayList<Integer> >(V);
		for (int i = 0; i < V; i++)
			adj2.add(new ArrayList<Integer>());

		addEdge(adj2, 0, 1);
		addEdge(adj2, 1, 2);
		addEdge(adj2, 2, 3);

		System.out.println("Articulation points in second graph");
		AP(adj2, V);

		// Creating third example graph
		V = 7;
		ArrayList<ArrayList<Integer> > adj3 =
							new ArrayList<ArrayList<Integer> >(V);
		for (int i = 0; i < V; i++)
			adj3.add(new ArrayList<Integer>());

		addEdge(adj3, 0, 1);
		addEdge(adj3, 1, 2);
		addEdge(adj3, 2, 0);
		addEdge(adj3, 1, 3);
		addEdge(adj3, 1, 4);
		addEdge(adj3, 1, 6);
		addEdge(adj3, 3, 5);
		addEdge(adj3, 4, 5);

		System.out.println("Articulation points in third graph");

		AP(adj3, V);
	}
}
































