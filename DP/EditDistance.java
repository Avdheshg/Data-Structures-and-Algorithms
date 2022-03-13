import java.util.*;

public class EditDistance {

	static int count = 0;

	public static void main(String[] args) {
			
		// String s1 = "intension";
		// String s2 = "execution"; 
		String s1 = "HORSE";
		String s2 = "ROS"; 
		// String s1 = "SATURDAY";
		// String s2 = "SUNDAY"; 

		int l1 = s1.length();
		int l2 = s2.length();

		// System.out.println(naiveRecursion(s1, s2, l1-1, l2-1));

		System.out.println(memoRec(s1, s2, l1, l2));
		System.out.println("Count: " + count);

	}

	/*
		Naive Algo: 
			If the last char matches
				reduce both the strings as no work required
			if doesn't matches
				apply all the 3 operations and check which is giving the min res
	*/
	public static int naiveRecursion(String s1, String s2, int l1, int l2) {
		count++;

		if (l1 == 0) {
			return l2;
		} 
		if (l2 == 0) {
			return l1;
		}

		if (s1.charAt(l1) == s2.charAt(l2)) {
			return naiveRecursion(s1, s2, l1-1, l2-1);
		
		} else {

			return 1 + Math.min(naiveRecursion(s1, s2, l1, l2-1), 
								Math.min(naiveRecursion(s1, s2, l1-1, l2),
										 naiveRecursion(s1, s2, l1-1, l2-1))
							  );

		}

	} 

	// M-2: Memoization
	/*
		If current char matches
			fill the current cell with the upper diagonal val
		If they don't match
			(fill the current cell with prev,dia upper,upper cell) + 1
		Now V need to fill every cell and V will go through the matrix row wise
		Last cell will be the answer

	*/
    public static int memoRec(String s1, String s2, int l1, int l2) {
        count++;
        
		int dp[][] = new int[l1+1][l2+1];

		for (int i = 0; i <= l1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= l2; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i-1][j], 
									Math.min(dp[i-1][j-1], 
											dp[i][j-1]));
				}
			}
		}
		return dp[l1][l2];
    }


}