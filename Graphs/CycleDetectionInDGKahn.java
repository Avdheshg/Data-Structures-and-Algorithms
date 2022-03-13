import java.util.*;

public class CycleDetectionInDGKahn {
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    /*
        Using Kahn's Algo: How do V modify the Kahn's Algo to work here
            Kahn's Algo only works with DAG => means that it will print the topological sorting of the gp if it is DAG and will not print of there is an cycle. So V will use this fact i.e if there will be a cycle than this algo will not print all the edge of the graph(as it prints only those edge which has inDeg 0, and in cycle, all the elements which are forming cycle can't make their inDeg = 0)

        The change V need to make to Kahn's Algo is:
            Def a var count and whenever V poll an item into the Q V increment the count and at the end V return (count != v)
    */

    public static boolean detectCycleByKahn(int v) {
        Queue<Integer> q = new LinkedList<>();
        
        int inDeg[] = new int[v];
        System.out.println(Arrays.toString(inDeg));

        for (ArrayList<Integer> al: graph) {
            for (int x : al) {
                inDeg[x]++;
            }
        }

        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            count++;

            for (int x: graph.get(curr)) {
                inDeg[x]--;
                if (inDeg[x] == 0) {
                    q.add(x);
                }
            }
        }

        System.out.println("has Cycle: " + (count != v));
        return (count != v);
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
        detectCycleByKahn(v);
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
