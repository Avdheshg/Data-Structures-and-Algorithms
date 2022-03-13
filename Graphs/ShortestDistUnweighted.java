import java.util.*;

public class ShortestDistUnweighted {

    /*
        Algo: For each node the distance will be calculated from the given node so to calculate the dis V define a dis array which will hold the dist from their root node + 1
    */
    public static void shortestPath(ArrayList<ArrayList<Integer>> graph, boolean vis[], int v, int s) {
        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        System.out.println(Arrays.toString(dis));

        bfs(graph, vis, dis, s);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph,  boolean vis[], int dis[], int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int x: graph.get(curr)) {
                if (vis[x] == false) {
                    dis[x] = dis[curr] + 1;
                    vis[x] = true;
                    q.add(x);
                }
            }
        }

        System.out.println("Distance array: " + Arrays.toString(dis));
    }
    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 4, 5);

        // print(graph);

        boolean vis[] = new boolean[v];

        // V wants to find the shortest path from the given node to all the other nodes
        shortestPath(graph, vis, v, 0);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static void print(ArrayList<ArrayList<Integer>> graph) {

		for (int i = 0; i < graph.size(); i++) {

			System.out.print(i + " -> ");

			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}
}
