import java.util.*;

public class NthFibonacci {

	static int count = 0;

	public static void main(String[] args) {
		
		int n = 7;
		// int count = 0;

		int memo[] = new int[n+1];
		Arrays.fill(memo, -1);


		// System.out.println("NthFibonacci -> Recursion : " + naiveRec(n));
		// System.out.println("Recursion count : " + count);

		System.out.println("NthFibonacci -> Memoization : " + fib(n, memo));
		System.out.println("Recursion count : " + count);

		String s = "axyz";
		System.out.println("AXYZ : " + s.length());
	}

	public static int fib(int n, int memo[]) {
		count++;

		if (memo[n] == -1) {
			if (n == 0 || n == 1) {
				memo[n] = n;
			
			} else {

				memo[n] = fib(n-1, memo) + fib(n-2, memo);

			}
		}

		return memo[n];
	}

	public static int naiveRec(int n) {

		count++;

		if (n==1 || n==0) {
			return n;
		} 

		return naiveRec(n-1) + naiveRec(n-2);
	}
}