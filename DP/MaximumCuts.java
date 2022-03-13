import java.util.*;

public class MaximumCuts {

	public static void main(String[] args) {
		
		// int n = 5, a = 1, b = 2, c = 3;
		int n = 17, a = 11, b = 10, c = 5;

		System.out.println(naiveRecursion(n, a, b, c));

	}

	public static int naiveRecursion(int n, int a, int b, int c) {

		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}

		else {
			return 1 + Math.max(naiveRecursion(n-a, a, b, c), 
								Math.max(naiveRecursion(n-b, a, b, c),
										naiveRecursion(n-c, a, b, c))
								);
		}

	}


}