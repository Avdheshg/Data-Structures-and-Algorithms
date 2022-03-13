import java.util.*;

public class Dijkstras {

    /*
        Algo:
            V pick vtx 1 by 1 beginning from the source(why source: bcoz it is the min amoong all as V had set the dist of source as 0 [source to source] ) and V kept all the vtx as non finalised. 
            So V pick a min dist vtx and V relax it's adjancet 
                    relax: R V getting shorter path to it's connections through this finalised root

            Def a PQ and a dist[]
            mark the dist of root = 0
            Insert all the distance in PQ
            loop while Q is not empty 
                x = get the top of PQ (which will be the min val)
                relax all the adjacent of u that R not in PQ

            Here: O(v2)
                but using AL and min heap, O( (v+E)*logV )

    */

    public static int[] dijkstra(int graph[][], int src) {
        int v = graph.length;
        int dist[] = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        boolean fin[] = new boolean[v];    // finalised array

        for (int count = 0; count < v-1; count++) {
            int u = -1;

            for (int i = 0; i < v; i++) {
                // Here V R considering all the non finalised vtx and picking the vtx which has min dist val
                // not yet finalised and which have dist val is smaler than current u val or V don't have a u value so far in those cases V update the u as i
                if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }

                fin[u] = true;
                // here V R marking u as finalised and it will not be processed 
                // after finalising V relax all it's adjacent

                for (int j = 0; j < v; j++) {
                    if (!fin[j] && graph[u][j] != 0) {
                        dist[j] = Math.min(dist[j], dist[u] + graph[u][j]);
                        // here V R checking that R V getting shortest distance from u to v
                    }
                }
            }
        }

        return dist;
    }
}
