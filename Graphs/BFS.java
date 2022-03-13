import java.util.*;

public class BFS {

	private static int count = 0;

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();		
		
		for (int i = 0; i < 12; i++) {
			graph.add(new ArrayList<>());
		}

		System.out.println("Graph created successfully");

		addEdge(graph,0,1); 
    	addEdge(graph,0,2); 
    	addEdge(graph,1,2); 
    	addEdge(graph,2,3); 
    	addEdge(graph,1,3);
    	addEdge(graph,3,4);
    	addEdge(graph,2,4);

    	addEdge(graph,5,6);
    	addEdge(graph,5,7);
    	addEdge(graph,6,7);

		addEdge(graph,8,9);

		addEdge(graph,10,11);    	

		System.out.println("Edges added");

		// printGraph(graph);

		boolean traversed[] = new boolean[12];
		// Queue<Integer> q = new LinkedList<>();

		int dis = 0;
		BFSTraversal(graph, traversed, 4);
		dis++;

		for (int i = 0; i < graph.size(); i++) {
			if (traversed[i] == false) {
				BFSTraversal(graph, traversed, i);	
				dis++;
			}
			
		}

		System.out.println("total disconnected components : " + dis);		

		// BFSTraversal(graph, 6, 0);
	}

	public static void BFSTraversal(ArrayList<ArrayList<Integer>> graph, boolean traversed[], int src) {

		// boolean traversed[] = new boolean[V];
		Queue<Integer> q = new LinkedList<>();

		q.add(src);
		traversed[src] = true;

		while (!q.isEmpty()) {
			
			int curr = q.poll();
			System.out.print(curr + " ");

			for (int ele : graph.get(curr)) {
				if (traversed[ele] == false) {
					q.add(ele);
					traversed[ele] = true;
				}
			}
		}

	}

	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> graph) {

		for (int i = 0; i < graph.size(); i++) {

			System.out.print(i + " -> ");

			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j) + " ");
			}
			System.out.println("\n");
		}
	}

}