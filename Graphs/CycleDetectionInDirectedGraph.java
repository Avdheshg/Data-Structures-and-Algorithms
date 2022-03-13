import java.util.*;

public class CycleDetectionInDirectedGraph {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    /*
        Logic: If V see a Back Edge: (a edge during recursion which is pointing to it's parent ) => then there is a cycle 
        How to detect the Back Edges: V use an backEdge[] which will hold all the parents which R in recursion call stack and which have been traversed. But if V have TR all of it's childrens and was not able to find any back edge then at the end of the recursion call of the parent V remove it from the array
    */
    public static boolean detectCycle(int v) {
        boolean vis[] = new boolean[v];
        boolean par[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                if (dfs(vis, par, i) == true) {
                    System.err.println("Cycle found");
                    return true;
                }
                // System.out.println("Res: " + res);
            }
        }
        return false;
    }

    public static boolean dfs(boolean vis[], boolean par[], int source) {
        vis[source] = true;
        par[source] = true;

        // this is the main code that detects the cycle
        for (int x: graph.get(source)) {
            // if this connection of source is not visited and it is also maing a back edge to source
            if (vis[x] == false && dfs(vis, par, x) == true) {
                System.out.println("Cycle found");
                return true;
            } 
            // as the above condition becomes false (means this connection of the source is visited and below V R checking if it is making a back edge if it does than V will return true)
            else if (par[x] == true) {
                System.out.println("Cycle found");
                return true;
            }
        }

        // This means that V have TR through all the connections of current source and among it's all connection ther is no back edge present and V have completed the recursive call for source so V R marking it as false as this source is of no use for us
        par[source] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 6;

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(0,1); 
        // addEdge(1,2); 
        addEdge(2,1); 
        addEdge(2,3); 
        addEdge(3,4); 
        addEdge(4,5);
        addEdge(5,3);

        // System.out.println("Is cycle: " + detectCycle(v));
        detectCycle(v);
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
