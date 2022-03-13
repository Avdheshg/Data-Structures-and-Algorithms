import java.util.*;

public class MinSpanningTree {

    /*  Here: O(V2) => but it can be minimised
        In this problem suppose V have some set of compyters and V want to connect them with shortest wire possible. V will be given with weighted, connected and undirected graph
        Spanning tree: No cycle and all the vertex should be connected. If there R V vtx then there should be (v-1) edges
        
        Naive: Generate all possible ST and find the min of those
        
        ********** Prim's Algo **********:
            This is a Greedy Algo
            V maintain 2 sets: Node which R in MST and Nodes which R not in MST and V need to move all the nodes from 2nd set to 1st
                For each node take that path which has least weight to it's connections

            V will use mSet[] to store the info about the nodes which R included in MST i.e if mSet[x] == true => this is included. Initially whole array is false

            How do V implement that part in which an edge in MST connect with not in MST
                V will use another array, key[]
                key[i] => will tell the key val for vtx i
                V initilise the whole array as INFINITE and key 0 as 0

            V will take the mSet[] and take those which has false val(nodes which R not connected) and then V will find the keys for them
            When V include a vtx => V include it into the MST set and after including it to the MST set V go to it's connections and update their key val if through this root V R getting smaller val

    */

    public static void MST(int graph[][], int v) {
        int key[] = new int[v], res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;

        boolean mSet[] = new boolean[v];

        for (int count = 0; count < v; count++){
            int u = -1;
            for (int i = 0; i < v; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }

            mSet[u] = true;
            res = res + key[u];

            for (int i = 0; i < v; i++) {
                if (!mSet[i] && graph[u][i] != 0 && graph[u][i] < key[i]) {
                    key[i] = graph[u][v];
                }
            }
        }

        // return res;
    }

}
