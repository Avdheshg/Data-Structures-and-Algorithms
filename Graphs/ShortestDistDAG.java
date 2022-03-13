import java.util.*;

public class ShortestDistDAG {

    static int v;
    static ArrayList<ArrayList<GraphNode>> graph;

    // Constructor initialising the AL
    ShortestDistDAG(int v) {
        this.v = v;
        graph = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // V can solve this using Bellman ford[O(VE)] and Dijkstra[O(ElogV)] but Topological sorting[O(V+E)] is the efficient one
    /*
        Algo: 
            Def a new array and initialise it with INF (this will a distance array which will hold the distance of all nodes from the current node)
            mark it's 1st element to 0
            find the topological sort for the graph
            For every vtx u in the topological sort
                TR through the connections of current node
                    if (dist of conection) > (dist of root) + (weight of current node)
                        update the distance of connection (as this is shorter than previous)
    */

    public static void shortestPath(int v) {
        
        Stack<Integer> stack = new Stack<>();

        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);

        topoSort(v, stack);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            // go to all the neightbours of the current node and update their distance
            for (int x : graph.get(curr)) {
                if (dis[x] > dis[curr] + weight[x]) {
                    dis[x] = dis[curr] + weight[x];
                }
            }
            
        }

        // print all the shortest distance o
        System.out.println(Arrays.toString(dis));
    }


    public static void topoSort(int v, Stack<Integer> stack) {
        boolean vis[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == false) {
                dfs(vis, stack, i);
            }
        }
    }

    public static void dfs(boolean vis[], Stack<Integer> stack, int source) {
        vis[source] = true;

        for (GraphNode x: graph.get(source)) {
            if (vis[x.data] == false) {
                dfs(vis, stack, x.data);
            }
        }

        stack.push(source);
    }
 
    public static void main(String[] args) {
        ShortestDistDAG obj = new ShortestDistDAG(6);
        addEdge(0,1,2);
        addEdge(0,4,1);
        addEdge(1,2,3);
        addEdge(4,2,2);
        addEdge(4,5,4);
        addEdge(2,3,6);
        addEdge(5,3,1);

        print();
        
    }

    public static void addEdge(int u, int v, int weight) {
        // Define a new node and add it to the AL
        GraphNode node = new GraphNode(v, weight);
        graph.get(u).add(node);
    }

    public static void print() {
        for (int i = 0; i < v; i++) {
            System.out.println(i + " ");

            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j).data + " ");
            }
            System.out.println();
        }
    } 

}

class GraphNode {
    int data;
    int weight;

    GraphNode(int d, int w) {
        data = d;
        weight = w;
    }
}






















