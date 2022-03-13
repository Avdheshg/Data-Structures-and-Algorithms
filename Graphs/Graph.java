import java.util.*;

public class Graph {

	public static void main(String[] args) {
		
		/*
			1. Define an AL of AL
				At each index create a new AL
				Add some nodes 

			2.A function to add nodes in the graph 
			
			3. A function for printing the graph
		*/

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			graph.add(new ArrayList<>());
		}

		System.out.println("Graph successfull created");

		// For adding edges in the graph
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 4, 5);

		System.out.println("Edges added ");

		// For printing the graph
		printGraph(graph);
		
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


// ----------   Graph   ---------

// *****  BFS   ****************  

import java.util.*; 

class Graph { 

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 

	static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited) 
	{ 
    	visited[s]=true;
        System.out.print(s +" ");
        
        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFSRec(adj,u,visited);
        } 
	} 
	
	static void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s){
	    boolean[] visited=new boolean[V]; 
    		
        DFSRec(adj,s,visited);
	}

	public static void main(String[] args) 
	{  
		int V = 7; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0,1); 
        	addEdge(adj,0,2); 
        	addEdge(adj,2,3); 
        	addEdge(adj,1,3); 
        	addEdge(adj,1,4);
        	addEdge(adj,3,4);
		
		System.out.println("Following is Depth First Traversal: "); 
	    DFS(adj,V,0);
	} 
} 



// **********  Disconnected Graph 	****************
import java.util.*; 

class Graph { 

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 

	static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited) 
	{ 
    	visited[s]=true;
        System.out.print(s +" ");
        
        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFSRec(adj,u,visited);
        } 
	} 
	
	static void DFS(ArrayList<ArrayList<Integer>> adj, int V){
	    boolean[] visited=new boolean[V]; 
    		
        for(int i=0;i<V;i++){
            if(visited[i]==false)
                DFSRec(adj,i,visited);
        }
	}

	public static void main(String[] args) 
	{  
		int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0,1); 
        	addEdge(adj,0,2); 
        	addEdge(adj,1,2);
        	addEdge(adj,3,4);
		
		System.out.println("Following is Depth First Traversal for disconnected graphs: "); 
	    DFS(adj,V);
	} 
} 


// ****************  Number of Connected Components		****************
import java.util.*; 

class Graph { 

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 

	static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s, boolean[] visited) 
	{ 
    	visited[s]=true;
        
        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFSRec(adj,u,visited);
        } 
	} 
	
	static int DFS(ArrayList<ArrayList<Integer>> adj, int V){
	    boolean[] visited=new boolean[V]; int count=0;
    		
        for(int i=0;i<V;i++){
            if(visited[i]==false)
                {DFSRec(adj,i,visited);count++;}
        }
        return count;
	}

	public static void main(String[] args) 
	{  
		int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0,1); 
        	addEdge(adj,0,2); 
        	addEdge(adj,1,2);
        	addEdge(adj,3,4);
		
		System.out.println("Number of connected components: "+DFS(adj,V));
	} 
} 







































