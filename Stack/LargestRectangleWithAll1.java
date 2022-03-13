import java.util.*;

public class LargestRectangleWithAll1 {

	public static void main(String[] args) {
		
		// int arr[] = new int[]{6,2,5,4,1,5,6};
		// histoArea(arr);

		int mat[][] = new int[][]{
									{0,1,1,0},
									{1,1,1,1},
									{1,1,1,1},
									{1,1,0,0}
								};

		maxAreaOfOnes(mat);							

	}

	/*
		Each row of the matrix is a question of histogram itself => find max area of each row
		When V move to the next row, just go it and when find 1, update it 
	*/

	public static void maxAreaOfOnes(int mat[][]) {

		for (int row[]: mat) {
			System.out.println(Arrays.toString(row));
		}

		// finding the max area for row 0
		int maxArea = histoArea(mat[0]);

		for (int i = 1; i < mat.length; i++) {

			// traversing the ith row and incrementing the values of all the 1s
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					mat[i][j] = mat[i][j] + mat[i-1][j];
				}
			}

			// send this row as a separate question of histogram and find the maxArea in this
			int area = histoArea(mat[i]);
			maxArea = Math.max(maxArea, area);
			System.out.println("for the row: "+ i + " maxArea: " + area + " now the maxArea: " + maxArea);
		}

		System.out.println("maxArea: " + maxArea);
		// return maxArea;

	}

	public static int histoArea(int arr[]) {

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int len = arr.length;
		int maxArea = 0;

		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int top = stack.pop();
				int currArea = arr[top] * ( stack.isEmpty()? i : (i-stack.peek()-1) );

				maxArea = Math.max(maxArea, currArea);
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int currArea = arr[top] * ( stack.isEmpty()? len : (len-stack.peek()-1) );
			maxArea = Math.max(maxArea, currArea);
		}

		System.out.println("for "+ Arrays.toString(arr) + ", maxArea: " + maxArea);
		return maxArea;
	}
}





























