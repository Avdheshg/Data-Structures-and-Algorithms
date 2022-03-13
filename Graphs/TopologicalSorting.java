import java.util.*;

public class TopologicalSorting {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    /* *********** Kahn's Algo ******
    // Topologiacal sorting: Happens in DAG only: V consider all nodes as Jobs to be completed. IF there is an edge from, 3 <- 1 -> 2, than as if 2 and 3 wants to finish than they must wait for 1 to finish

        Algo:
            1st print the 0 indegree vtx
                A Q will store 0 InD vtx
            After handling the 0 InD vtx => V make the InD of rest of connection -1 and when from the connections anyone becomes 0 V will enQ it into the Q (InD = 0, means that it has no dependancy on any vtx)

            V will use BFS:
                1. store the InD of each vtx
                2. def a Q
                3. add all 0 InD vtx to the Q
                4. Loop which Q is not empty
                    a. pop the item from Q (as Q will store only 0 InD vtx)
                    b. print it 
                    c. go to all the connections of it 
                        c1. reduce the InD by 1
                        c2. add those which has InD = 0 to Q
    */

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v];
        
        int inDeg[] = new int[v];

        Arrays.fill(inDeg, 0);

        // calculating inDeg of each vtx
        for (ArrayList<Integer> al: graph) {
            for (int x: al) {
                inDeg[x]++;
            }
        }

        // System.out.println("InDeg[]: " + Arrays.toString(inDeg));

        // adding 0 InD vtx to the Q
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        // System.out.println("0 inDeg: " + q);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int x: graph.get(curr)) {
                inDeg[x]--;
                if (inDeg[x] == 0) {
                    q.add(x);
                }
            }
        }
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

        // print();

        // System.out.println("Is cycle: " + detectCycle(v));
        bfs(v);
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
