import java.util.*;

public class TopologicalSortingDFS {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    /*
        Algo: 
            V will use an Stack: 1st push all the connections of the root and then put the root
            V R using the stack so bcoz it will hold all the elements in decreasing number of inDeg (at the end, the top of the stack will have ele with min inDeg)4

            use the normal DFS, 
                in the rec funcion call push the source and in the caller after the DFS is finished print all the elements
    */

    public static void topoSort(int v) {
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                dfs(vis, stack, i);
            }
        }

        // After stack has all elements then print all. It will be full after the below dfs call
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void dfs(boolean vis[], Stack<Integer> stack, int source) {
        vis[source] = true;

        for (int x: graph.get(source)) {
            if (vis[x] == false) {
                dfs(vis, stack, x);
            }
        }
        stack.push(source);
    }

    public static void main(String[] args) {
        int v = 5;

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0,2); 
        addEdge(0,3); 
        addEdge(1,3); 
        addEdge(1,4); 
        addEdge(2,3); 
    }

    public static void addEdge(int u, int v) {
		graph.get(u).add(v);
		// graph.get(v).add(u);
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
