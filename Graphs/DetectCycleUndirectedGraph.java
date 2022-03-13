import java.util.*;

public class DetectCycleUndirectedGraph {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    /*
        Cycle can be detected using both BFS and DFS
        V say a cycle only when: 
            1st: V see a already visited node
            2nd: it's not the parent node of the current node
    */
    public static boolean detectCycle(int v, int source) {
        boolean vis[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                if (dfs(vis, i, -1) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(boolean vis[], int source, int par) {
        vis[source] = true;

        for (int x : graph.get(source)) {
            if (vis[x] == false) {
                dfs(vis, x, source);
            } else if (x != source) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int v = 6;

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0,1); 
        addEdge(1,2); 
        addEdge(2,4); 
        addEdge(4,5); 
        addEdge(1,3);
        addEdge(2,3);

        System.out.println("Is cycle: " + detectCycle(v, 0));
    }

    public static void addEdge(int u, int v) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static void print() {

		for (int i = 0; i < graph.size(); i++) {

			System.out.print(i + " -> ");

			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}
}
