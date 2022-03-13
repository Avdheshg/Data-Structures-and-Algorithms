import java.util.*;

public class RatInMaze {

	static int sol[][] = new int[4][4];

	public static void main(String[] args) {
			
		int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } };
        int N = 3;
     	// System.out.println(rat(maze, 0, 0, N));

     	if (bt(maze, 0, 0, N)) {
     		printSol();
     	}
     	// System.out.println();

	}

	public static boolean bt(int maze[][], int i, int j, int N) {

		if (i == (N-1) && j == (N-1)) {
			sol[i][j] = 1;
			return true;
		}

		if (isSafe(maze, i, j, N)) {
			sol[i][j] = 1;

			if (maze[i][j+1] == 1) {
				return true;
			} else if (maze[i+1][j] == 1) {
				return true;
			}

			sol[i][j] = 0;
		}

		return false;


	}

	public static boolean isSafe(int maze[][], int i, int j, int N) {
		if (i < N && j < N && maze[i][j] == 1) {
			return true;
		}

		return false;
	}

	public static void printSol() {

		System.out.println("Sol Array ");

		for (int row[] : sol) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static boolean rat(int maze[][], int i, int j, int N) {

		if (i == N && j == N) {
			return true;
		}

		if (i >= N || j >= N || maze[i][j] == 0) {
			return false;
		} else {

			return rat(maze, i, j+1, N) || rat(maze, i+1, j, N);

		}



	}
}