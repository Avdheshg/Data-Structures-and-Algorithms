import java.util.*;

public class LCS {

	static int count = 0;

	public static void main(String[] args) {
		
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";

		// System.out.println(naive(s1, s2, s1.length(),s2.length()));
		// System.out.println("Count : " + count);

		int len1 = s1.length();
		int len2 = s2.length();

		int memo[][] = new int[len1+1][len2+1];

		for (int[] row: memo) {
			Arrays.fill(row, -1);
		}

		System.out.println(memoRec(memo, s1, s2, len1, len2));
		// System.out.println(naive(s1, s2, len1, len2));
		System.out.println("Count : " + count);
	}

	// efficient
	public static int memoRec(int memo[][], String s1, String s2, int n, int m) {
		count++;
		if (memo[n][m] == -1) {

			if (n == 0 || m == 0) {
				memo[n][m] = 0;
			}
			if (s1.charAt(n-1) == (s2.charAt(m-1))) {
				
				memo[n][m] = 1 + memoRec(memo, s1, s2, n-1, m-1);

			} else {
				memo[n][m] =  Math.max(memoRec(memo, s1, s2, n, m-1),
											memoRec(memo, s1, s2, n-1, m));
			} 
		}
		return memo[n][m];
	}

	// Naive
	public static int naive(String s1, String s2, int len1, int len2) {

		count++;
		if (len1 == 0 || len2 == 0) {
			return 0;
		}
		if (s1.charAt(len1-1) == (s2.charAt(len2-1))) {
			
			return 1 + naive(s1, s2, len1-1, len2-1);
		} 
		return Math.max(naive(s1, s2, len1, len2-1),
						naive(s1, s2, len1-1, len2));
	}

}