import java.util.*;

public class Z {

	private static ArrayList<ArrayList<String>> graph = new ArrayList<>();

	public static void main(String[] args) {
		
		

		// int V = 6;
		int V = 7;

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, "Paresh", "Teda");
		addEdge(graph, "Paresh", "Banshi");
		// addEdge(graph, "Paresh", "Chacha");
		// addEdge(graph, "Paresh", "Chachi");

		// addEdge(graph, "Teda", "Chacha");
		// addEdge(graph, "Teda", "Chachi");

		// addEdge(graph, "Chacha", "Chachi");

		// addEdge(graph, "Banshi", "Tanuj");
		// addEdge(graph, "Banshi", "Punna");

		// addEdge(graph, "Tanuj", "Punna");

		// printGraph(graph);

		boolean vis[] = new boolean[V];
		int count = 0;

		// for (int i = 0; i < V; i++) {

		// 	if (vis[i] == false){
		// 		BFS(graph, vis, i);
		// 		count++;
		// 	}		
		// }

		// System.out.println("Connected componenets : " + count);

		// BFS(graph, vis, 0);

	}

	// public static void DFS(ArrayList<>)

	public static void BFS(ArrayList<ArrayList<Integer>> graph, boolean vis[], int src) {

		Queue<Integer> q = new LinkedList<>();

		q.add(src);
		vis[src] = true;
		

		while (!q.isEmpty()) {

			int temp = q.poll();
			System.out.println("Unique nodes => " + temp + " ");

			for (int ele : graph.get(temp)) {

				if (vis[ele] == false) {

					// System.out.print("Nodes addded to the queue => " + temp + " ");
					vis[ele] = true;
					q.add(ele);

				}
			}

			// int u = q.poll(); 
		}

	}

	public static void addEdge(String u, String v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> graph) {

		for (int i = 0; i < graph.size(); i++) {

			System.out.print(i + " -> ");

			for (int ele : graph.get(i)) {
				System.out.print(ele + " ");
			}

			System.out.println();
		}
	}

}