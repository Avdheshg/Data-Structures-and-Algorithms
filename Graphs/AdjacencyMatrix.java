public class AdjacencyMatrix {

    private boolean mat[][];
    private int v;

    // Initialize the matrix
    AdjacencyMatrix(int v) {
        this.v = v;
        mat = new boolean[v][v];
    }

    // add edges
    public void addEdge(int i, int j) {
        mat[i][j] = true;
        mat[j][i] = true;
    }

    // remove edge
    public void removeEdge(int i, int j) {
        mat[i][j] = false;
        mat[i][j] = false;
    }

    // print the matrix
    public void print() {
        for(int i = 0; i < mat.length; i++) {
            for (boolean x: mat[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        AdjacencyMatrix graph = new AdjacencyMatrix(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        graph.print();
    }

}